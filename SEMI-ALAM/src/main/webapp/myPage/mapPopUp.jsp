<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="resources/css/myPageContent.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/mapCaffee.css">

</head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<body>

	<%-- header 부분 --%>
	<jsp:include page="../layout/header.jsp"></jsp:include>

	<div class="container">
		<jsp:include page="sideMenu.jsp"></jsp:include>

		<div class="content">
			<dl>
				<dt>카페 아이콘을 클릭하세요</dt>
			</dl>

			<div class="map_wrap">
				<div id="map"
					style="width: 90%; height: 150%; position: relative; overflow: hidden;"></div>
				<ul id="category">

					<li id="CE7" data-order="4"><span class="category_bg cafe"></span>
						카페</li>

				</ul>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9465c724ce69c24a026af0acbf51c39c&libraries=services"></script>
	<script type="text/javascript" src="resources/js/mapCaffee.js"></script>


</body>


</html>