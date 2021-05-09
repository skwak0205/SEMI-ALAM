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
</head>
<body>
	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<h1>관리자 글 조회</h1>
	
	<form class="table-form" action="admin.do" method="get">
		<input type="hidden" name="command" value="boardsh">
		<fieldset>
			<legend class="hidden">검색 필드</legend>
			<label class="hidden">검색 분류</label> 
			<select name="f">
				<option value="userid">작성자ID</option>
			</select> 
			<label class="hidden">검색어</label>
			<input type="text" name="q" value="${param.q }"/>
			<input class="btn btn-search" type="submit" value="검색">
	</fieldset>
	</form>
	<table border=1>
		<col width="100">
		<col width="200">
		<col width="200">
		<col width="300">
		<col width="300">
		<col width="50">
		<col width="200">
		<tr>
			<th>번호</th>
			<th>글종류</th>
			<th>작성자ID</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>글PW</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<th colspan="7">---------------해당 조회글 없음---------------</th>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<th>${dto.board_no }</th>
						<th>${dto.board_category }</th>
						<th>${dto.board_main_id }</th>
						<th>${dto.board_main_title }</th>
						<th>${dto.board_main_date }</th>
						<th>${dto.board_main_views }</th>
						<th>${dto.board_main_secret }</th>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>