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
	href="resources/css/adminContent.css">
	
<link rel="stylesheet" type="text/css"
	href="resources/css/adminApplyMentor.css">

</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">
			<h1>멘토 신청 리스트</h1>
			
			<div class="apply-lists">
			
				<c:choose>
					<c:when test="${empty list }">
							<p class="empty">----------작성된 글이 존재하지 않습니다-----------</p>
					</c:when>

					<c:otherwise>
						<c:forEach items="${list }" var="dto">							
							<div class="apply">
								<p>신청인 <span>${dto.apply_id }</span></p>
								<div class="detail">
									<p>카테고리 : ${dto.apply_category }</p>
									<p>희망 가격 : ${dto.apply_price }</p>
									<p>경력 : ${dto.apply_content }</p>
									<p>희망 수업 방식 : ${dto.apply_how }</p>
									<p>신청일 : <fmt:formatDate value="${dto.apply_date }"
										pattern="yyyy-MM-dd" /></p>
									<button onclick="location.href='applyMentor.do?command=approve&member_id=${dto.apply_id}'">수락</button>
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