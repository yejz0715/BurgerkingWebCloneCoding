<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="css/event.css" rel="stylesheet">

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>이벤트&nbsp; > &nbsp;</li>
			<li>전체</li>
		</ul>
	</div>
	<div class="event_web_container">
		<div class="subtit">
			<h1 class="event_tit">이벤트</h1>
			<ul class="submenu_right">
				<li><span style="border-bottom: 3px solid red;"><a
						href="burger.do?command=eventListForm" style="color: red;">전체</a></span></li>
				<li><span><a href="burger.do?command=eventTab2">진행중</a></span></li>
				<li><span><a href="burger.do?command=eventTab3">종료</a></span></li>
			</ul>
		</div>

		<form name="frm" method="post" action="burder.do">
			<div class="eventarea">
				<ul>
					<c:forEach var="EventVO" items="${eventlist}">
						<li><a href="burger.do?command=eventDetailForm"> <input
								type="hidden" name="eseq" value="${EventVO.eseq}" /> <img
								class="eventImg" src="image/main/event/${EventVO.image}" />
						</a>
							<p>${EventVO.startdate} ~ ${EventVO.enddate}</p></li>
					</c:forEach>
				</ul>
			</div>
		</form>
	</div>
</article>


<!-- <div class="contentbox">
<div class="eventweb_container">	

<div class="subtit">
<h1 class="event_tit">이벤트</h1>
<ul class="submenu_right"> 
<li><span><a href="burger.do?command=tab1">전체</a></span></li>
<li><span><a href="burger.do?command=tab2">진행중</a></span></li>
<li><span><a href="burger.do?command=tab3">종료</a></span></li>
</ul>
</div>	
<div class="eventview">
<ul class="event_box">
</ul>
</div>
</div>
</div> -->



<%@ include file="/undermenu.jsp"%>
<%@ include file="/footer/footer.jsp"%>