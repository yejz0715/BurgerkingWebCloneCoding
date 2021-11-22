<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li>고객센터 &nbsp;>&nbsp;</li>
			<li>버거킹앱 이용안내</li>
		</ul>
	</div>
	
	<div class="subtitWrap">
		<h3 class="page_tit">고객센터</h3>
		<ul id="terms_wrap_ul" style="right: 0; top:0">
			<li>
				<span>
					<a href="burger.do?command=faqForm&fnum=1">FAQ</a>
				</span>
			</li>
			<li><span><a href="burger.do?command=qnaForm">문의</a></span></li>
			<li><span><a href="burger.do?command=appGuideForm" style="color: red; text-decoration: underline;">버거킹앱 이용안내</a></span></li>
		</ul>
	</div>

	<div class="web_container1">
		<div class="appdown">
			<dl class="store_down">
				<dt>스토어 다운로드</dt>
				<dd>
					<p>
						애플 앱스토어와 구글 플레이스토어에서 <strong>버거킹 앱</strong>을 다운로드 해보세요.
					</p>
					<div class="btn_area">
						<a href="https://play.google.com/store/apps/details?id=kr.co.burgerkinghybrid"
							target="_blank" class="btn_googleplay">
							<span>Google Play</span>
						</a>
						<a href="https://itunes.apple.com/kr/app/apple-store/id1017567032"
							target="_blank" class="btn_appstore">
							<span>App Store</span>
						</a>
					</div>
				</dd>
			</dl>
			<dl class="WEB">
				<dt>QR코드 다운로드</dt>
				<dd>
					<p>
						QR코드를 스캔하여 <br>
						<strong>버거킹 앱</strong>을 다운로드 해보세요.
					</p>
					<div class="QRcode">
						<img	src="image/main/appQR.png">
					</div>
				</dd>
			</dl>
		</div>
	</div>
</article>

<%@ include file="/undermenu.jsp" %>
<%@ include file="/footer/footer.jsp" %>