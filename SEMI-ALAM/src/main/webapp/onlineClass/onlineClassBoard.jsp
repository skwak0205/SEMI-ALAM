<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/realTimeClass.css">

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>온라인 강의</h1>
		<hr width=170px align="left" />

		<div class="small-box">
			<div class="one">
				<div class="jb-wrap"
					onclick="location.href='online.do?command=it';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT01.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>IT</p>
					</div>
				</div>

				<div class="jb-wrap"
					onclick="location.href='online.do?command=school';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT02.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>교과목</p>
					</div>
				</div>

				<div class="jb-wrap"
					onclick="location.href='online.do?command=beauty';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT03.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>미용/뷰티</p>
					</div>
				</div>
			</div>

			<br />

			<div class="two">
				<div class="jb-wrap"
					onclick="location.href='online.do?command=language';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT04.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>언어</p>
					</div>
				</div>

				<div class="jb-wrap"
					onclick="location.href='online.do?command=cook';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT05.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>요리</p>
					</div>
				</div>

				<div class="jb-wrap"
					onclick="location.href='online.do?command=license';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT06.jpg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>자격증/시험</p>
					</div>
				</div>
			</div>

			<br />

			<div class="three">
				<div class="jb-wrap"
					onclick="location.href='online.do?command=etc';">
					<div
						style="width: 200px; height: 180px; background: #A05C37; border: 4px solid #A05C37;">
						<img src="resources/image/RT07.jpeg" alt="">
					</div>
					<div
						style="width: 200px; height: 50px; background: #B98E69; border: 4px solid #A05C37;">
						<p>기타</p>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>