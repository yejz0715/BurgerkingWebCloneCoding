<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="clear"></div>
<article>
	<div class="location">
		<ul>
			<c:forEach var="ProductVO" items="${ProductList}">
				<li><a href="burger.do?command=menudetailForm&kind=${ProductVO.kind1}">
					<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
					<li><a href="burger.do?command=index">메뉴소개</a>&nbsp;>&nbsp;</li>
					<li><a href="burger.do?command=index">프리미엄</a>&nbsp;>&nbsp;</li>
					<li><a href="burger.do?command=index">${ProductVO.pname }</a>&nbsp;>&nbsp;</li>
				</a></li>
			</c:forEach>
		</ul>
	</div>
	<c:forEach var="ProductVO" items="${ProductList}">
	<div class="prd_intro">
		<div class="web_container">
			<div class="intro_text"><strong class="tit"><span>${ProductVO.pname}</span></strong></div>
			<p class="subtxt"><span>${ProductVO.content}</span></p>
			<div class="prd_img"><img src="image/menu/${ProductVO.kind1}/${ProductVO.image}" /></div>
		</div>
	</div>
	</c:forEach>
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>