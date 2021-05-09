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

import com.alam.biz.VideoChatBiz;
import com.alam.dto.LoginDto;
import com.alam.dto.VideoDto;

@WebServlet("/video.do")
public class VideoChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("{" + command + "}");

		HttpSession session = request.getSession();
		VideoChatBiz biz = new VideoChatBiz();
		LoginDto user = (LoginDto) session.getAttribute("user");

		if (user == null) {
			dispatch(request, response, "member_login.jsp");
			
		} else {

			if (command.equals("videoCreate")) {
				dispatch(request, response, "videoChat/videoCreate.jsp");

			} else if (command.equals("createRoom")) {

				String mentor_id = user.getMember_id();
				String mentee_id = request.getParameter("mentee_Id");
				String room_id = request.getParameter("room_Id");
				String room_title = request.getParameter("room_title");

				VideoDto dto = new VideoDto(0, room_id, room_title, mentor_id, mentee_id, null);

				int res = biz.createRoom(dto);

				if (res > 0) {
					jsResponse(response, "방 생성 성공",
							"video.do?command=joinRoom&member_Id=" + mentor_id + "&room_Id=" + room_id);

				} else {
					jsResponse(response, "방 생성 실패", "video.do?command=videoCreate");
				}

			} else if (command.equals("joinRoom")) {
				dispatch(request, response, "videoChat/videoChat.jsp");
			
			} else if (command.equals("deleteRoom")) {
				String room_Id = request.getParameter("room_Id");
				int res = biz.deleteRoom(room_Id);
				if(res > 0) {
					jsResponse(response, "방 삭제 성공", "mypage.do?command=videoChatList");
				} else {
					jsResponse(response, "방 삭제 실패", "mypage.do?command=videoChatList");
				}
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
