<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/realTimeClass.css">

<script type="text/javascript">

/* 필요한 함수 넣기 */

</script>

</head>
<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">

		<h1>요청 게시판</h1>
		<hr width=170px align="left" />

		<div class="small-box">
			<div class="one">
				<div class="jb-wrap"
					onclick="location.href='classApply.do?command=1';">
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
					onclick="location.href='classApply.do?command=2';">
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
					onclick="location.href='classApply.do?command=3';">
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
					onclick="location.href='classApply.do?command=4';">
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
					onclick="location.href='classApply.do?command=5';">
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
					onclick="location.href='classApply.do?command=6';">
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
					onclick="location.href='classApply.do?command=7';">
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