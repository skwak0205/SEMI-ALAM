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

<script type="text/javascript">

function payment(idx, upload_no, upload_file, upload_category) {
	
	var title = document.getElementsByClassName("title")[idx].innerText;
	var uploader = document.getElementsByClassName("id")[idx].innerText;
	var price = document.getElementsByClassName("price")[idx].innerText;
	
	location.href="pay.do?command=payment&upload_no="+upload_no+"&title="+title+"&uploader="+uploader+"&price="+price+"&upload_file="+upload_file+"&category="+upload_category;
}

function deleteVideo(upload_no) {
	location.href="online.do?command=delete&upload_no="+upload_no;
}


</script>

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>IT</h1>
		<hr width=170px align="left" />

		<c:set var="i" value="0" />
		<c:set var="j" value="3" />
		<table border="1">
			<c:choose>

				<c:when test="${empty list }">
					<tr>
						<th colspan="4">----------업로드된 영상이 존재하지 않습니다-----------</th>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach items="${list }" var="dto" varStatus="status">
						<c:if test="${i%j == 0 }">
							<tr>
						</c:if>
						<td class="video"><video src="./${dto.upload_file_name }"
								${dto.upload_no == payList[status.index].class_no ? 'controls' : '' }></video>
							<div class="info">
								글 제 목 : <span class="title">${dto.upload_title }</span><br /> 
								작 성 자 : <span class="id">${dto.upload_id }</span><br /> 
								결 제 액 : <span class="price">${dto.upload_price }</span>원<br />
								
								<c:if test="${user != null && user.member_id != dto.upload_id}">
									<input type="button"
										onclick="payment(${status.index }, '${dto.upload_no }', '${dto.upload_file_name }', '${dto.upload_category }')"
										value="결제" />
								</c:if>
								
								<c:if test="${user != null && user.member_id == dto.upload_id}">
									<input type="button"
										onclick="deleteVideo('${dto.upload_no }')"
										value="삭제" style="background-color:red; color:white;" />
								</c:if>
							</div></td>
						<c:if test="${i%j == j-1 }">
							</tr>
						</c:if>
						<c:set var="i" value="${i+1 }" />
					</c:forEach>
				</c:otherwise>

			</c:choose>

			<tr>
				<td class="write" colspan="4" align="right"><c:if
						test="${user != null && user.member_grade == 'S' }">
						<input type="button" value="글작성"
							onclick="location.href='classApply.do?command=업로드'" />
					</c:if> <input type="button" value="목록"
					onclick="location.href='classApply.do?command=온라인'" /></td>
			</tr>

		</table>

	</div>

</body>
</html>