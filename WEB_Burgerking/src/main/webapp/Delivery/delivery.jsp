<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="deli_header.jsp"%>
<div class="clear"></div>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=deliveryForm&kind1=1">딜리버리</a>&nbsp;>&nbsp;</li>
			<li>메뉴</li>
		</ul>
	</div>
<div class="bg_w">
	<div class="web_container1">
		<div class="subtitWrap">
			<h3 class="page_tit">메뉴소개</h3>
			<div class="tab01" >
			<ul>
				<li><a href="burger.do?command=deliveryForm&kind1=1">
					<button type="button" ><span>스페셜&amp;할인팩</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=2">
					<button type="button"><span>프리미엄</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=3">
					<button type="button"><span>와퍼</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=4">
					<button type="button"><span>주니어&amp;버거</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=5">
					<button type="button"><span>올데이킹&amp;치킨버거</span></button></a></li> 
				<li><a href="burger.do?command=deliveryForm&kind1=6">
					<button type="button"><span>사이드</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=7">
					<button type="button"><span>음료&amp;디저트</span></button></a></li>
				<li><a href="burger.do?command=deliveryForm&kind1=8">
					<button type="button"><span>독퍼</span></button></a></li>
			</ul>
			</div>
		</div>
	</div>
	<div class="menuarea">
		<ul>
			<c:forEach var="shortProductVO" items="${shortProductList}">
				<li><a href="burger.do?command=menudetailForm&spseq=${shortProductVO.spseq}">
					<div class="menuImgdiv">
						<img class="menuImg" src="image/menu/${shortProductVO.kind1}/${shortProductVO.image}">					
					</div>
					<div class="menuContdiv">
						<p>${shortProductVO.pname}</p>
					</div>
				</a></li>
			</c:forEach>
		</ul>
</div>
</article>

<%@ include file="/footer/footer.jsp" %>