package com.alam.controller;

import static com.alam.controller.PW_hasing.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.alam.biz.CalendarBiz;
import com.alam.biz.MemberBiz;
import com.alam.biz.MemberBizImpl;
import com.alam.biz.PaymentBiz;
import com.alam.biz.VideoChatBiz;
import com.alam.dto.CalendarDto;
import com.alam.dto.LoginDto;
import com.alam.dto.PaymentDto;
import com.alam.dto.VideoDto;

@WebServlet("/mypage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");
		System.out.println("**" + command + "**");

		HttpSession session = request.getSession();
		LoginDto user = (LoginDto) session.getAttribute("user");
		String userId = "";
		
		MemberBiz implBiz = new MemberBizImpl();
		VideoChatBiz videoBiz = new VideoChatBiz();
		CalendarBiz calendarBiz = new CalendarBiz();
		PaymentBiz paymentBiz = new PaymentBiz();

		if (user == null) {
			dispatch(request, response, "member_login.jsp");
		} else {
			userId = user.getMember_id();

			if (command.equals("myPage")) {

				if ("A".equals(user.getMember_grade())) {

					dispatch(request, response, "admin.do?command=adminMain");

				} else {
					LoginDto dto = implBiz.memberLoginSelectOne(userId);
					request.setAttribute("dto", dto);
					dispatch(request, response, "myPage/myPage.jsp");
				}

			} else if (command.equals("updateProfile")) {
				LoginDto dto = implBiz.memberLoginSelectOne(userId);
				request.setAttribute("dto", dto);
				dispatch(request, response, "myPage/updateProfile.jsp");
				
			} else if (command.equals("updateRes")) {
				String pw = request.getParameter("password");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String category = request.getParameter("category");
				String gender = request.getParameter("gender");
				
				LoginDto dto = new LoginDto();
				
				if(pw.equals("")) {
					LoginDto member = implBiz.memberLoginSelectOne(userId);
					dto.setMember_pw(member.getMember_pw());
				} else {
					String SALT = null;
					try {
						SALT = getSALT();
					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						dto.setMember_pw(Hashing(pw.getBytes(), SALT));
						dto.setMember_salt(SALT);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if ("남".equals(gender)) {
					dto.setMember_gender("M");
				} else if ("여".equals(gender)) {
					dto.setMember_gender("F");
				}
				
				dto.setMember_id(userId);
				dto.setMember_name(name);
				dto.setMember_email(email);
				dto.setMember_category(category);
				
				int res = implBiz.memberLoginUpdate(dto);
				if(res > 0) {
					dispatch(request, response, "mypage.do?command=myPage");
				} else {
					dispatch(request, response, "mypage.do?command=updateProfile");
				}
				
				
			} else if (command.equals("cancel")) {
				
				int res = implBiz.memberLoginDelete(userId);
				if(res > 0) {
					session.invalidate();
					dispatch(request, response, "index.jsp");
				} else {
					dispatch(request, response, "mypage.do?command=myPage");
				}
				
			}
			
			
			else if (command.equals("videoChatList")) {
				if ("B".equals(user.getMember_grade())) {
					List<VideoDto> list = videoBiz.showVideoRoom(user.getMember_id());
					request.setAttribute("list", list);
				
				} else {
					List<VideoDto> list = videoBiz.showVideoRoomMentor(user.getMember_id());
					request.setAttribute("list", list);
				}

				dispatch(request, response, "myPage/videoChatList.jsp");

			} else if (command.equals("myMap")) {
				dispatch(request, response, "myPage/mapPopUp.jsp");
			
			} else if (command.equals("applyMentor")) {
				dispatch(request, response, "myPage/applyMentor.jsp");
			
			} else if (command.equals("myCalendar")) {
				
				dispatch(request, response, "myPage/myCalendar.jsp");
			
			} else if (command.equals("insertCalendar")) {
				String title = request.getParameter("title");
				String start = request.getParameter("start");
				String end = request.getParameter("end");
				String allDay = "";
				
				
				if(request.getParameter("allDay").equals("true")) {
					allDay = "Y";
				} else {
					allDay = "N";
				}
				
				CalendarDto dto = new CalendarDto(0, user.getMember_id(), title, start, end, allDay);
				calendarBiz.insertCalendar(dto);
			
			} else if(command.equals("deleteCalendar")) {
				String title = request.getParameter("title");
				String start = request.getParameter("start");
				String end = request.getParameter("end");	
				
				CalendarDto dto = new CalendarDto();
				dto.setCalendar_id(user.getMember_id());
				dto.setCalendar_title(title);
				dto.setCalendar_start(start);
				dto.setCalendar_end(end);
				
				calendarBiz.deleteCalendar(dto);
			
			} else if(command.equals("calendarList")) {
				String start = request.getParameter("start");
				String end = request.getParameter("end");
				
				CalendarDto dto = new CalendarDto();
				dto.setCalendar_id(user.getMember_id());
				dto.setCalendar_start(start);
				dto.setCalendar_end(end);
				
				List<CalendarDto> list = calendarBiz.calendarList(dto);
				List<JSONObject> objList = new ArrayList<>();
				
				for(CalendarDto d : list) {
					JSONObject obj = new JSONObject();
					obj.put("member_id", d.getCalendar_id());
					obj.put("title", d.getCalendar_title());
					obj.put("start", d.getCalendar_start());
					obj.put("end", d.getCalendar_end());
					obj.put("allDay", d.getCalendar_allday());

					objList.add(obj);
				}
				PrintWriter out = response.getWriter();
				out.println(objList);
				
			} else if (command.equals("updateCalendar")) {
				String title = request.getParameter("title");
				String start = request.getParameter("start");
				String end = request.getParameter("end");
				
				System.out.println(start);
				System.out.println(end);
				
				CalendarDto dto = new CalendarDto(0, user.getMember_id(), title, start, end, null);
				calendarBiz.updateCalendar(dto);
			
			} else if (command.equals("paidList")) {
				List<PaymentDto> list = null;
				List<PaymentDto> paidList = null;
				if("B".equals(user.getMember_grade())) {
					list = paymentBiz.paidList(userId);					
				
				} else if ("S".equals(user.getMember_grade())) {
					list = paymentBiz.soldList(userId);
					paidList = paymentBiz.paidList(userId);	
				}
				
				if(paidList != null) {
					request.setAttribute("paidList", paidList);
				}
				
				request.setAttribute("list", list);
				dispatch(request, response, "myPage/paidList.jsp");
			
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

}
