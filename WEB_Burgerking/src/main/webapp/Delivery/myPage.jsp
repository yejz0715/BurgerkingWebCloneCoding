<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../Delivery/deli_header.jsp"%>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=deliveryForm">딜리버리</a>&nbsp;>&nbsp;</li>
			<li>MY킹</li>
		</ul>
	</div>
	<div class="web_myPageContainer">
	<div class="subTit_myPage">
	<h1 class="pageTit">MY킹</h1>
	</div>
	<div class="contentBox">
	<p class="user"><strong>${MemberVO.name}님!&nbsp;</strong>반갑습니다.</p>
	<div class="pageMove">
	<a href="burger.do?command=memberUpdateForm&id=${MemberVO.id}" ><span>정보변경&nbsp;</span></a>
	<a  href="burger.do?command=myAddressForm&id=${MemberVO.id}"><span>MY배달지</span></a>
	</div>
	</div>

		
	</div>
</article>

<%@ include file="/footer/footer.jsp" %>