<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/boardInsert.css">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>

<script type="text/javascript" >
	
	$(document).ready(function() {
		$('#summernote').summernote({
			
			toolbar: [
				['fontname', ['fontname']],
				['fontsize', ['fontsize']],
				['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
				['color', ['forecolor', 'color']],
				['table', ['table']],
				['para', ['ul', 'ol', 'paragraph']],
				['height', ['height']],
				['insert', ['picture', 'link', 'video']],
				['view', ['fullscreen', 'help']]
			],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '나눔고딕', '바탕체', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M'],
			fintSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
			placeholder: '자유롭게 글을 작성할 수 있습니다. 상대방을 비방, 불쾌감을 주는 글, 욕설 등은 임의로 제제가 있을 수 있습니다.',
			height: 300,                 // set editor height
			minHeight: null,             // set minimum height of editor
			maxHeight: null,             // set maximum height of editor
			focus: true,                 // set focus to editable area after initializing summernote
	
		});
		
		$("select").change(function(){
			// 3. change 되서 선택된 option의 value값과, index를 alert()하고 싶다.
			var option = $("select > option:selected");
			
			if(option.val() == "문의") {
				$("#password").prop("disabled", "disabled");	
			
			} else {
				$("#password").prop("disabled", "");
			}
		});		
		
		
		
	});

</script>

</head>
<body>

	<div class="frame">
	
		<h1>고객의 소리</h1>
		<hr width=190px align="center" />
	
		<form action="board.do" method="post" enctype="multipart/form-data">
      	
      	<input type="hidden" name="command" value="insertRes" />
      
        <div class="row">
          <div class="col-25">
            <label for="member_id">작성자 ID</label>
          </div>
          <div class="col-75">
            <input type="text" id="member_id" name="member_id" value="${user.member_id }" readonly required />
          </div>
        </div>

        <div class="row">
          <div class="col-25">
            <label for="title">제목</label>
          </div>
          <div class="col-75">
            <input type="text" id="title" name="title" required />
          </div>
        </div>

         <div class="row">
            <div class="col-25">
               <label for="category">카테고리</label>
            </div>
            <div class="col-75">
               <select id="category" name="category">
               	  <option>카테고리를 선택하세요</option>
                  <c:if test="${user.member_grade == 'A' }">
                     <option value="공지">공지</option>
                  </c:if>
                  <c:if test="${user.member_grade != 'A' }">
                     <option value="문의">문의</option>
                     <option value="신고">신고</option>
                  </c:if>
               </select>
            </div>
         </div>
        
        <div class="row">
          <div class="col-25">
            <label for="password">비밀번호</label>
          </div>
          <div class="col-75">
            <input type="text" id="password" name="password" placeholder="신고글인 경우 비밀번호를 설정해 주세요." required />
          </div>
        </div>

        <div class="row">
          <div class="col-25">
            <label for="content">내용</label>
          </div>
          <div class="col-75">
            <textarea
              id="summernote"
              name="content"
              style="height: 200px"
            ></textarea>
          </div>
        </div>
        
        <div class="row">
          <div class="col-25">
          	<label for="content">파일첨부</label>
          </div>
          <div class="col-75">
          	<input type="file" name="file">
          </div>       
        </div>
                 
		  
        <div class="row">
          <input type="button" value="취소" onclick="location.href='board.do?command=${category}'" />
          <input type="submit" value="제출" />
        </div>
      </form>
      
    </div>

</body>
</html>