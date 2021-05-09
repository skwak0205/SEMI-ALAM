<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/classApply.css" />

</head>
<body>

	<jsp:include page="../layout/header.jsp"></jsp:include>
	
	<div class="container">
	
		<h1>강의 업로드</h1>
		<hr width=170px align="left" />
	
		<form action="online.do" method="post" enctype="multipart/form-data">
      		
      		<br/><br/>
      		
	      	<input type="hidden" name="command" value="uploadRes" />
	      
	        <div class="row">
	            <div class="one">
	               <label for="category"><b>업로드 카테고리</b></label>
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
	         
	         <br/>
	        
	        <div class="col">
	          <div class="one">
	            <label for="member_id"><b>작성자 ID</b></label>
	          </div>
	          <div class="two">
	            <input type="text" id="member_id" name="member_id" value="${user.member_id }" readonly required />
	          </div>
	        </div>
	        
	        <br/>
	
	        <div class="row">
	          <div class="one">
	            <label for="title"><b>제목</b></label>
	          </div>
	          <div class="two">
	            <input type="text" id="title" name="title" required />
	          </div>
	        </div>
	        
	        <br/>
	        
	        <div class="row">
	          <div class="one">
	          	<label for="content"><b>영상 첨부</b></label>
	          </div>
	          <div class="two">
	          	<input type="file" name="file">
	          </div>       
	        </div>
	        
	        <br/>
	        
	        <div class="row">
	          <div class="one">
	            <label for="content"><b>내용</b></label>
	          </div>
	          <div class="two">
	            <textarea
	              name="content"
	              cols="50" rows="10"
	            ></textarea>
	          </div>
	        </div>
	        
	        <br/>
	        
	        <div class="row">
	          <div class="one">
	            <label for="price"><b>가격</label>
	          </div>
	          <div class="two">
	            <input type="text" id="price" name="price" required/>원
	            <input type="submit" value="제출" />
	          	<input type="button" value="취소" onclick="location.href='index.jsp'" />
	          </div>
	        </div>

	        <br><br><br>
	        
      	</form>
      
    </div>

</body>
</html>