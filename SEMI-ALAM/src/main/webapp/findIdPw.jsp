<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/findIdPw.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/findIdPw.js"></script>

</head>
<body>
	<jsp:include page="layout/header.jsp"></jsp:include>
	
		<div class="find">
			<h2>아이디/비밀번호 찾기</h2>
			
			<p id="error"></p>
		
			<div class="findIdPw">
				<span>아이디 찾기</span>
				
				<input id="name" name="name" placeholder="이름" required />
				
				<div class="row">
					<input id="id_phoneNum" name="phoneNum" placeholder="번호 '-' 없이 입력하세요" required />
					<button id="send" onclick="checkUser()">인증번호 보내기</button>	
				</div>
				
				<div class="row">
					<input id="confirmNum" name="confirmNum" required />
					<button id="confirm" onclick="confirm()">확인</button>	
				</div>
				
				<p id="showId"></p>
			</div>
			
			<div class="findIdPw">
				<span>비밀번호 찾기</span>
				
				<input id="member_id" name="member_id" placeholder="아이디" required />
				
				<div class="row">
					<input id="pw_phoneNum" placeholder="번호 '-' 없이 입력하세요" required />
					<button onclick="checkUser()">인증번호 보내기</button>	
				</div>
				
				<div class="row">
					<input id="pw_confirmNum" name="confirmNum" required />
					<button id="pw_confirm" onclick="confirm()">확인</button>	
				</div>
				
				<p id="showPw"></p>
				
				<div id="changePw">
					<input id="newPw" type="password" placeholder="새 비밀번호" required />
					<input id="checkNewPw" type="password" placeholder="새 비밀번호 확인" required />
					<button onclick="updatePw()">비밀번호 변경</button>
				</div>
				
			</div>
		</div>
	
</body>
</html>