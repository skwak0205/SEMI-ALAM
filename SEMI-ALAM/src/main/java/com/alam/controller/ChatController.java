package com.alam.controller;

import static com.alam.controller.Send_SMS.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.alam.biz.ChatBiz;
import com.alam.dto.ChatDto;
import com.alam.dto.ChatMessageDto;
import com.alam.dto.LoginDto;

@WebServlet("/chat.do")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("(" + command + ")");

		ChatBiz biz = new ChatBiz();
		HttpSession session = request.getSession();

		LoginDto user = (LoginDto) session.getAttribute("user");
		String userId = user.getMember_id();

		if (command.equals("chatRoom")) {
			List<ChatDto> chatRoomList = biz.showChatRoom(userId);
			ChatMessageDto lastMsg = null;

			List<ChatMessageDto> listMsg = new ArrayList<ChatMessageDto>();

			for (ChatDto dto : chatRoomList) {
				if (dto != null) {
					lastMsg = biz.lastMsg(dto.getRoom_id());
					listMsg.add(lastMsg);
				}
			}

			request.setAttribute("chatRoomList", chatRoomList);
			request.setAttribute("listMsg", listMsg);
			dispatch(request, response, "chatting/chatRoom.jsp");

		} else if (command.equals("searchId")) {
			String searchId = request.getParameter("searchId");

			List<LoginDto> list = biz.searchId(searchId);

			List<JSONObject> objList = new ArrayList<>();

			if (list != null) {

				for (LoginDto dto : list) {
					if (!"A".equals(dto.getMember_grade()) && !userId.equals(dto.getMember_id())) {
						JSONObject obj = new JSONObject();
						obj.put("member_id", dto.getMember_id());
						obj.put("member_name", dto.getMember_name());
						obj.put("member_grade", dto.getMember_grade());

						objList.add(obj);
					}
				}
			}
			PrintWriter out = response.getWriter();
			out.println(objList);

		} else if (command.equals("checkRoom")) {

			String guest_Id = request.getParameter("guest_Id");

			ChatDto chat = new ChatDto();
			chat.setCreator_id(userId);
			chat.setGuest_id(guest_Id);

			ChatDto checkRoom = biz.checkChatRoom(chat);

			if (checkRoom == null) {
				String room_Id = numberGen(4, 1);

				ChatDto dto = new ChatDto(0, room_Id, userId, guest_Id, null);
				biz.createChat(dto);

				PrintWriter out = response.getWriter();
				out.println(room_Id);

			} else {
				PrintWriter out = response.getWriter();
				out.println(checkRoom.getRoom_id());
			}

		} else if (command.equals("chatting")) {
			
			String guest_Id = request.getParameter("guest_Id");
			String room_Id = request.getParameter("room_Id");

			List<ChatMessageDto> msgList = biz.showMessage(room_Id);

			ChatMessageDto dto = new ChatMessageDto();
			dto.setFrom_id(guest_Id);
			dto.setTo_id(userId);

			request.setAttribute("msgList", msgList);
			request.setAttribute("guest_Id", dto.getFrom_id());

			dispatch(request, response, "chatting/chat.jsp");

		} else if (command.equals("sendMsg")) {
			String room_Id = request.getParameter("room_Id");
			String from_Id = request.getParameter("from_Id");
			String to_Id = request.getParameter("to_Id");
			String text = request.getParameter("text");
			String time = request.getParameter("time");

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
			Date send_time = null;
			try {
				send_time = new Date(format.parse(time).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			ChatMessageDto dto = new ChatMessageDto(0, room_Id, from_Id, to_Id, text, send_time);

			int res = biz.saveMsg(dto);

			if (res <= 0) {
				System.out.println("실패");
			}

		} else if (command.equals("deleteChatRoom")) {
			String room_Id = request.getParameter("room_Id");

			int res = biz.deleteChatRoom(room_Id);
			if (res > 0) {
				jsResponse(response, "삭제 성공", "chat.do?command=chatRoom");
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
