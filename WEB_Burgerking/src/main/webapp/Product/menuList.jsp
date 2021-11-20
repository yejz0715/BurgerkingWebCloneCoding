<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="clear"></div>

<article>
	
	<div class="menuarea">
		<ul>
			<c:forEach var="productVO" items="${ProductList}">
				<li>
					<div class=".menuImgdiv">
						<img class="menuImg" src="image/menu/premier/${productVO.image}">					
					</div>
					<div class=".menuContdiv">
						<p>${productVO.pname}</p>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>