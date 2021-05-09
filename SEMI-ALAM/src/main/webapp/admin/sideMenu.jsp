<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
          <span onclick="location.href='admin.do?command=applyMentor'">멘토 신청 리스트</span>
          <span onclick="location.href='admin.do?command=payment'">구매 내역 리스트</span>
          <span onclick="location.href='admin.do?command=complaint'">신고 / 문의 조회</span>
        </div>
      </div>
    </div>
</body>
</html>