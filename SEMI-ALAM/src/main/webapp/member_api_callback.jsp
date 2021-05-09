<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript"	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

</head>
<body>

	<script type="text/javascript">
		var naver_id_login = new naver_id_login("a9uEETIUAG1utqrvI2Rj", "http://localhost:8787/SEMI-ALAM-final/member_api_callback.jsp");
		// 접근 토큰 값 출력
		// alert(naver_id_login.oauthParams.access_token);
		// 네이버 사용자 프로필 조회
				
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			console.log("data");
			var member_id = naver_id_login.getProfileData('id');
			var member_pw = "1111";
			var member_name = naver_id_login.getProfileData('name');
			var member_email = naver_id_login.getProfileData('email');
			var member_gender = "남";
			
			
			var obj = {member_id, member_pw, member_name, member_email, member_gender};
			console.log(obj);
			
			$(function(){
				$.ajax({
					type: "post",
					url: "member.do?command=memberLoginInsert",
					data: obj,
					success:function(result){
					}
				})
			});
			
			location.href="member.do?command=login&member_id=" + member_id + "&member_pw=" + member_pw;
		}
		
	
	</script>
</body>
</html>