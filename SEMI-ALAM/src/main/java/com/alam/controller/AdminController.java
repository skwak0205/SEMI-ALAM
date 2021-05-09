package com.alam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alam.biz.AdminBiz;
import com.alam.biz.BoardBiz;
import com.alam.biz.PaymentBiz;
import com.alam.dto.ApplyMentorDto;
import com.alam.dto.BoardDto;
import com.alam.dto.LoginDto;
import com.alam.dto.PaymentDto;

@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("[" + command + "]");

		AdminBiz biz = new AdminBiz();
		PaymentBiz paymentBiz = new PaymentBiz();

		HttpSession session = request.getSession();

		LoginDto user = (LoginDto) session.getAttribute("user");

		if (user == null) {
			dispatch(request, response, "member_login.jsp");
		} else {

			if (command.equals("adminMain")) {
				List<LoginDto> list = biz.memberListAll();
				request.setAttribute("list", list);
				dispatch(request, response, "admin/adminMain.jsp");

			} else if (command.equals("usersh")) {

				String query_ = request.getParameter("q");
				String query = "";

				if (query_ != null) {
					query = query_;
				}

				LoginDto dto = biz.searchId(query);
				request.setAttribute("dto", dto);

				dispatch(request, response, "admin/adminMain.jsp");

			} else if (command.equals("boardsh")) {

				String query_ = request.getParameter("q"); // 검색창에서 검색해서 받아온 ID

				String query = ""; // 실제로 db로 넘겨줄 변수
				if (query_ != null) {
					query = query_;
				}
				System.out.println(query);

				List<BoardDto> list = biz.searchList(query);
				request.setAttribute("list", list);
				System.out.println(list);
				dispatch(request, response, "admin/adminSearch.jsp");

			} else if (command.equals("admindel")) {

				String member_id = request.getParameter("member_id");

				int res = biz.adminDelMember(member_id);

				if (res > 0) {
					jsResponse(response, "삭제 성공", "admin.do?command=adminMain");
				} else {
					jsResponse(response, "삭제 실패", "admin.do?command=adminMain");
				}

			} else if (command.equals("complaint")) {
				List<BoardDto> listcpl = biz.adminComplaint();
				List<BoardDto> listask = biz.adminAsk();

				request.setAttribute("listcpl", listcpl);
				request.setAttribute("listask", listask);
				dispatch(request, response, "admin/adminComplaintask.jsp");
			
			} else if (command.equals("applyMentor")) {
				List<ApplyMentorDto> list = biz.apply_list();
				request.setAttribute("list", list);
				
				dispatch(request, response, "admin/adminApplyMentor.jsp");
			
			} else if (command.equals("payment")) {
				List<PaymentDto> list = paymentBiz.listAll();
				request.setAttribute("list", list);
				dispatch(request, response, "admin/adminPayment.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String res = "<script>" + "alert('" + msg + "');" + "location.href='" + url + "';" + "</script>";
		response.getWriter().append(res);
	}
}
