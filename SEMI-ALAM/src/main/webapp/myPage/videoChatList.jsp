<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/myPageContent.css">
<link rel="stylesheet" type="text/css" href="resources/css/videoChatList.css">

</head>
<body>

	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">
			<h1>화상 강의 목록</h1>
			
			<div class="video-lists">
				<c:choose>
					<c:when test="${empty list }">
							<p class="empty">----------생성된 방이 존재하지 않습니다-----------</p>
					</c:when>

					<c:otherwise>
						<c:forEach items="${list }" var="dto">							
							<div class="video">
								<p>참여자 : <span>${user.member_id == dto.mentor_id ? dto.mentee_id : dto.mentor_id}</span></p>
								<div class="detail">
									<p>방제목 : <a href="video.do?command=joinRoom&member_Id=${user.member_id }&room_Id=${dto.room_id}">${dto.room_title }</a></p>
									<p>생성일 : <fmt:formatDate value="${dto.create_date }"
										pattern="yyyy-MM-dd" /></p>
									<button onclick="location.href='video.do?command=deleteRoom&room_Id=${dto.room_id}'">삭제</button>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>			
			</div>
		</div>
	</div>

</body>
</html>