<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/boardList.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
	
		<h1>문의사항</h1>
		<hr width=170px align="left" />

		<table border="1">
			<col width="179px" />
			<col width="323px" />
			<col width="223px" />
			<col width="99px" />

			<tr>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<th colspan="5">----------작성된 글이 존재하지 않습니다-----------</th>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.board_main_id }</td>
							<td><a
								href="board.do?command=detail&board_no=${dto.board_no }">${dto.board_main_title }</a>
							</td>
							<td class="name"><fmt:formatDate
									value="${dto.board_main_date }" pattern="yyyy-MM-dd h:mm a" /></td>
							<td>${dto.board_main_views }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

			<tr>
				<td colspan="5" align="center">
					<form class="search" action="board.do" method="post">
						<input type="hidden" name="command" value="boardSearch" />
						<input type="hidden" name="category" value="문의" /> 
						
						<select id="searchChoice" name="searchChoice">
							<option value="작성자">작성자</option>
							<option value="제목">제목</option>
							<option value="작성자+제목">작성자+제목</option>
						</select> 
						
						<input type="text" name="searchInput" />
						<button type="submit">검색</button>
					</form>
				</td>
			</tr>
			
			<c:if test="${user != null && user.member_grade != 'A' }">

				<tr>
					<td class="write" colspan="5" align="right">
						<input type="button" value="글작성" onclick="location.href='board.do?command=boardInsert&category=${category}'" />
					</td>
				</tr>
			</c:if>
		</table>

		<c:if test="${searchYn == null }">
		<div class="wrap">
			<span><a class="start" href="board.do?command=문의&currentPage=1">[처음]</a></span>
			<span><a class="prev" href="board.do?command=문의&currentPage=${prePage}">[이전]</a></span>
			<c:forEach begin="1" end="${maxPage}" step="1" var="page">
				<span class="page"><a href="board.do?command=문의&currentPage=${page}">${page}</a></span>
			</c:forEach>
			<span><a class="next" href="board.do?command=문의&currentPage=${nextPage}">[다음]</a></span>
			<span><a class="end" href="board.do?command=문의&currentPage=${maxPage}">[마지막]</a></span>
		</div>
	</c:if>
	
	<c:if test="${searchYn == 'y' }">
		<div class="wrap">
			<span><a class="start" href="board.do?command=boardSearch&currentPage=1&category=문의&searchInput=${searchInput}&searchChoice=${searchChoice}">[처음]</a></span>
			<span><a class="prev" href="board.do?command=boardSearch&currentPage=${prePage}&category=문의&searchInput=${searchInput}&searchChoice=${searchChoice}">[이전]</a></span>
			<c:forEach begin="1" end="${maxPage}" step="1" var="page">
				<span class="page"><a href="board.do?command=boardSearch&currentPage=${page}&category=문의&searchInput=${searchInput}&searchChoice=${searchChoice}">${page}</a></span>			
			</c:forEach>
			<span><a class="next" href="board.do?command=boardSearch&currentPage=${nextPage}&category=문의&searchInput=${searchInput}&searchChoice=${searchChoice}">[다음]</a></span>
			<span><a class="end" href="board.do?command=boardSearch&currentPage=${maxPage}&category=문의&searchInput=${searchInput}&searchChoice=${searchChoice}">[마지막]</a></span>
		</div>
	</c:if>

	</div>

</body>
</html>