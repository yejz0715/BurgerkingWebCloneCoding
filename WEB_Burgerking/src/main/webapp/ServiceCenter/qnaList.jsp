<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<article style="background-color: #fff">
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
			<li><span><a href="burger.do?command=appGuideForm">버거킹앱 이용안낸</a></span></li>
		</ul>
	</div>
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>