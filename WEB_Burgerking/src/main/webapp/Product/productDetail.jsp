<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="clear"></div>
<div class="contentsWrap">
	<div class="location" style="margin-bottom: 0px;">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=index">메뉴소개</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=index"><${pvo.pname}</a></li>
		</ul>
	</div>
	<div class="prd_intro">
		<div class="web_container4">
			<div class="intro_txt"><strong class="tit"><span>${pvo.pname}</span></strong>
			<p class="subtxt"><span></span></p></div>
			<div class="prd_img"><img src="image/menu/${pvo.kind1}/${pvo.image}" /></div>
		</div>
	</div>
	<div class="menu_subinfoWrap">
		<div class="web_container4">
			<a class="btn_back" href="burger.do?command=menuListForm&kind1=${pvo.kind1}"><span>메뉴 목록으로 돌아가기</span></a>
			<div class="nutrition_info"><button type="button" class="btn_nutrition">
			<span>영양분석표, 알레르기 유발성분</span></button></div>
		</div>
	</div>
	<div class="bg_w">
		<div class="web_container5">
			<ul class="prdmenu_list prd_submenu"> 
			<c:forEach var="list2" items="${list2}">
				<li>
				<div class="prd_img"><img src="image/menu/${list2.kind2}/${list2.image}" width="296" height="193"/></div>
				<div class="cont">
					<div class="tit"><strong>${list2.pname}</strong></div>
					<div class="set"><strong>${list2.content}</strong></div>
				</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>
<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>