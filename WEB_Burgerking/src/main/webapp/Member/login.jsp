<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Delivery/deli_header.jsp"%>

<article>
	<div class="location">
		<ul>
			<li><a href="burger.do?command=index">HOME</a>&nbsp;>&nbsp;</li>
			<li><a href="burger.do?command=loginForm">로그인</a></li>
		</ul>
	</div>

	<div class="web_container1">
		<h2 class="page_tit02 bg_w">
			<em>WHERE TASTE IS KING</em><span>어서오세요! 버거킹입니다.</span>
		</h2>
		<div class="weblogin_ui">
			<form class="login" name="frm" method="post" action="burger.do">
				<input type="hidden" name="command" value="login">
				<img class="login_img"src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAlCAYAAADFniADAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MEFBNEU4QzdGQzRCMTFFOEI5MUI4NzE2NzRGRTUyOUMiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MEFBNEU4QzhGQzRCMTFFOEI5MUI4NzE2NzRGRTUyOUMiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDowQUE0RThDNUZDNEIxMUU4QjkxQjg3MTY3NEZFNTI5QyIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDowQUE0RThDNkZDNEIxMUU4QjkxQjg3MTY3NEZFNTI5QyIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pizf/y4AAAQ2SURBVHjavFhtSJRZFD4zjklaiVLm/lALtWJ/qGmZkJK7IxIa6SKK5rJhgRAaCoIFIYhRyCIYyhqi0sLSjmD+qRRJckt/lIGprOIkhqQYCAZOtq6GOT3n8s7g18z7Nc4DD/d9Z+455+He895z7zVUV1eTFgwMDASgOQYeAQNBE2gDP4LWlJSUT6QRJpVCItH8Cp4HT7mzR993aJ6BFgh85XFRCJCApgq8CBoU+j4u8Trsh9HeBTsh0C5naJQRcwBsxuMbMEuFoK04CXaAz+EvSrMoGMeiGQGL5cSrwE/gW/jOVy0KRmzcDx4lz2M/+DdiVCgWhc5n0DwFD9DugdOgDrGuyYpCpwg0T0B/8g7+QMzzLkXhT1b/F3iIvAcRE7FDXY3UFTCFvI+DPJXb1iko3Yvmth7PISEhlJeXR0lJSeJ5cXGRhoeHqb29naanp+XML0FDHdawkY0j9Rv4g1ZBsbGx1NraStnZ2RQaGkpGo5GCg4PJbDZTU1MTpaenK5nGm1un76pWQRy8pqaG/P13/jZ8fX2poqKCIiMj5Vz9gtEKFqLwwGvRaa2icnJyKCAgwPk+OztLnZ2dNDk56fzNx8eHCgoK5FztkaqGyCmznlyKi4tzPttsNiopKaHl5WUymUzU0tJCYWFh4r+YmBgl7n4GH/D0JegRFRgY6Hyen58Xghhra2ti1BzYOJpukODIqSg9omZmZpzP0dHRIqn9/PwoOTmZEhMTd+znBlFIJxNP32E9oqamppzBDQYDVVZWCm5FT0+PEne+XBuNUoHUhLS0NMrPz5ftx+tVV1eX4oLNI7WkRVBGRgaVl5eLNckV7HY79fb2UmNjo8gxhVhmUYtqBWVlZVFpaamYLgf6+/upra2N4uPjKSgoSKzoQ0NDNDc3p8b1Og8Si5pSU/Nyc3OpuLh4k6C+vj6qra2l9fV1tSK24gNKzSqLGlVqUVhYSEVFRdt+X1paElPlAYw6Fs9/lPRmMSzK1XRyOamvr9crrs+xTv0LvpfrvbKysul9fHx8W+JnZmbqEcT59FiIko48f8pZWCwWam5uFiPB25GysjKxM3CAv7Lu7m49ol5Ay4eN57774A1wnzurjo4OGhsbo4mJCfHO4lZXVyk8PJwaGhr0Tt3vzgKemppKERER/6MM8EbvnJzlwsLCpner1UqDg4N6E/wlRqlqp+1wrZLc2gV8BUt23KNDKZf3S1Inb+IGYo+7PGLhzzfSAcLuJUH3EfOe7GEUnR5Kw/ltlwXxce664mM7hPHXyOX/yy6IsUs3MJcR55uqCw4YPJL27q89KIgL4wX4vuXuSsjtbQoMrWjOSnk2rUPMZ/AOeAI+ZVdY2UszOOHl/wG2qZwD2dJNnlluoeVtujTKFvAh/Ng8fr0IpxyEp/QR76Ol68UfpeuifZKv/3g7DvL5ahA2mjaQ3wUYAHqBZELLoSo8AAAAAElFTkSuQmCC">
				<h3 class="tit_ico tit01">일반 로그인</h3>
				<div class="cont">
					<div class="inpbox">
						<label>
							<span class="hide">ID</span>
							<input type="email" placeholder="아이디 (이메일)" id="userId" name="id">
							<button type="button" tabindex="-1" class="btn_del01" style="display: none;">
									<span>입력 텍스트 삭제</span>
							</button>
						</label>
					</div>
					<div class="inpbox">
						<label>
							<span class="hide">Password</span>
							<input placeholder="비밀번호" type="password" name="pwd">
						</label>
					</div>
					
					<div class="c_btn item2">
						<input type="submit" class="btn01 m red" onclick="return login_chk();" value="로그인"></input>
						<input type="button" class="btn01 m" onclick="location.href='burger.do?command=joinForm'" value="회원가입"/>
					</div>
					<div class="login_menu">
						<a href="burger.do?command=findIdForm"><span>아이디 찾기</span></a>
						<a href="burger.do?command=findPwdForm"><span>비밀번호 찾기</span></a>
					</div>
				</div>
			</form>
			
			<c:choose>
				<c:when test='${non=="1"}'>
					<form class="login2" name="frm" method="post" action="burger.do">
						<input type="hidden" name="command" value="nonUserForm">
						<ul id="terms_wrap_ul" style=" left:0px; position:relative; margin-top: 30px;">
							<li>
								<span>
									<a href="burger.do?command=loginForm&non=1" style="color: red; text-decoration: underline; font-size: 1.45em;">비회원 주문</a>
								</span>
							</li>
							<li><span><a href="burger.do?command=loginForm&non=2" style="font-size: 1.45em;">비회원 주문내역</a></span></li>
						</ul>
						
						<div class="textarea2">
							회원가입 없이 비회원으로 주문 가능합니다.
						</div>
						
						<div class="c_btn item2" >
								<input type="submit" class="btn01 m red translo" value="비회원주문"></input>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form class="login2" name="frm" method="post" action="burger.do">
						<input type="hidden" name="command" value="nonUserForm">
						<ul id="terms_wrap_ul" style=" left:0px; position:relative; margin-top: 30px;">
							<li>
								<span>
									<a href="burger.do?command=loginForm&non=1" style="font-size: 1.45em;">비회원 주문</a>
								</span>
							</li>
							<li><span><a href="burger.do?command=loginForm&non=2" style="color: red; text-decoration: underline; font-size: 1.45em;">비회원 주문내역</a></span></li>
						</ul>
						
						<div class="textarea2">
							<div class="inpbox">
								<label>
									<span class="hide">주문번호</span>
									<input type="email" placeholder="주문번호" id="oseq" name="oseq">
								</label>
							</div>
							<div class="inpbox">
								<label>
									<span class="hide">비밀번호</span>
									<input placeholder="비밀번호" type="password" name="pwd">
								</label>
							</div>
						</div>
						
						<div class="c_btn item2" >
								<input type="submit" class="btn01 m red translo" value="조회하기"></input>
						</div>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</article>

<%@ include file="/footer/footer.jsp" %>