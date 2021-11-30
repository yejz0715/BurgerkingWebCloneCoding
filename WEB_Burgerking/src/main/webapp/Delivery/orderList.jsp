<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="deli_header.jsp"%>
<div class="clear"></div>
<article>
<div class="contentsBox01">
	<div class="web_container">
		<div class="subtitWrap m_bg_basic">
			<h2 class="page_tit">주문하기</h2>
		</div>
		<div class="container01 orderWrap">
			<h2 class="tit01 tit_ico delivery"><span>배달정보</span></h2>
		</div>
		<div class="container02 deli_info01">
			<div class="addrWrap01">
				<p class="txt_addr"><span>${orderList.address}</span></p>
				<button type="button" class="btn04 h02 rbtn"><span>변경</span></button>
			</div>
			<div class="info_list">
				<dl><dt>연락처</dt><dd><input type="text"maxlength="20" value="${orderList.phone}"></dd></dl>
			</div>
		</div>
		<div class="tit01 tit_ico burger tit_ordermenu">
			<h2><span>주문정보</span></h2>
		</div>
		<div class="container02 order_accWrap open">
			<div class="acc_tit">
				<p class="tit"><strong><span>${orderList.pname}</span></strong></p>
			</div>
		</div>
		<ul class="cart_list01">
			<li>
				<div class="cont">
					<div class="menu_titWrap">
						<div class="menu_name">
							<p class="tit"><strong><span>${orderList.pname}</span></strong></p>
							<p class="price"><strong><span>${orderList.price1}</span></strong></p>
						</div>
					</div>
					<div class="setmenu_detail"></div>
				</div>
			</li>
		</ul>
	</div>
</div>
</article>
<%@ include file="/footer/footer.jsp" %>