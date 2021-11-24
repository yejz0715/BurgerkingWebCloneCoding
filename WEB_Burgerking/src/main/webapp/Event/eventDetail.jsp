<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<head profile="http://www.w3.org/2005/10/profile" />
<link href="css/event.css" rel="stylesheet">

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>이벤트&nbsp; > &nbsp;</li>
			<li>상세</li>
		</ul>		
	</div>
	<div class="event_web_container">
	<div class="subtit">
			<h1 class="event_tit">이벤트</h1>
	<form name="frm" method="post" action="burder.do">
	<ul>
	<li>
	<div class="detailTit">
	<input type="hidden" name="eseq" value="${EventVO.eseq}" />
	<h2>${EventVO.subject}</h2>
	<p><fmt:formatDate value="${EventVO.startdate}" type="date"/> ~
	<fmt:formatDate value="${EventVO.enddate}" type="date"/>
	</p>
	</div>
	<img class="detailImg" src="image/main/event/eventDetail/${EventVO.image} "  />
	<p>${EventVO.content}</p>
	</li>
	</ul>
	</form>
	</div>
	</div>
	</article>
	