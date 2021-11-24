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
	<div class="dt_ImgCon">
	<img class="detailImg" src="image/main/event/eventDetail/${EventVO.image} "  />
	<p>${EventVO.content}</p></div>
	</li>
	</ul>
	
	</form>
	</div>
	</div>
<div class="qr">
	<p><strong>버거킹 APP </strong>다운받고
	<br>
	<strong>더 많은 할인 혜택</strong>을
	<br>
	만나보세요!
	</p>
	<div class="qrCode">
	<img src="image/main/appQR.png">
	</div>
	</div>
	<a href="https://play.google.com/store/apps/details?id=kr.co.burgerkinghybrid&hl=ko">
	<img src="image/main/event/list_button" />
	</a>
	<div class="c_btn item2">
		<input type="submit" class="btn01 m red" onclick="return login_chk();" value="로그인"></input>
		<input type="button" class="btn01 m" onclick="location.href='burger.do?command=joinForm'" value="회원가입"/>
	</div>
	</article>
	<!--  
	  <div class="qr">
	<p><strong>버거킹 APP </strong>다운받고
	<br>
	<strong>더 많은 할인 혜택</strong>을
	<br>
	만나보세요!
	</p>
	<div class="qrCode">
	<img src="image/main/appQR.png">
	</div>
	</div>
	<a href="https://play.google.com/store/apps/details?id=kr.co.burgerkinghybrid&hl=ko">
	<img src="image/main/event/list_button" />
	</a>
	
	-->
	
	
	<%@ include file="/undermenu.jsp"%>
<%@ include file="/footer/footer.jsp"%>