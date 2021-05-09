<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	href="resources/css/boardList.css">

<script type="text/javascript">
	function putPW(board_no, id) {
		open("board.do?command=checkPW&board_no=" + board_no + "&id=" + id, "",
				"width=200, height=200");
	};
</script>

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>신고사항</h1>
		<hr width=170px align="left" />

		<table border="1">

			<tr>
				
				<th class="writer">작성자</th>
				<th class="title">제목</th>
				<th class="date">작성일</th>
			</tr>

			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th colspan="4">----------작성된 글이 존재하지 않습니다-----------</th>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach items="${list }" var="dto" varStatus="status">
						<tr>
							
							<td>${dto.board_main_id }</td>
							<td><span class="title" style="cursor: pointer;"
								onclick="putPW('${dto.board_no }', '${dto.board_main_id }')">----------이
									글은 비밀글입니다.----------</span></td>
							<td><fmt:formatDate value="${dto.board_main_date }"
									pattern="yyyy-MM-dd h:mm a" /></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

			<c:if test="${user != null && user.member_grade != 'A' }">
				<tr>
					<td class="write" colspan="4" align="right"><input
						type="button" value="글작성"
						onclick="location.href='board.do?command=boardInsert&category=${category}'" />
					</td>
				</tr>
			</c:if>

		</table>

		<div class="wrap">
			<span>
				<a class="start" href="board.do?command=신고&currentPage=1">[처음]</a>
			</span> 
			
			<span>
				<a class="prev" href="board.do?command=신고&currentPage=${prePage}">[이전]</a>
			</span>
			
			<c:forEach begin="1" end="${maxPage}" step="1" var="page">
				<span class="page">
					<a href="board.do?command=신고&currentPage=${page}">${page}</a></span>
			</c:forEach>
			
			<span>
				<a class="next" href="board.do?command=신고&currentPage=${nextPage}">[다음]</a>
			</span> 
			
			<span>
				<a class="end" href="board.do?command=신고&currentPage=${maxPage}">[마지막]</a>
			</span>
		</div>

	</div>

</body>
</html>