<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

	<form action="classApply.do" method="post">
		<input type="hidden" name="command" value="updateRes" />
		<input type="hidden" name="class_apply_no" value="${dto.class_apply_no }" />
		
		<table border="1">
			<tr>
				<th>&lt;작성자&gt;</th>
				<td class="writer">${dto.class_apply_id }</td>
			</tr>
	
			<tr>
				<th>&lt;제목&gt;</th>
				<td class="title"><input type="text" name="class_apply_title" value="${dto.class_apply_title }" /></td>
			</tr>
	
			<tr>
				<th>&lt;내용&gt;</th>
				<td class="content"><textarea rows="15" cols="70" name="class_apply_content">${dto.class_apply_content }</textarea></td>
			</tr>
	
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정" /> 
					<input type="button" value="취소" onclick="location.href='classApply.do?command=classDetail&class_apply_no=${dto.class_apply_no}'" />
				</td>
			</tr>
		</table>
	
	</form>
	
	</div>

</body>
</html>