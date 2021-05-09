package com.alam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alam.biz.ApplyMentorBiz;
import com.alam.biz.MemberBiz;
import com.alam.biz.MemberBizImpl;
import com.alam.dto.ApplyMentorDto;


@WebServlet("/applyMentor.do")
public class ApplyMentorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("**" + command + "**");

		ApplyMentorBiz biz = new ApplyMentorBiz();
		
		if (command.equals("insertRes")) {
			int category = Integer.parseInt(request.getParameter("category"));
			String member_id = request.getParameter("member_id");
			int price = Integer.parseInt(request.getParameter("price"));
			String content = request.getParameter("content");
			String how = request.getParameter("how");
			
			ApplyMentorDto dto = new ApplyMentorDto(0, category, member_id, price, content, how, null);
			int res = biz.insert(dto);
			if(res > 0) {
				jsResponse(response, "제출 성공", "index.jsp");
			} else {
				jsResponse(response, "제출 실패", "admin/applyMentor.jsp");
			}
		} if (command.equals("approve")) {
			MemberBiz memberBiz = new MemberBizImpl();
			String member_id = request.getParameter("member_id");
			int res = memberBiz.approve(member_id);
			if(res>0) {
				jsResponse(response, "수락 성공", "admin.do?command=applyMentor");
				biz.deleteApproved(member_id);
			} else {
				jsResponse(response, "수락 실패", "admin.do?command=applyMentor");
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
		String responseText = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url
				+ "';" + "</script>";

		response.getWriter().print(responseText);
	}

}
