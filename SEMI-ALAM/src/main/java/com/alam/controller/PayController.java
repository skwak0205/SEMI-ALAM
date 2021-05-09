package com.alam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alam.biz.MemberBiz;
import com.alam.biz.MemberBizImpl;
import com.alam.biz.PaymentBiz;
import com.alam.dto.LoginDto;
import com.alam.dto.PaymentDto;


@WebServlet("/pay.do")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		LoginDto user = (LoginDto) session.getAttribute("user");
		String userId = user.getMember_id();
		
		MemberBiz memberBiz = new MemberBizImpl();
		PaymentBiz paymentBiz = new PaymentBiz();
		
		String command = request.getParameter("command");
		
		if(command.equals("payment")) {
			int upload_no = Integer.parseInt(request.getParameter("upload_no"));
			String title = request.getParameter("title");
			String upload_file = request.getParameter("upload_file");
			String seller_id = request.getParameter("uploader");
			int price = Integer.parseInt(request.getParameter("price"));
			int category = Integer.parseInt(request.getParameter("category"));
			
			LoginDto buyer = memberBiz.memberLoginSelectOne(userId);
			String buyer_tel = null;
			if( buyer.getMember_phone() == null) {
				buyer_tel = "010-0000-0000";
			} else {
				buyer_tel = buyer.getMember_phone();
			}
			
			PaymentDto payment = new PaymentDto(0, userId, buyer_tel, upload_no, seller_id, title, upload_file, price, category, null);
			
			PaymentDto paid = paymentBiz.checkPaid(payment);
			if(paid != null) {
				jsResponse(response, "이미 결제한 강의입니다.", "online.do?command=paid");
			} else {
				request.setAttribute("p", payment);
				dispatch(request, response, "payment/paying.jsp");				
			}
			
		
		} else if (command.equals("success")) {
			
			String buyer_id = request.getParameter("buyer_id");
			String buyer_tel = request.getParameter("buyer_tel");
			int class_no = Integer.parseInt(request.getParameter("class_no"));
			String seller = request.getParameter("seller");
			String title = request.getParameter("title");
			String file = request.getParameter("file");
			int price = Integer.parseInt(request.getParameter("price"));
			int category = Integer.parseInt(request.getParameter("category"));
			
			PaymentDto paid = new PaymentDto(0, buyer_id, buyer_tel, class_no, seller, title, file, price, category, null);
			int res = paymentBiz.paySuccess(paid);
			
			String c = getCategory(category);
			
			if(res > 0) {
				jsResponse(response, "결제 성공!", "online.do?command=paid");
			} else {
				jsResponse(response, "결제 실패!", "online.do?command=온라인");
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	private String getCategory(int c) {
    	switch(c) {
    	case 1:
    		return "it";
    	case 2:
    		return "school";
    	case 3:
    		return "beauty";
    	case 4:
    		return "language";
    	case 5:
    		return "cook";
    	case 6:
    		return "license";
    	case 7:
    		return "etc";
    	default:
    		return "it";
    	}
    }

}
