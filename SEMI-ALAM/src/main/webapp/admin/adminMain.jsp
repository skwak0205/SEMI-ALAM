<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="resources/css/adminTable.css">
<link rel="stylesheet" type="text/css" href="resources/css/adminContent.css">


</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>
	
		<div class="content">
		
			<h1>관리자 페이지</h1>
			<hr width=200px align="left" />
			
			<br/><br/>
	
			<form class="table-form" action="admin.do?" method="get">
				<input type="hidden" name="command" value="usersh">
				<fieldset>
					<legend class="hidden">&nbsp<b>검색 필드</b>&nbsp</legend>
					<label class="hidden">검색 분류</label> 
					<select name="f">
						<option value="userid">작성자ID</option>
					</select> 
					<label class="hidden">검색어</label>
					<input type="text" name="q" value="${param.q }" required/>			
					<input class="btn btn-search" type="submit" value="검색">
				</fieldset>
			</form>
			
			<br/><br/>
			
			<h2>&lt;검색 결과&gt;</h2>
			
			<table class="table_search" border="1">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>번호</th>
					<th>주소</th>
					<th>분야</th>
					<th>성별</th>
					<th>등급</th>
					<th>제명</th>
				</tr>
				<c:choose>
					<c:when test="${empty dto }">
						<tr>
							<td colspan="9">-----------해당 회원 없음-----------</td>
						</tr>
					</c:when>
					<c:otherwise>
							<tr>
								<td>${dto.member_id }</td>
								<td>${dto.member_name }</td>
								<td>${dto.member_email }</td>
								<td>${dto.member_phone }</td>
								<td>${dto.member_address }</td>
								<td>${dto.member_category }</td>
								<td>${dto.member_gender }</td>
								<td>${dto.member_grade }</td>
								<td><input type="button" value="제명" onclick="location.href='admin.do?command=admindel&member_id=${dto.member_id }'"></td>
							</tr>
					</c:otherwise>
				</c:choose>
			</table>
			
			<br>
			<hr class="my-hr3">
			<br><br><br>
			
			<h2>&lt;회원 전체 목록&gt;</h2>
			
			<table class="table_all" border="1">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				
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
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="8">----------회원이 없습니다----------</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list }" var="dto">
							<tr>
								<td>${dto.member_id }</td>
								<td>${dto.member_name }</td>
								<td>${dto.member_email }</td>
								<td>${dto.member_phone }</td>
								<td>${dto.member_address }</td>
								<td>${dto.member_category }</td>
								<td>${dto.member_gender }</td>
								<td>${dto.member_grade }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>		
		</div>
	
	</div>
</body>
</html>