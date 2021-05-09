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

<script type="text/javascript">
	function checkPW() {
		var input = document.getElementById("pw");
		var error = document.getElementById("error");
		error.innerText = ""
		
		if(input.value == ${pw}) {
			self.close();
			opener.location.href="board.do?command=detail&board_no="+${board_no};
			
		} else {
			error.innerText = "비밀번호가 틀렸습니다.";
			input.value = "";
			input.focus();
		}
	}

</script>
</head>
<body>

	<div class="container">
		<h3>비밀번호 확인</h3>
		<input type="text" id="pw" />
		
		<button onclick="checkPW()">확인</button>
		<p id="error" style="color:red;"></p>
	</div>

</body>
</html>