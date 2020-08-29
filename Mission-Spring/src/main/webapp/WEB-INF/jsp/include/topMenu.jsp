<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" />
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" />
<script>
	function addFavorite(){
		try{
			window.external.AddFavorite('http://localhost:9999/Mission-Spring', 'Spring WEB')
		}catch(e){
			alert('현재 사용중인 브라우저에서는 사용할 수 없습니다 \n크롬에서는 ctrl+d를 이용해주세요')
		}
	}
</script>
<table border="1" style="width:100%; height:100%">
	<tr>
		<td rowspan="2" style="width:100px">
			<a href="${ pageContext.request.contextPath }">
				<img src="${ pageContext.request.contextPath }/resources/images/hana.png" height="50px">
			</a>
		</td>
		<td align="right">
			<a href="#" onclick="addFavorite()">
				즐겨찾기
			</a>
			<c:if test="${ not empty loginVO }">
				[${ loginVO.id }님으로 로그인 중...]
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ loginVO.type eq 'S' }">
				<a href="#">회원관리</a> | 
			</c:if>
			<a href="${ pageContext.request.contextPath }/board">게시판</a> 
			<c:choose>
				<c:when test="${ empty loginVO }">
					| <a href="#">회원가입</a> 
					| <a href="${ pageContext.request.contextPath }/login">로그인</a>
				</c:when>
				<c:otherwise>
					| <a href="#">마이페이지</a>
					| <a href="${ pageContext.request.contextPath }/logout">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>