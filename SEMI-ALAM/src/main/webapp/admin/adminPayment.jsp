<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/adminTable.css">
<link rel="stylesheet" type="text/css" href="resources/css/adminContent.css">

</head>
<body>

	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>
	
		<div class="content">
			<h1>온라인 강의 결제 목록</h1>
			<hr width=300px align="left" />
			
			<table class="table_all" border="1">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				<col width="10">
				
				<tr>
					<th>강의 번호</th>
					<th>판매자 ID</th>
					<th>구매자 ID</th>
					<th>강의 제목</th>
					<th>강의 가격</th>
					<th>강의 카테고리</th>
					<th>구매한 날짜</th>
				</tr>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="6">----------구매 내역이 없습니다----------</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list }" var="dto">
							<tr>
								<td>${dto.class_no }</td>
								<td>${dto.seller_id }</td>
								<td>${dto.buyer_id }</td>
								<td>${dto.class_title }</td>
								<td>${dto.class_price }</td>
								<c:choose>
										<c:when test="${dto.class_category == 1 }">
											<td>IT</td>
										</c:when>
										<c:when test="${dto.class_category == 2 }">
											<td>교과목</td>
										</c:when>
										<c:when test="${dto.class_category == 3 }">
											<td>미용/뷰티</td>
										</c:when>
										<c:when test="${dto.class_category == 4 }">
											<td>언어</td>
										</c:when>
										<c:when test="${dto.class_category == 5 }">
											<td>요리</td>
										</c:when>
										<c:when test="${dto.class_category == 6 }">
											<td>자격증/시험</td>
										</c:when>
										<c:otherwise>
											<td>기타</td>
										</c:otherwise>
								</c:choose>
								<td><fmt:formatDate value="${dto.buy_date }" pattern="yyyy-MM-dd h:mm a" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>		
		</div>
		
	</div>

</body>
</html>