<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/classApply.css" />

<script type="text/javascript">

	onload = function() {
		var category = document.getElementById("category").value;
		var selection = document.getElementById("selection").innerText;
		category = selection;
	}
	
</script>

</head>
<body>
	
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<div class="container">
      
	  <h1>강의 요청</h1>
	  <hr width = 140px align="left" />

      <form action="classApply.do" method="post">
      
      	<br><br>
         
      	<input type="hidden" name="command" value="insertRes" />
      	
      	<div class="col">
          <div class="one">
            <label for="category"><b>요청 카테고리</b></label>
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
            <input type="text" id="member_id" name="member_id" value="${user.member_id }" readonly required />
          </div>
        </div>

		<br>
		
        <div class="row">
          <div class="one">
            <label for="title"><b>제목</b></label>
          </div>
          <div class="two">
            <input type="text" id="title" name="title" required />
          </div>
        </div>

		<br>
		
        <div class="row">        
          <div class="one">
            <label for="content"><b>요청(전달)사항</b></label>
          </div>
          <div class="two">
            <textarea id="content" name="content" cols="50" rows="10">내용을 입력하세요</textarea>
          </div>
        </div>

		<br>
		
        <div class="row">        
          <div class="one">
            <label for="how"><b>수업방식</b></label>
          </div>
          <div class="two">
            <input type="radio" name="how" value="온라인" checked>온라인
			<input type="radio" name="how" value="오프라인">오프라인
          </div>
        </div>

		<br>
		
		<div class="row">
          <div class="one">
            <label for="loc"><b>수업장소</b></label>
          </div>
          <div class="two">
            <input type="text" id="loc" name="loc" required />
            
            <input type="submit" value="제출" />
            <input type="button" value="취소" onclick="location.href='index.jsp'" />
          </div>
        </div>

		<br><br><br>
		
      </form>
      
    </div>

</body>
</html>