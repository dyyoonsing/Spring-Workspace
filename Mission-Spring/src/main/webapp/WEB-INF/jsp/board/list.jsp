<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goWriteForm() {
	   location.href = "${ pageContext.request.contextPath }/board/write";
	}
	 
	function doAction(boardNo) {
//		location.href = "${ pageContext.request.contextPath }/board/detail?no=" + boardNo;
		location.href = "${ pageContext.request.contextPath }/board/" + boardNo;
	}
</script>
</head>
<body>
	<header>
		<%-- <%@include file="/WEB-INF/jsp/include/topMenu.jsp" %> --%>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr width="100%">
			<h2>게시판 목록</h2>
			<hr width="100%">
			<table border="1" style="width: 100%">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="16%">글쓴이</th>
					<th width="20%">등록일</th>
				</tr>
				<c:forEach items="${ boardList }" var="board" varStatus="loop">
					<tr <c:if test="${ loop.count mod 2 eq 0 }">class="even"</c:if>>
						<td>${ board.no }</td>
						<td>
							<a href="javascript:doAction(${ board.no })">
								<c:out value="${ board.title }" />
							</a>
						</td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${ not empty loginVO }">
				<button onclick="goWriteForm()">새글등록</button>
			</c:if>
		</div>
	</section>
	<footer>
		<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>