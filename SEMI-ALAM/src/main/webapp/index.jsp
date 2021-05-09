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
<title>ALAM : ANYTIME LEARN ANYWHERE MEET</title>



<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/index.js"></script>

</head>
<body>
	<%-- header 부분 --%>
	<jsp:include page="layout/header.jsp"></jsp:include>

	<br />
	<br />
	<br />
	<br />
	<br />

	<main class="container">
		<p style="font-size: 2.5em; text-align: center;">Anytime Learn
			Anywhere Meet</p>

		<br /> <br /> <br /> <br /> <br />

		<div class="search">

			<input type="text" id="text-input"> <span class="txt-rotate"
				data-period="2000"
				data-rotate='[ "IT", "교과목", "미용/뷰티", "언어", "요리", "자격증/시험", "기타" ]'></span>

			<button type="button">
				<img alt=""
					src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMCIgaGVpZ2h0PSIyMCIgdmlld0JveD0iMCAwIDIwIDIwIj4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZmlsbD0iI0Q4RDhEOCIgZmlsbC1vcGFjaXR5PSIwIiBkPSJNMCAwaDE4djE4SDB6Ii8+CiAgICAgICAgPHBhdGggZmlsbD0iIzMyMzIzMiIgZD0iTTE0Ljk0NCAxMy44ODdsNC44MzcgNC44MzhhLjc0Ny43NDcgMCAxIDEtMS4wNTYgMS4wNTZsLTQuODM4LTQuODM3YTguNDU4IDguNDU4IDAgMSAxIDEuMDU3LTEuMDU3em0tMS41MDUtLjU2M2E2Ljk2NCA2Ljk2NCAwIDEgMC0uMTE0LjExNC43NTUuNzU1IDAgMCAxIC4xMTQtLjExNHoiLz4KICAgIDwvZz4KPC9zdmc+Cg==" />
			</button>
		</div>

		<br /> <br /> <br /> <br /> <br />

		<div class="category">
			<h3>카테고리</h3>

			<br /> <br />

			<ul class="category">
				<li class="it"><a href="classApply.do?command=1"><img alt="IT"
						src="resources/image/it.png"><strong>IT</strong></a></li>
				<!-- 링크 -->
				<li class="subject"><a href="classApply.do?command=2"><img alt="교과목"
						src="resources/image/subject.png"><strong>교과목</strong></a></li>
				<!-- 링크 -->
				<li class="beauty"><a href="classApply.do?command=3"><img alt="미용/뷰티"
						src="resources/image/beauty.png"><strong>미용/뷰티</strong></a></li>
				<!-- 링크 -->
				<li class="language"><a href="classApply.do?command=4"><img alt="언어"
						src="resources/image/language.png"><strong>언어</strong></a></li>
				<!-- 링크 -->
				<li class="cook"><a href="classApply.do?command=5"><img alt="요리"
						src="resources/image/cook.png"><strong>요리</strong></a></li>
				<!-- 링크 -->
				<li class="license"><a href="classApply.do?command=6"><img alt="자격증/시험"
						src="resources/image/license.png"><strong>자격증/시험</strong></a></li>
				<!-- 링크 -->
				<li class="etc"><a href="classApply.do?command=7"><img alt="기타"
						src="resources/image/etc.png"><strong>기타</strong></a></li>
				<!-- 링크 -->
			</ul>
		</div>

		<br /> <br /> <br /> <br /> <br />

		<div class="rank">
			<h3>등급/랭킹</h3>
			<iframe src="rank.jsp" style="display:block; width:100%; height: 670px" frameborder="0" scrolling="no"></iframe>
		</div>

	</main>
	<%-- footer표시 --%>
	<jsp:include page="layout/footer.jsp"></jsp:include>

</body>
</html>