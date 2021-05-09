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

import com.alam.biz.ClassApplyBiz;
import com.alam.dto.BoardDto;
import com.alam.dto.ClassApplyDto;
import com.alam.dto.LoginDto;

@WebServlet("/classApply.do")
public class ClassApplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String command = request.getParameter("command");
		System.out.println("("+command+")");
		
		ClassApplyBiz biz = new ClassApplyBiz();
		HttpSession session = request.getSession();

		LoginDto user = (LoginDto) session.getAttribute("user");
		/* String userId = ""; */
		
		if (command.equals("요청")) {
			if (user == null) {
				
				dispatch(request, response, "member_login.jsp");
				
			} else {
				dispatch(request, response, "class/classApplyBoard.jsp");				
			}
				
		} else if (command.equals("업로드")) {
			
			dispatch(request, response, "onlineClass/onlineClassUpload.jsp");
				
		} else if (command.equals("실시간")) {
			
			dispatch(request, response, "class/realTimeClassBoard.jsp");
				
		} else if (command.equals("온라인")) {
			
			dispatch(request, response, "onlineClass/onlineClassBoard.jsp");
				
		} else if (command.equals("insertRes")) {
			
			int category = Integer.parseInt(request.getParameter("category"));
			String member_id = request.getParameter("member_id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String how = request.getParameter("how");
			String loc = request.getParameter("loc");
			
			ClassApplyDto dto = new ClassApplyDto(0, category, member_id, title, content, how, loc, null);
			
			int res = biz.classInsert(dto);
			
			if(res > 0) {
				jsResponse(response, "제출 성공", "classApply.do?command="+category);
			} /* else {
				 jsResponse(response, "제출 실패", "classApply.do?command=boardInsert&category="+category);
			} */
	
		} else if(command.equals("1")) {
			
			int category = 1;
			
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
			
			dispatch(request, response, "class/itBoard.jsp");
			
		} else if(command.equals("2")) {
			
			int category = 2;
			
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
			
			dispatch(request, response, "class/schoolBoard.jsp");
			
		} else if(command.equals("3")) {
			
			int category = 3;
			
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
			
			dispatch(request, response, "class/beautyBoard.jsp");
			
		} else if(command.equals("4")) {
			
			int category = 4;
			
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
			
			dispatch(request, response, "class/languageBoard.jsp");
			
		} else if(command.equals("5")) {
	
			int category = 5;
	
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
	
			dispatch(request, response, "class/cookBoard.jsp");
	
		} else if(command.equals("6")) {
	
			int category = 6;
	
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);
	
			dispatch(request, response, "class/licenseBoard.jsp");
			
		} else if(command.equals("7")) {
	
			int category = 7;
	
			List<ClassApplyDto> list = biz.selectList(category);
			request.setAttribute("list", list);
			request.setAttribute("category", category);

			dispatch(request, response, "class/etcBoard.jsp");
	
		} else if (command.equals("classDetail")) {
			
			int class_apply_no = Integer.parseInt(request.getParameter("class_apply_no"));
			
			ClassApplyDto dto = biz.classDetail(class_apply_no);
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "class/classDetailBoard.jsp");
			
		} else if (command.equals("classUpdate")) {
			
			int class_apply_no = Integer.parseInt(request.getParameter("class_apply_no"));
			
			ClassApplyDto dto = biz.classDetail(class_apply_no);
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "class/classUpdate.jsp");

		} else if (command.equals("updateRes")) {
			
			int class_apply_no = Integer.parseInt(request.getParameter("class_apply_no"));
			System.out.println(class_apply_no);
			String class_apply_title = request.getParameter("class_apply_title");
			System.out.println(class_apply_title);
			String class_apply_content = request.getParameter("class_apply_content");
			System.out.println(class_apply_content);

			ClassApplyDto dto = new ClassApplyDto();
			dto.setClass_apply_no(class_apply_no);
			dto.setClass_apply_title(class_apply_title);
			dto.setClass_apply_content(class_apply_content);

			int res = biz.classUpdate(dto);
			
			if (res > 0) {
				jsResponse(response, "수정 성공", "classApply.do?command=classDetail&class_apply_no=" + class_apply_no);
			} else {
				jsResponse(response, "수정 실패", "classApply.do?command=classUpdate&class_apply_no=" + class_apply_no);
			}

		} else if (command.equals("classDelete")) {
			
			int category = Integer.parseInt(request.getParameter("category"));
			int class_apply_no = Integer.parseInt(request.getParameter("class_apply_no"));
			
			int res = biz.classDelete(class_apply_no);
			
			if (res > 0) {
				jsResponse(response, "삭제 성공", "classApply.do?command=" + category);
			} else {
				jsResponse(response, "삭제 실패", "classApply.do?command=classDetail&class_apply_no=" + class_apply_no);
			}

		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url + "';" + "</script>";
		response.getWriter().print(responseText);
	}

}
