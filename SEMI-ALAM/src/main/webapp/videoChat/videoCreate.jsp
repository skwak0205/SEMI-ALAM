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

<link rel="stylesheet" href="resources/css/videoCreate.css">
<script type="text/javascript" src="resources/js/videoCreate.js"></script>
</head>
<body>

	<div>
		<%-- <jsp:include page="../layout/header.jsp"></jsp:include>--%>

		<div class="createVideo">

			<h1>화상 강의 방 만들기</h1>
			
			<form action="video.do" method="post">
				<input type="hidden" name="command" value="createRoom" />

				<div class="room">
					<input type='text' name='mentor_Id' value="${user.member_id }"
						readonly /> <input type='text' name='mentee_Id'
						placeholder='참여할 멘티 id를 쓰세요.' required /> 
						
					<input type='text'
						name='room_title' placeholder='방 제목을 쓰세요.' required /> 
						
					<input
						type='text' size='40' name='room_Id' id='uuid' required />

					<input type="button" value="방 만들기" onclick="show_uuid()" /> 
					
					<input
						id="create" type="submit" value="시작하기" /> 
						
					<input id="cancle"
						type="button" onclick="location.href='index.jsp'" value="취소" />
				</div>
			</form>
		</div>
	</div>


</body>
</html>