<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Delivery/deli_header.jsp"%>




<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=loginForm">로그인</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=join">회원가입</a></li>
		</ul>
	</div>


	<div class="web_container">
		<div class="welcomeBox bg_w">
			<h3 class="page_tit02">환영합니다!</h3>
			<div class="txt_welcome">
				<p>
					<span class="br"><strong>이메일 주소</strong> 혹은 <strong>SNS
							계정</strong>으로</span> 간편하게 <strong><em>회원가입</em></strong> 하세요!
				</p>
				<p class="info">버거킹 서비스는 만 14세 이상부터 이용 하실 수 있습니다.</p>
			</div>
		</div>
		<div class="weblogin_ui">
			<div class="login bg_w">
				<h3 class="tit01 tit_ico key02">이메일 회원가입</h3>
				<div class="c_btn" style="none">
					<a href="burger.do?command=contract" class="btn02 st03" ><span>버거킹 회원가입</span></a>
				</div>
			</div>
			<!--  <div class="simple_login">
				<h3 class="tit01 tit_ico lock">간편 회원가입</h3>
				<ul class="list">
					<li class="naver"><a><span>네이버</span></a></li>
					<li class="kakao"><a><span>카카오톡</span></a></li>
					<li class="apple"><a><span>애플 로그인</span></a></li>
				</ul>
			</div>-->
		</div>
		
	</div>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
</article>
<%@ include file="/footer/footer.jsp"%>