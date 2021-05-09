<%@ page import="com.alam.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/myPageContent.css">
<link rel="stylesheet" type="text/css" href="resources/css/myPageTable.css">

<script type="text/javascript">
	function cancel(){
		if(confirm("정말 탈퇴 하시겠습니까?")) {
			location.href="mypage.do?command=cancel";
		}
	}
</script>

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">

			<h1>마이 페이지</h1>
			<hr width=168px align="left" />

			<br><br>

			<div class="inner">
				<table>
					<thead>
						<tr>
							<th>아이디</th>
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
							<td>${dto.member_name }</td>
							<td>${dto.member_email }</td>
							<td>${dto.member_phone }</td>
							<td>${dto.member_address }</td>
							<td>
								<c:choose>
									<c:when test="${dto.member_category == '1' }">
										IT
									</c:when>
									
									<c:when test="${dto.member_category == '2' }">
										교과목
									</c:when>
									
									<c:when test="${dto.member_category == '3' }">
										미용/뷰티
									</c:when>
									
									<c:when test="${dto.member_category == '4' }">
										언어
									</c:when>
									
									<c:when test="${dto.member_category == '5' }">
										요리
									</c:when>
									
									<c:when test="${dto.member_category == '6' }">
										자격증
									</c:when>
									
									<c:when test="${dto.member_category == '7' }">
										기타
									</c:when>
								</c:choose>	
							</td>
							<td>${dto.member_gender == 'M' ? '남' : '여' }</td>
							<td>${dto.member_grade == 'B' ? '멘티' : '멘토' }</td>
							
						</tr>
					</tbody>
				</table>
			</div>

			<input type="button" value="회원 탈퇴" onclick="cancel()">	<!-- 수정 -->
			<input type="button" value="정보 수정" onclick="location.href='mypage.do?command=updateProfile'">	<!-- 수정 -->

		</div>

	</div>
	
</body>
</html>