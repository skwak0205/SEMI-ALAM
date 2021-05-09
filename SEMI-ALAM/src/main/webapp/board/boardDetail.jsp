<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css"
	href="resources/css/boardDetail.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
	
		<h1>DETAIL</h1>
		<hr width=170px align="left" />
	
		<table border="1">
			<tr>
				<th>작성자</th>
				<td class="writer">${dto.board_main_id }</td>
			</tr>
			
			<tr>
				<th>조회수</th>
				<td class="view">${dto.board_main_views }</td>
			</tr>
	
			<tr>
				<th>제목</th>
				<td class="title">${dto.board_main_title }</td>
			</tr>
	
			<tr>
				<th>내용</th>
				<td class="content">${dto.board_main_content }</td>
			</tr>
			
			<tr>
				<th></th>
				<%-- <td><video src="./${dto.board_main_fileid }"  controls></video></td> --%>
				<td class="file"><img src="./${dto.board_main_fileid }"></td>
			</tr>
	
			<tr>
				<td colspan="2" align="right">
				
					<c:if test="${dto.board_main_id == user.member_id }">
						<input type="button" value="수정" onclick="location.href='board.do?command=boardUpdate&board_no=${dto.board_no}'" /> 
						<input type="button" value="삭제" onclick="location.href='board.do?command=boardDelete&board_no=${dto.board_no}&category=${dto.board_category }'" /> 
					</c:if>
				
					<input type="button" value="목록"
						onclick="location.href='board.do?command=${dto.board_category}'" />
				</td>
			</tr>
		</table>
	
		<c:if test="${dto.board_category == '문의' || dto.board_category == '신고' }">
			<div class="reply-container">
			
				<div class="input">
					<form action="board.do" method="post">
						<input type="hidden" name="command" value="reply" /> 
						
						<input
							type="hidden" name="board_no" value="${dto.board_no }" /> 
							
						<input
							type="hidden" name="board_category" value="${dto.board_category }" />
		
						<c:if test="${user.member_id == dto.board_main_id || user.member_grade == 'A'}">
						
							<input type="text" name="replyContent" placeholder="답변을 적어주세요." />
							<button type="submit">답변 달기</button>
						</c:if>
					</form>
				</div>
			
				<ul class="replyList">
					<c:choose>
						<c:when test="${empty replyList }">
							
						</c:when>
						
						<c:otherwise>
							<c:forEach items="${replyList }" var="reply">
								
								<c:if test="${reply.board_no == dto.board_no}">
									<li>
										<span>${reply.reply_id }</span>
										<span>${reply.reply_content }</span>
										<span><fmt:formatDate value="${reply.reply_date }" pattern="yyyy-MM-dd h:mm a"/></span>
									</li>
								</c:if>
								
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
		
			</div>
		</c:if>
		
	</div>

</body>
</html>