package com.alam.controller;

import static com.alam.controller.Send_SMS.*;
import static com.alam.controller.PW_hasing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.alam.biz.MemberBiz;
import com.alam.biz.MemberBizImpl;
import com.alam.dto.LoginDto;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		MemberBiz biz = new MemberBizImpl();
		String command = request.getParameter("command");

		System.out.println("[" + command + "]");

		HttpSession session = request.getSession();

		if (command.equals("login")) {
			LoginDto dto = new LoginDto();

			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			
			String temp_salt = "";
			String temp_pass = "";
			
			LoginDto salt = biz.getSalt(member_id);
			if(salt == null) {
				jsResponse(response, "로그인 실패!", "member_login.jsp");
			} else {
				temp_salt = salt.getMember_salt();				
			}
			
			
			try {
				temp_pass = Hashing(member_pw.getBytes(), temp_salt);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			dto.setMember_id(member_id);
			dto.setMember_pw(temp_pass);

			LoginDto loginDto = biz.memberLogin(dto);

			if (loginDto != null) {
				session.setAttribute("user", loginDto);
				session.setMaxInactiveInterval(60 * 60);

				if ("A".equals(loginDto.getMember_grade())) {
					request.setAttribute("dto", loginDto);
					dispatch(request, response, "index.jsp?member_id=" + loginDto.getMember_id());

				} else if ("B".equals(loginDto.getMember_grade())) {
					request.setAttribute("dto", loginDto);
					dispatch(request, response, "index.jsp?member_id=" + loginDto.getMember_id());

				} else if ("S".equals(loginDto.getMember_grade())) {
					request.setAttribute("dto", loginDto);
					dispatch(request, response, "index.jsp?member_id=" + loginDto.getMember_id());
				}

			} else {
				jsResponse(response, "로그인 실패!", "member_login.jsp");
			}

		} else if (command.equals("logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");

		} else if (command.equals("idchk")) {

			String member_id = request.getParameter("member_id");

			LoginDto dto = biz.idCheck(member_id);

			boolean idnotused = true;

			if (dto != null) {
				idnotused = false;
			}

			response.sendRedirect("idchk.jsp?idnotused=" + idnotused);

		} else if (command.equals("memberLoginInsert")) {

			int res = 0;

			LoginDto dto = new LoginDto();

			String loginId_Yn = "";

			String member_id = "";
			String member_pw = "";
			String member_name = "";
			String member_email = "";
			String member_phone = "";
			String member_gender = "";
			String member_category = "";
			String member_address = "";
			
			
			if (request.getParameter("member_id") != null) {
				member_id = request.getParameter("member_id");
			}

			if (request.getParameter("member_pw") != null) {
				member_pw = request.getParameter("member_pw");
			}

			if (request.getParameter("member_name") != null) {
				member_name = request.getParameter("member_name");
			}

			if (request.getParameter("member_email") != null) {
				member_email = request.getParameter("member_email");
			}

			if (request.getParameter("member_phone") != null) {
				member_phone = request.getParameter("member_phone");
			}

			if (request.getParameter("member_gender") != null) {
				member_gender = request.getParameter("member_gender");

				if ("남".equals(member_gender)) {
					dto.setMember_gender("M");
				} else if ("여".equals(member_gender)) {
					dto.setMember_gender("F");
				}
			}

			if (request.getParameter("member_category") != null) {
				member_category = request.getParameter("member_category");
			}

			if (request.getParameter("sample6_postcode") != null) {
				member_address = request.getParameter("sample6_postcode");
				member_address += "" + request.getParameter("sample6_address");
				member_address += request.getParameter("sample6_detailAddress");
			}

			dto.setMember_id(member_id);
			dto.setMember_pw(member_pw);
			dto.setMember_name(member_name);
			dto.setMember_email(member_email);
			dto.setMember_phone(member_phone);
			dto.setMember_address(member_address);
			dto.setMember_category(member_category);
			dto.setMember_grade("B");
			
			String SALT = null;
			try {
				SALT = getSALT();
			} catch (Exception e) {
				e.printStackTrace();
			}

			dto.setMember_id(member_id);
			try {
				dto.setMember_pw(Hashing(member_pw.getBytes(), SALT));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setMember_salt(SALT);

			loginId_Yn = biz.memberLoginIdYn(member_id);
			
			if ("Y".equals(loginId_Yn)) {
				jsResponse(response, "로그인 성공",
						"member.do?command=login&member_id=" + member_id + "&member_pw=" + member_pw);
			} else {
				res = biz.memberLoginInsert(dto);

				if (res > 0) {
					jsResponse(response, "회원가입 성공", "index.jsp");
				} else {
					jsResponse(response, "회원가입 실패", "member_register.jsp");

				}
			}
			
		} else if (command.equals("phoneConfirm")) {
			String phoneNum = request.getParameter("phoneNum");
			String num = numberGen(4, 1);

			PrintWriter out = response.getWriter();
			out.println(num);

			sendSMS(phoneNum, num);	
		
		} else if (command.equals("checkUser")) {
			String member = request.getParameter("member");
			String phoneNum = request.getParameter("phoneNum");
			String id_pw = request.getParameter("id_pw");
			
			LoginDto dto = new LoginDto();
			
			if(id_pw.equals("id")) {
				dto.setMember_name(member);
				dto.setMember_phone(phoneNum);				
			} else if(id_pw.equals("pw")) {
				dto.setMember_id(member);
				dto.setMember_phone(phoneNum);
			}
			
			PrintWriter out = response.getWriter();
			
			LoginDto user = biz.checkUser(dto);
						
			if(user != null) {
				String num = numberGen(4, 1);

				JSONObject obj = new JSONObject(); 
				obj.put("confirm", num);
				obj.put("member_id", user.getMember_id());
								
				out.println(obj.toJSONString());
				
				sendSMS(phoneNum, num);	
			} else {
				JSONObject obj = new JSONObject(); 
				obj.put("confirm", "존재하지 않는 회원입니다.");
				out.println(obj.toJSONString());
			}
			
		} else if(command.equals("updatePw")) {
			String member = request.getParameter("member");
			String newPw = request.getParameter("newPw");
			
			LoginDto dto = new LoginDto();
			
			String SALT = null;
			try {
				SALT = getSALT();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				dto.setMember_pw(Hashing(newPw.getBytes(), SALT));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			dto.setMember_salt(SALT);
			dto.setMember_id(member);
			
			int res = biz.updatePw(dto);
			if(res > 0) {
				jsResponse(response, "비밀번호 변경 성공", "member_login.jsp");
			} else {
				jsResponse(response, "비밀번호 변경 실패", "findIdPw.jsp");
			}
		}
	}

	private void dispatch(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void jsResponse(HttpServletResponse response, String msg, String url) throws IOException {
		String responseText = "<script type='text/javascript'>" + "alert('" + msg + "');" + "location.href='" + url
				+ "';" + "</script>";
		response.getWriter().print(responseText);
	}

	

}
