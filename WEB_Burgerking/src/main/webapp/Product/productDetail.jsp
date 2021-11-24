<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="clear"></div>
<div class="contentsWrap">
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a  href="burger.do?command=index">메뉴소개</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=index">${shortProductVO.pname }</a></li>
		</ul>
	</div>
	<div class="prd_intro">
		<div class="web_container4">
			<div class="intro_txt"><strong class="tit"><span>${shortProductVO.pname}</span></strong>
			<p class="subtxt"><span></span></p></div>
			<div class="prd_img"><img src="image/menu/${shortProductVO.kind1}/${shortProductVO.image}" /></div>
		</div>
	</div>
	<div class="menu_subinfoWrap">
		<div class="web_container4">
			<a class="btn_back" href="burger.do?command=menuListForm&kind1=${shortProductVO.kind1}"><span>메뉴 목록으로 돌아가기</span></a>
			<div class="nutrition_info"><button type="button" class="btn_nutrition">
			<span>영양분석표, 알레르기 유발성분</span></button></div>
		</div>
	</div>
	<div class="bg_w">
		<div class="web_container2">
			<ul class="prdmenu_list prd_submenu">
			<c:forEach var="productVO" items="${productVO}">
				<li>
				<div class="prd_img"><img src="image/menu/${productVO.kind1}/${productVO.image}" width="296" height="193"/></div>
				<div class="cont">
					<div class="tit"><strong>${productVO.pname}</strong></div>
					<div class="set"><strong>${productVO.content}</strong></div>
				</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>
<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>