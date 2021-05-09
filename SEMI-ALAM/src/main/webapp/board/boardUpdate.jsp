<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/boardDetail.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
	
		<h1>DETAIL</h1>
		<hr width=170px align="left" />
	
		<form action="board.do" method="post">
			<input type="hidden" name="command" value="updateRes" />
			<input type="hidden" name="board_no" value="${dto.board_no }" />
			
			<table border="1">
				<tr>
					<th>&lt;작성자&gt;</th>
					<td class="writer">${dto.board_main_id }</td>
				</tr>
		
				<tr>
					<th>&lt;제목&gt;</th>
					<td class="title"><input type="text" name="title" value="${dto.board_main_title }" /></td>
				</tr>
		
				<tr>
					<th>&lt;내용&gt;</th>
					<td class="content"><textarea rows="15" cols="70" name="content">${dto.board_main_content }</textarea></td>
				</tr>
		
				<tr>
					<td colspan="2" align="right">
					
						<input type="submit" value="수정" /> 
										
						<input type="button" value="취소"
							onclick="location.href='board.do?command=detail&board_no=${dto.board_no}'" />
					</td>
				</tr>
			</table>
		
		</form>
		
	</div>

</body>
</html>