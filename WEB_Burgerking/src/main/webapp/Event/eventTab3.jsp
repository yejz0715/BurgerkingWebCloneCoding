<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link href="css/event.css" rel="stylesheet">
<head profile="http://www.w3.org/2005/10/profile"/>
<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>이벤트 &nbsp;>&nbsp;</li>
			<li>종료</li>
		</ul>
	</div>
	<div class="subtit">
	<h1 class="event_tit">이벤트</h1>
	<ul class="submenu_right"> 
	<li><span><a href="burger.do?command=eventListForm">전체</a></span></li>
	<li><span><a href="burger.do?command=eventTab2">진행중</a></span></li>
	<li><span><a href="burger.do?command=eventTab3" style="color: red; text-decoration: underline;">종료</a></span></li>
	</ul>
	</div>
	<form name="frm" method="post" action="burder.do">

<div class="eventarea">
<ul>
<c:forEach var="EventVO" items="${EventList}">
<li><a href="burger.do?command=eventdetailForm">
 <input type="hidden" name="eseq" value="${EventVO.eaeq}">
<div class="eventimgdiv">
<img class="eventImg" src="image/menu/event/${eventVO.image}">
</div>
<div class="eventdatediv">
<p>${eventVO.startdate} ~ ${eventVO.enddate}</p>
</div>
</a>
</li>
</c:forEach>
</ul>	
</div>
</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>	