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
<link rel="stylesheet" href="resources/css/adminTable.css">
<link rel="stylesheet" type="text/css" href="resources/css/adminContent.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>
	
		<div class="content">
		
	
			<table class="table_shin" border="1">
				<caption>신고게시판</caption>
				<col width="100">
				<col width="100">
				<col width="200">
				<col width="300">
				<col width="300">
				<col width="50">
				<col width="100">
				<col width="50">
				<tr>
					<th>글번호</th>
					<th>글종류</th>
					<th>작성자ID</th>
					<th>글제목</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>글PW</th>
				</tr>
				<c:choose>
					<c:when test="${empty listcpl}">
						<tr>
							<td colspan="8">----------신고글 없음---------</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${listcpl }" var="dto">
							<tr>
								<td>${dto.board_no }</td>
								<td>${dto.board_category }</td>
								<td>${dto.board_main_id }</td>
								<td><a href="board.do?command=detail&board_no=${dto.board_no }">${dto.board_main_title }</a></td>
								<td>${dto.board_main_date }</td>
								<td>${dto.board_main_views }</td>
								<td>${dto.board_main_secret }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			
			<br>
			<hr>
			<br>
			
			<table class="table_moon" border="1">
				<caption>문의게시판</caption>
				<col width="100">
				<col width="100">
				<col width="200">
				<col width="300">
				<col width="300">
				<col width="50">
				<col width="100">
				<tr>
					<th>글번호</th>
					<th>글종류</th>
					<th>작성자ID</th>
					<th>글제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:choose>
					<c:when test="${empty listask}">
						<tr>
							<td colspan="8">----------문의글 없음---------</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${listask }" var="dto">
							<tr>
								<td>${dto.board_no }</td>
								<td>${dto.board_category }</td>
								<td>${dto.board_main_id }</td>
								<td><a href="board.do?command=detail&board_no=${dto.board_no }">${dto.board_main_title }</a></td>
								<td>${dto.board_main_date }</td>
								<td>${dto.board_main_views }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>

	
	
</body>
</html>