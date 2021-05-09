<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	href="resources/css/anyTypeBoard.css">

</head>
<body>
	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>구매한 강의</h1>
		<hr width=170px align="left" />

		<c:set var="i" value="0" />
		<c:set var="j" value="3" />
		<table border="1">
			<c:choose>

				<c:when test="${empty list }">
					<tr>
						<th colspan="4">----------구매한 강의가 존재하지 않습니다-----------</th>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach items="${list }" var="dto" varStatus="status">
						<c:if test="${i%j == 0 }">
							<tr>
						</c:if>
						<td class="video"><video src="./${dto.class_video }" controls ></video>
							<div class="info">
								글 제 목 : <span class="title">${dto.class_title }</span><br /> 
								작 성 자 : <span class="id">${dto.seller_id }</span><br /> 
								결 제 액 : <span class="price">${dto.class_price }</span>원<br />

							</div></td>
						<c:if test="${i%j == j-1 }">
							</tr>
						</c:if>
						<c:set var="i" value="${i+1 }" />
					</c:forEach>
				</c:otherwise>

			</c:choose>

		</table>

	</div>
</body>
</html>