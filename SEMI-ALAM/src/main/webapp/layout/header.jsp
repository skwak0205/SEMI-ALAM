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

	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

	<link rel="stylesheet" href="resources/css/header.css">
	
	<script type="text/javascript">
	
		function chatRoom() {
			open("chat.do?command=chatRoom", "", "width=350, height=500");
		};
		
	</script>

</head>
<body>

	<header>
		<h1 id="logo" onclick="location.href='index.jsp'">ALAM</h1>
		
		<nav>

			<c:choose>
				<c:when test="${empty user.member_id }">
					<ul class="menu">
					
						<li class="menu1">강의
							<ul class="menu1 submenu">
								<li><a href="classApply.do?command=요청">강의 요청</a></li>
								<!-- 링크 -->
								<li><a href="classApply.do?command=실시간">요청 게시판</a></li>
								<!-- 링크 -->
								<li><a href="online.do?command=온라인">온라인 강의</a></li>
								<!-- 링크 -->
							</ul>
						</li>
						
						<li class="menu2">고객센터
							<ul class="menu2 submenu">
								<li><a href="board.do?command=공지&currentPage=1">공지사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=문의&currentPage=1">문의사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=신고&currentPage=1">신고사항</a></li>
								<!-- 링크 -->
							</ul>
						</li>
					
						<li class="menu3"><a href="member_register.jsp">회원가입</a></li>
						<!-- 링크 -->
						<li class="menu4"><a href="member_login.jsp">로그인</a></li>
						<!-- 링크 -->
					</ul>
				</c:when>
				
				<c:when test="${user.member_grade == 'A' }">
					<ul class="menu">
						<li class="menu2">고객센터
							<ul class="menu2 submenu">
								<li><a href="board.do?command=공지&currentPage=1">공지사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=문의&currentPage=1">문의사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=신고&currentPage=1">신고사항</a></li>
								<!-- 링크 -->
							</ul>
						</li>
						
						<li style="cursor:pointer;"><a href="mypage.do?command=myPage">${user.member_name }님</a></li> 
						
						<li><a href="member.do?command=logout">로그아웃</a></li>
					</ul>
				
				</c:when>

				<c:otherwise>
					<ul class="menu">
						<li class="menu1">강의
							<ul class="menu1 submenu">
								<c:if test="${user.member_grade == 'B' }">

									<li><a href="classApply.do?command=요청">강의 요청</a></li>
									<!-- 링크 -->
								</c:if>
								
								<c:if test="${user.member_grade == 'S' }">

									<li><a href="online.do?command=upload">강의 업로드</a></li>
									<!-- 링크 -->
								</c:if>
								
								<li><a href="classApply.do?command=실시간">요청 게시판</a></li>
								<!-- 링크 -->
								<li><a href="online.do?command=온라인">온라인 강의</a></li>
								<!-- 링크 -->
								<li><a href="online.do?command=paid">구매한 강의</a></li>
								<!-- 링크 -->
							</ul>
						</li>
						<li class="menu2">고객센터
							<ul class="menu2 submenu">
								<li><a href="board.do?command=공지">공지사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=문의">문의사항</a></li>
								<!-- 링크 -->
								<li><a href="board.do?command=신고">신고사항</a></li>
								<!-- 링크 -->
							</ul>
						</li>
						
						
						<c:if test="${user.member_grade == 'S' }">
							<li><span title="화상채팅" onclick="location.href='video.do?command=videoCreate'" class="chat-icon"><i class="fas fa-video"></i></span></li>					
						</c:if>
						
						
						
						<li><span title="채팅" onclick="chatRoom()" class="chat-icon"><i class="fas fa-comment-dots"></i></span></li>
						
						<li style="cursor:pointer;"><a href="mypage.do?command=myPage">${user.member_name }님</a></li> 
						
						<li><a href="member.do?command=logout">로그아웃</a></li>
					</ul>
					
				</c:otherwise>
			</c:choose>
		</nav>
	</header>

</body>
</html>