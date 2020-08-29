<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function isNull(obj, msg){
		if(obj.value ==''){
			alert(msg)
			obj.focus();
			return true
		}
		return false		
	}

	function checkForm(){
		
		var f = document.lform;
		
		if(isNull(f.id, "아이디를 입력해주세요!"))
			return false; 
		
		if(isNull(f.password, "비밀번호를 입력해주세요!"))
			return false;
	}
</script>
</head>
<body>
<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<br>
			<hr>
			<h2>로그인</h2>
			<hr>
			<br>
			<form name="lform" action="${ pageContext.request.contextPath }/login" method="post" onsubmit="return checkForm()">
				<table style="width:40%">
					<tr>
						<th>ID</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<br>
				<button type="submit">로그인</button>
			</form>
		</div>
	</section>
	<footer>
		<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>