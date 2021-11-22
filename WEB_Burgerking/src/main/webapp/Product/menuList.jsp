<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="clear"></div>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>메뉴소개</li>
		</ul>
	</div>
	<div class="menuarea">
		<ul>
			<c:forEach var="shortProductVO" items="${shortProductList}">
				<li><a href="burger.do?command=menudetailForm<%-- &kind=${ProductVO.kind1} --%>">
					<div class=".menuImgdiv">
						<img class="menuImg" src="image/menu/${shortProductVO.kind1}/${shortProductVO.image}">					
					</div>
					<div class=".menuContdiv">
						<p>${shortProductVO.pname}</p>
					</div>
				</a></li>
			</c:forEach>
		</ul>
	</div>
	<!-- DB구조 변동에 따라 위 코드는 변경가능성 존재 -->
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>