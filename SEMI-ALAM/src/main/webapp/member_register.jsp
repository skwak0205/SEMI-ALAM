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

<link rel="stylesheet" type="text/css" href="resources/css/register.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript" src="resources/js/register.js"></script>

</head>
<body>

	<div style="position: relative; z-index: 1;">
		<img src="resources/image/siba.png" id="bg" alt="">
	</div>

	<div style="position: relative; top: 25px; z-index: 2;">

		<div id="register">
			<br />
			<br />
			<h1>ALAM</h1>
			<br />
			<h3>ALAM 가입을 시작합니다!</h3>
			<br />
		</div>
		<form action="member.do?command=memberLoginInsert" method="post"
			id="registerForm">
			<table border="1">
				<tr>
					<th>ID</th>
					<td><input type="text" name="member_id" title="n" required />
						<input type="button" value="중복체크" onclick="idCheck();" /></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="member_pw" required
						onclick="idCheckConfirm();" /></td>
				</tr>
				<tr>
					<th>NAME</th>
					<td><input type="text" name="member_name" required
						onclick="idCheckConfirm();" /></td>
				</tr>
				<tr>
					<th>EMAIL</th>
					<td><input type="email" name="member_email" required
						onclick="idCheckConfirm();" /></td>
				</tr>
				<tr>
					<th>PHONE</th>
					<td><input type="text" id="member_phone" name="member_phone"
						placeholder="-없이 입력하세요" required onclick="idCheckConfirm();" /> <input
						type="button" id="phone_btn" value="인증번호 전송" />
					
						<div style="color: red;" id="errorPhone"></div>
					</td>
				</tr>

				<tr>
					<th>인증번호</th>
					<td><input type="text" id="member_phoneConfirm" title="n"
						required onclick="idCheckConfirm();" /> <input type="button"
						id="confirm_btn" value="확인" onclick="checkPhone()" />
						<div style="color: red;" id="error"></div></td>
				</tr>

				<tr>
					<th>ADDRESS</th>
					<td><input class="address" type="text" id="sample6_postcode"
						name="sample6_postcode" placeholder="우편번호" required
						onclick="confirmPhone();"> 
						
						<input class="address" type="button"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
						
						<input class="address" type="text" id="sample6_address" name="sample6_address"
						placeholder="주소" required> 
						
						<input type="text" class="address"
						id="sample6_detailAddress" name="sample6_detailAddress"
						placeholder="상세주소" onclick="confirmPhone();" required><br>
						
						<input type="text" class="address" id="sample6_extraAddress"
						name="sample6_extraAddress" placeholder="참고항목"></td>
				</tr>
				<tr>
					<th>CATEGORY</th>
					<td><input type="checkbox" name="member_category" value="1">IT
						<input type="checkbox" name="member_category" value="2">교과목
						<input type="checkbox" name="member_category" value="3">미용/뷰티
						<input type="checkbox" name="member_category" value="4">언어
						<input type="checkbox" name="member_category" value="5">요리
						<input type="checkbox" name="member_category" value="6">자격증/시험
						<input type="checkbox" name="member_category" value="7">기타
					</td>
				</tr>
				<tr>
					<th>GENDER</th>
					<td><input type="radio" name="member_gender" value="남" checked>남
						<input type="radio" name="member_gender" value="여">여</td>
				</tr>

				<tr>
					<td colspan="2" align="right"><input type="submit" value="저장" />
						<input type="button" value="취소"
						onclick="location.href='index.jsp'" /></td>
				</tr>
			</table>

		</form>
	</div>

</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>
</html>