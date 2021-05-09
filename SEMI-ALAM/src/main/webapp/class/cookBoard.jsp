<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/css/anyTypeBoard.css">

</head>
<body>

   <%-- header 부분 --%>
   <jsp:include page="../layout/header.jsp"></jsp:include>

   <div class="container">

      <h1>요리</h1>
      <hr width=170px align="left" />
      
      <c:set var="i" value="0" /> 
      <c:set var="j" value="4" />
      <table border="1">
      
         <c:choose>

            <c:when test="${empty list }">
               <tr>
                  <th colspan="4">----------작성된 글이 존재하지 않습니다-----------</th>
               </tr>
            </c:when>

            <c:otherwise>
            
                  <c:forEach items="${list }" var="dto">
                     <c:if test="${i%j == 0 }">
                        <tr>
                     </c:if>
                     <td class="content">
                        <img src="resources/image/beauty.png" /><br/> 
                        제 목 : <a href="classApply.do?command=classDetail&class_apply_no=${dto.class_apply_no }">${dto.class_apply_title }</a><br/>
                        작 성 자 : ${dto.class_apply_id }<br/>
                        작 성 일 : <fmt:formatDate value="${dto.class_apply_date }" pattern="yyyy-MM-dd"/>
                     </td>
                     <c:if test="${i%j == j-1 }">
                        </tr>
                     </c:if>
                     <c:set var="i" value="${i+1 }" />
                  </c:forEach>

            </c:otherwise>

         </c:choose>
         
         <tr>
            <td class="write" colspan="4" align="right">
               <c:if test="${user != null && user.member_grade == 'B' }"><input type="button" value="글작성" onclick="location.href='classApply.do?command=요청'" /></c:if>
               <input type="button" value="목록" onclick="location.href='classApply.do?command=실시간'" />
            </td>
         </tr>
         
      </table>

   </div>

</body>
</html>