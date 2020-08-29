<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function getReplyList(){
		//alert('댓글리스트 로드~!')
		// 해당게시물의 댓글리스트 조회 => <div id="replyList"> 조회 데이터 업데이트
		$.ajax({
			url : '${pageContext.request.contextPath}/reply/${ board.no }',
			type : 'get',
			success : function(data){
				let list = JSON.parse(data);
				/* 
				for(i = 0; i < list.length; i++){
					console.log(list)
				} 
				*/
				
				//먼저 안에 내용 지우고 다시 넣기!!
				$('#replyList').empty();
				
				
				$(list).each(function(){
					console.log(this)
					let str = '';
					str += '<hr>';
					str += '<div>';
					str += '<strong>' + this.content + '</strong>'
					str += '(' + this.writer + ')';
					str += '&nbsp;&nbsp;&nbsp;' + this.regDate;
					str += '&nbsp;&nbsp;&nbsp;' + '<button class="delBtn" id="' + this.no + '">삭제</button>';
					str += '</div>';
					
					$('#replyList').append(str);
				})
				
				
			},
			error : function(){
				alert('실패')
			}
		})
		
	}

	$(document).ready(function(){
		$('#replyAddBtn').click(function(){
			let content = document.rform.content.value;
			let writer = document.rform.writer.value;
			alert(content + " : " + writer)
			
			// /reply/insert?boardNo=12&content=aaa&writer=bbb
			$.ajax({
				url : '${pageContext.request.contextPath}/reply',
				type : 'post',
				data : {
					boardNo : ${ board.no },
					content : content,
					writer : writer
				},
				success : function(){
					alert('성공')
					//document.rform.content.value= '';
					//document.rform.writer.value= '';
					getReplyList();
				},
				error : function(){
					alert('실패')
				}, complete : function(){
					document.rform.content.value= '';
					document.rform.writer.value= '';
				}
			})
		})
		
		getReplyList();
		
		$(document).on('click', '.delBtn', function(){
			let replyNo = $(this).attr('id');
			
			if(!confirm('댓글을 삭제하시겠습니까?'))
				return;
			//console.log(id)
			
			$.ajax({
				url: '${pageContext.request.contextPath}/reply/' + replyNo + '/${board.no}',
				type: 'delete',
				success: function(){
					alert('성공')
					getReplyList()
				},
				error: function(){
					alert('실패')
				}
			})
			
			/*
			$.ajax({
				url: '${pageContext.request.contextPath}/reply/' + replyNo,
				type: 'delete',
				success: function(){
					alert('성공')
					getReplyList()
				},
				error: function(){
					alert('실패')
				}
			})
			*/
			
		})
	})
	
	
</script>
</head>
<body>
<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
<section>
		<div align="center">
		<hr>
		<h2>게시판 상세 페이지</h2>
		<hr>
		<table border="1" style="width:100%">
			<tr>
				<th width="25%">번호</th>
				<td><c:out value="${ board.no }" /></td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">글쓴이</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
		</table>	
		<br>
		<c:if test="${ userVO.id eq board.writer }">
			<input type="button" value="수정" onclick="doAction('U')">&nbsp;&nbsp;
			<input type="button" value="삭제" onclick="doAction('D')">&nbsp;&nbsp;
		</c:if>
		<input type="button" value="목록" onclick="doAction('L')">&nbsp;&nbsp;
		
		<br>
		<hr>
		<form name="rform">
			댓글 : <input type="text" name="content" size="100">
			이름 : <input type="text" name="writer" size="10">
			<input type="button" value="댓글추가" id="replyAddBtn">
		</form>
		<div id="replyList"></div>
	</div>
	</section>
	<footer>
		<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>