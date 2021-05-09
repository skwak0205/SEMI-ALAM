<%@ page import="com.alam.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/myPageContent.css">
<link rel="stylesheet" type="text/css" href="resources/css/myPageTable.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">

			<h1>정보 수정</h1>
			<hr width=168px align="left" />

			<br><br>

			<form action="mypage.do" method="post">
				<input type="hidden" name="command" value="updateRes" />
				
				<div class="inner">
					<table>
						<thead>
							<tr>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>이메일</th>
								<th>번호</th>
								<th>주소</th>
								<th>분야</th>
								<th>성별</th>
								<th>등급</th>
							</tr>
						</thead>
	
						<tbody>
							<tr>
								<td>${dto.member_id }</td>
								<td><input type="password" name="password" /></td>
								<td><input type="text" name="name" value="${dto.member_name }" /></td>
								<td><input type="email" name="email" value="${dto.member_email }" /></td>
								<td>${dto.member_phone }</td>
								<td>${dto.member_address }</td>
								<td>
									<input type="checkbox" name="category" value="1">IT
									<input type="checkbox" name="category" value="2">교과목
									<input type="checkbox" name="category" value="3">미용/뷰티
									<input type="checkbox" name="category" value="4">언어
									<input type="checkbox" name="category" value="5">요리
									<input type="checkbox" name="category" value="6">자격증/시험
									<input type="checkbox" name="category" value="7">기타
								</td>
								<td>
									<input required type="radio" name="gender" value="남" checked="${dto.member_gender == 'M' ? checked : '' }">남
									<input required type="radio" name="gender" value="여" checked="${dto.member_gender == 'F' ? checked : '' }">여
								</td>
								<td>${dto.member_grade == 'B' ? '멘티' : '멘토' }</td>
							</tr>
						</tbody>
					</table>
				</div>
	
				<input type="button" value="취소" onclick="location.href='mypage.do?command=myPage'">	
				<input type="submit" value="정보 수정">	
			</form>
		</div>

	</div>
	
</body>
</html>