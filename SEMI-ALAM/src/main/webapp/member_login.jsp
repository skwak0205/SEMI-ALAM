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

<link rel="stylesheet" href="resources/css/login.css" />

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>

<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>


</head>
<body>

	<div style="position: relative; z-index: 1;">
		<img src="resources/image/siba.png" id="bg" alt="">
	</div>

	<div style="position: relative; top: 25px; z-index: 2;">
		<div class="login-box">

			<h1>ALAM</h1>

			<form action="member.do" method="post">
				<input type="hidden" name="command" value="login" />

				<div class="user-box">
					<input type="text" name="member_id" required="required" /> <label>Username</label>
				</div>

				<div class="user-box">
					<input type="password" name="member_pw" required="required" /> <label>Password</label>
				</div>

				<p class="register">
					회원이 아니세요? <a href="member_register.jsp">회원가입 하기</a>
				</p>

				<p class="findIdPw">
					<a href="findIdPw.jsp">아이디/비밀번호 찾기</a>
				</p>

				<button type="submit">
					<span></span> <span></span> <span></span> <span></span> LOGIN
				</button>
				<input class="cancel" type="button"
					onclick="location.href='index.jsp'" value="Cancel" />
			</form>

			<div class="naver-btn" id="naver_id_login"></div>

			<a class="kakao-btn" id="custom-login-btn"
				href="javascript:loginWithKakao()"> <img
				src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
				width="324" />
			</a>

		</div>
	</div>


	<script type="text/javascript">
		var naver_id_login = new naver_id_login("a9uEETIUAG1utqrvI2Rj",
				"http://localhost:8787/SEMI-ALAM-final/member_api_callback.jsp");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("Green", 30, 70);
		naver_id_login.setDomain("http://localhost:8787");
		naver_id_login.setState(state);
		//naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>




	<script type="text/javascript">
		function loginWithKakao() {
			Kakao.init('d6b01d937279c4c97c83ed7b92adcec7');
			Kakao.isInitialized();
			Kakao.Auth
					.login({
						success : function(response) {
							Kakao.API
									.request({
										url : '/v2/user/me',
										success : function(result) {
											var accessToken = Kakao.Auth
													.getAccessToken();
											Kakao.Auth
													.setAccessToken(accessToken);

											var myid = JSON
													.stringify(result.id)

											var dataArray = new Array();
											if (result) {
												$
														.each(
																result,
																function(key,
																		val) {
																	if (typeof val == 'object') {
																		$
																				.each(
																						val,
																						function(
																								smallKey,
																								smallVal) {
																							dataArray[smallKey] = smallVal;
																						});
																	} else {
																		dataArray[key] = val;
																	}
																});
											}
											insertBykakao(myid)

										},
										fail : function(error) {
											console.log('카톡과 연결이 완료되지 않았습니다.');
										}
									})
						},
						fail : function(error) {
							console.log('카톡과 연결 실패하였습니다.');
						},
					})
		};
	</script>

	<script type="text/javascript">
		function insertBykakao(member_id) {
			var member_pw = "1111";

			location.href = "member.do?command=memberLoginInsert&member_id="
					+ member_id + "&member_pw=" + member_pw + "&member_gender=남";
		}
	</script>


</body>
</html>