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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<link rel="stylesheet" type="text/css" href="resources/css/chatRoom.css">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div class="background">
		<div class="chat-room">
			<div class="search">
				<div class="search-bar">
					<input type="hidden" id="user" value="${user.member_id }" />
					
					<span class="search-Icon">
	              		<i class="fas fa-search"></i>
	            	</span>
					
					<input type="text" id="search" required="required" placeholder="아이디를 검색하세요." />
					<button id="search-btn">검색</button>
				
				</div>
				
				<div class="search-result">
					<ul class="search-list">
						
					</ul>
				</div>
			</div>
		
			<div class="container">
				<c:choose>
					<c:when test="${empty chatRoomList }">
						<p class="empty">채팅이 없습니다.</p>
					</c:when>
		
					<c:otherwise>
						<c:forEach items="${chatRoomList }" var="dto" varStatus="status">
							<div class="chatList">
								<div class="chats" onclick="chatting(${status.index },'${dto.room_id }')">
									
		
									<div class="userInfo">
										<span class="username">${user.member_id == dto.creator_id ? dto.guest_id : dto.creator_id }</span>
										
											<c:forEach items="${listMsg }" var="msg">
												<c:if test="${dto.room_id == msg.room_id }">
													<span id="timestamp"><fmt:formatDate value="${msg.send_date }" pattern="MM-dd h:mm a"/></span>
													<p id="message">${msg.message }</p>
												</c:if>
											</c:forEach>
									</div>
								</div>
								
								<span class="deleteChatRoom" onclick="deleteChatRoom('${dto.room_id }')"><i class="fas fa-eraser"></i></span>
							</div>
						</c:forEach>
					</c:otherwise>	
				</c:choose>				
			</div>
		</div>
		
	</div>

	<script type="text/javascript" src="resources/js/chatRoom.js"></script>	

</body>
</html>