<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>이용약관 및 정책</li>
		</ul>
	</div>
	<div class="wrap">
		<ul id="terms_wrap_ul">
			<li>
				<span>
					<a href="burger.do?command=terms" style="color: red; text-decoration: underline;">이용약관</a>
				</span>
			</li>
			<li><span><a href="burger.do?command=privacy">개인정보취급방침</a></span></li>
			<li><span><a href="burger.do?command=legal">법적고지</a></span></li>
		</ul>
		<h1 class="big_h1">이용약관 및 정책</h1>
		<div class="btnarea"></div>
		<div class="textarea">
			<%@ include file="text1.jsp" %>
		</div>
	</div>
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>