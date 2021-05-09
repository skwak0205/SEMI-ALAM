<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<link rel="stylesheet" type="text/css" href="resources/css/rank.css">

</head>
<body>
	<div class="main">

		<input id="tab1" type="radio" name="tabs" checked>
		<label for="tab1">IT</label> 
		
		<input id="tab2" type="radio" name="tabs">
		<label for="tab2">교과목</label> 
		
		<input id="tab3" type="radio" name="tabs">
		<label for="tab3">미용/뷰티</label> 
		
		<input id="tab4" type="radio" name="tabs">
		<label for="tab4">언어</label> 
		
		<input id="tab5" type="radio" name="tabs">
		<label for="tab5">요리</label> 
		
		<input id="tab6" type="radio" name="tabs">
		<label for="tab6">자격증/시험</label> 
		
		<input id="tab7" type="radio" name="tabs">
		<label for="tab7">기타</label>
		
		<section id="content1">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>홍길동1</td>
						<td>92,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>2</td>
						<td>홍길동2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>홍길동3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>홍길동4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>홍길동5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>홍길동6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>홍길동7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>홍길동8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>홍길동9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>홍길동10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content2">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수2</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content3">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수3</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content4">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수4</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content5">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수5</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content6">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수6</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

		<section id="content7">
			<table class="content-table">

				<thead>
					<tr>
						<th class="rank">랭킹</th>
						<th>이름</th>
						<th>Points</th>
						<th>과목</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>김철수7</td>
						<td>88,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>2</td>
						<td>김철수2</td>
						<td>72,400</td>
						<td>데이터베이스</td>
					</tr>
					<tr>
						<td>3</td>
						<td>김철수3</td>
						<td>52,300</td>
						<td>파이썬</td>
					</tr>
					<tr>
						<td>4</td>
						<td>김철수4</td>
						<td>50,110</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>5</td>
						<td>김철수5</td>
						<td>50,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>6</td>
						<td>김철수6</td>
						<td>45,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>7</td>
						<td>김철수7</td>
						<td>43,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>8</td>
						<td>김철수8</td>
						<td>40,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>9</td>
						<td>김철수9</td>
						<td>30,000</td>
						<td>자바</td>
					</tr>
					<tr>
						<td>10</td>
						<td>김철수10</td>
						<td>25,000</td>
						<td>자바</td>
					</tr>
				</tbody>

			</table>
		</section>

	</div>
</body>
</html>