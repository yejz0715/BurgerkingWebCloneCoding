<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="clear"></div>
<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a  href="burger.do?command=index">메뉴소개</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=index">뭐시기버거${shortProductVO.pname }</a>&nbsp;>&nbsp;</li>
		</ul>
	</div>
	
	<%-- <c:forEach var="shortProductVO" items="${ShortProductList}">
	
	</c:forEach> --%>
	 <%-- <c:forEach var="productVO" items="${ProductList}">
	
	</c:forEach> --%>
	<div class="prd_intro">
		<div class="web_container">
			<div class="intro_text"><strong class="tit"><span>모시깽버거${productVO.pname}</span></strong></div>
			<p class="subtxt"><span>맛있다${productVO.content}</span></p>
			<%-- <div class="prd_img"><img src="image/menu/${productVO.kind1}/${productVO.image}" /></div> --%>
			<div class="prd_img"><img src="image/menu/2/doubleoriginercheese.png" /></div>
		</div>
	</div>
	<div class="menu_subinfoWrap">
		<div class="web_container">
			<a class="btn_black"><span>메뉴 목록으로 돌아가기</span></a>
			<div class="nutrition_info"><button type="button" class="btn_nutrition">
			<span>영양분석표, 알레르기 유발성분</span></button></div>
		</div>
	</div>
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>