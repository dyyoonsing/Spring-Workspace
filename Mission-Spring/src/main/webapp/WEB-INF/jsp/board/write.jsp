<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{
		color : red;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>게시물 등록폼</h2>
		<hr>
		<br>
<%-- 	
		<form action="${ pageContext.request.contextPath }/board/write" method="post"> 
		<form method="post">
		action안 붙이면 현재 uri의 post로 넘어감!! 우리는 같으니까 안 써도 되지
--%>
		<form:form commandName="boardVO" method="post">
			<table border="1" style="width:100%">
				<tr>
					<th width="23%">제목</th>
					<td>
						<form:input path="title"/>
						<form:errors path="title" class="error"/>
					</td>
				</tr>
				<tr>
					<th width="23%">글쓴이</th>
					<td>
						<form:input path="writer"/>
						<form:errors path="writer" class="error"/>
					</td>
				</tr>
				<tr>
					<th width="23%">내용</th>
					<td>
						<form:textarea path="content" rows="7" cols="50"/>
						<form:errors path="content" class="error"/>
					</td>
				</tr>
			</table>
			<button type="submit">등록</button>
		</form:form>
	</div>
	</section>
	<footer>
		<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>