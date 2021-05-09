<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/sideMenu.css">

</head>
<body>
    <div class="side-container">
      <div class="side-bar">
        <div class="user-info">
        	<span style="cursor:pointer;" onclick="location.href='mypage.do?command=myPage'">
	          <i class="fas fa-user-astronaut fa-5x"></i>        	
        	</span>
          <span class="user-id">${user.member_id }</span>
        </div>
		
		<div class="menu-list">
			<c:choose>
				<c:when test="${user.member_grade == 'B' }">
			        <span onclick="location.href='mypage.do?command=paidList'">구매 목록</span>
			        <span onclick="location.href='mypage.do?command=myCalendar'">내 일정 보기</span>
			        <span onclick="location.href='mypage.do?command=videoChatList'">화상강의 목록</span>
			        <span onclick="location.href='mypage.do?command=applyMentor'">멘토 회원 신청</span>
			        <span onclick="location.href='mypage.do?command=myMap'">주변 카페</span>
				</c:when>
				
				<c:otherwise>
	          		<span onclick="location.href='mypage.do?command=paidList'">판매 / 구매 목록</span>
	          		<span onclick="location.href='mypage.do?command=videoChatList'">화상강의 목록</span>
	          		<span onclick="location.href='mypage.do?command=myCalendar'">내 일정 보기</span>
	          		<span onclick="location.href='mypage.do?command=myMap'">주변 카페</span>
				</c:otherwise>
			</c:choose>
		</div>

       </div>
     </div>
</body>
</html>