<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="resources/css/myPageContent.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/applyMentor.css" />

</head>
<body>

	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">
			<div class="title">
				<h1>멘토 신청</h1>
				<hr width=140px align="left" />
			</div>

			<form action="applyMentor.do" method="post">
				<br> <br> <br>
				
				<div class="form-content">
					<input type="hidden" name="command"
						value="insertRes" />
	
					<div class="col">
						<div class="one">
							<label for="category"><b>지원 카테고리</b></label>
						</div>
						<div class="two">
							<select id="category" name="category">
								<option value="1">IT</option>
								<option value="2">교과목</option>
								<option value="3">미용/뷰티</option>
								<option value="4">언어</option>
								<option value="5">요리</option>
								<option value="6">자격증/시험</option>
								<option value="7">기타</option>
							</select>
						</div>
					</div>
	
					<br>
	
					<div class="row">
						<div class="one">
							<label for="member_id"><b>작성자 ID</b></label>
						</div>
						<div class="two">
							<input type="text" id="member_id" name="member_id"
								value="${user.member_id }" readonly required />
						</div>
					</div>
	
					<br>
	
					<div class="row">
						<div class="one">
							<label for="price"><b>희망 금액 (1시간 기준)</b></label>
						</div>
						<div class="two">
							<input type="text" id="price" name="price" placeholder="숫자만 입력해주세요" required />
						</div>
					</div>
	
					<br>
	
					<div class="row">
						<div class="one">
							<label for="content"><b>경력</b></label>
						</div>
						<div class="two">
							<textarea id="content" name="content" cols="50" rows="10"
								placeholder="내용을 입력하세요"></textarea>
						</div>
					</div>
	
					<br>
	
					<div class="row">
						<div class="one">
							<label for="how"><b>희망하는 수업방식</b></label>
						</div>
						<div class="two">
							<input type="radio" name="how" value="온라인" checked>온라인 <input
								type="radio" name="how" value="오프라인">오프라인
						</div>
					</div>
	
					<br>
	
					<div class="row">
	
						<div class="two">
							<input type="submit" value="제출" /> <input type="button"
								value="취소" onclick="location.href='index.jsp'" />
						</div>
					</div>
				</div>
				<br> <br> <br>

			</form>
		</div>

	</div>

</body>
</html>