<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>고객센터 &nbsp;>&nbsp;</li>
			<li>문의</li>
		</ul>
	</div>
	
	<div class="subtitWrap">
		<h3 class="page_tit">고객센터</h3>
		<ul id="terms_wrap_ul" style="right: 0; top:0">
			<li>
				<span>
					<a href="burger.do?command=faqForm&fnum=1">FAQ</a>
				</span>
			</li>
			<li><span><a href="burger.do?command=qnaForm" style="color: red; text-decoration: underline;">문의</a></span></li>
			<li><span><a href="burger.do?command=appGuideForm">버거킹앱 이용안내</a></span></li>
		</ul>
	</div>
	
	<div class="web_container1">
		<c:choose>
			<c:when test="${empty loginUser}">
				<img style="width: 100%;" src="image/main/qna.PNG">
				<span style="color: #6a6a6a; font-size: 2rem; float: right;">
					QnA 작성 및 확인은 <a style="text-decoration: none;" href="burger.do?command=loginForm">로그인</a> 후 이용해주세요.
					</span>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
						<th>작성자</th>
						<th>답변여부</th>		
					</tr>
					<c:forEach items="qnaList" var="qnaVO">
						<tr>
							<td> ${qnaVO.qseq}</td>    
				    		<td><a href="burger.do?command=qnaView&qseq=${qnaVO.qseq}">${qnaVO.subject}</td>      
				       		<td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
				       		<td> ${qnaVO.id}</td> 
				       		<td><c:choose>
								<c:when test="${qnaVO.rep==1}"> no </c:when>
								<c:when test="${qnaVO.rep==2}"> yes </c:when>
							</c:choose></td>    
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>