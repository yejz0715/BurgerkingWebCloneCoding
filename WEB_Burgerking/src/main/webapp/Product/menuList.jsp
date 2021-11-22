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
			<c:forEach var="productVO" items="${ProductList}">
				<li><a href="burger.do?command=menudetailForm">
					<div class=".menuImgdiv">
						<img class="menuImg" src="image/menu/${productVO.kind1}/${productVO.image}">					
					</div>
					<div class=".menuContdiv">
						<p>${productVO.pname}</p>
					</div>
				</a></li>
			</c:forEach>
		</ul>
	</div>
	<!-- DB구조 변동에 따라 위 코드는 변경가능성 존재 -->
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>