<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/classDetailBoard.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>DETAIL</h1>
		<hr width=170px align="left" />

		<table border="1">

			<tr>
				<th>&lt;작성자&gt;</th>
				<td class="writer">${dto.class_apply_id }</td>
			</tr>

			<tr>
				<th>&lt;제목&gt;</th>
				<td class="title">${dto.class_apply_title }</td>
			</tr>

			<tr>
				<th>&lt;내용&gt;</th>
				<td class="content"><textarea rows="15" cols="70" readonly="readonly">${dto.class_apply_content }</textarea></td>
			</tr>

			<tr>
				
				<td colspan="2" align="right">
					<c:if test="${user.member_id == dto.class_apply_id }">
						<input type="button" value="수정"
						onclick="location.href='classApply.do?command=classUpdate&class_apply_no=${dto.class_apply_no}'" />
						
						<input type="button" value="삭제"
						onclick="location.href='classApply.do?command=classDelete&class_apply_no=${dto.class_apply_no}&category=${dto.class_apply_category }'" />
				
					</c:if>
					
					<input type="button" value="목록"
					onclick="location.href='classApply.do?command=${dto.class_apply_category}'" />
				</td>
			</tr>

		</table>

	</div>

</body>
</html>