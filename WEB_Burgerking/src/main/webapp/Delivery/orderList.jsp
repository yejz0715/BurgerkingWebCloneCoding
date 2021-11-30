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
			<%-- <div class="acc_tit">
				<p class="tit"><strong><span>${orderList.pname}</span></strong></p>
			</div> --%>
		<ul class="cart_list01">
			<c:forEach var="orderList"  items="${orderList}">
			<li>
				<div class="cont">
					<div class="menu_titWrap">
						<div class="menu_name">
							<p class="tit"><strong><span>${orderList.pname}</span></strong></p>
							<p class="price"><strong><span>${orderList.price1}</span></strong></p>
						</div>
					</div>
					<!-- <div class="setmenu_detail">
					
					</div> -->
					<div class="quantity"><strong class="tit">수량</strong>
						<div class="num_set">
							<button type="button" class="btn_minus"
							 onclick="location.href='burger.do?command=minusQuantity&cseq=${orderList.cseq}'"><span>-</span></button>
							<div class="result">${orderList.quantity}</div>
							<button type="button" class="btn_plus"
							 onclick="location.href='burger.do?command=plusQuantity&cseq=${orderList.cseq}'"><span>+</span></button>
						</div>
					</div>
				</div>
				<div class="sumWrap">
				<dl>
					<dt>총 주문금액</dt>
					<dd>
						<strong>
							<em><span></span><span class="unit">${totalPrice}원</span></em>
						</strong>
					</dd>
				</dl>
				</div>
			</li>
			</c:forEach>
		</ul>
		</div>
		<h2 class="tit01 tit_ico money"><span>최종 결제금액</span></h2>
		<div class="container02">
			<div class="order_payment_list">
				<dl class="tot">
					<dt>총 주문금액</dt>
					<dd>
						<strong>
							<em><span></span><span class="unit">${totalPrice}원</span></em>
						</strong>
					</dd>
				</dl>
				<dl>
					<dt>제품 금액</dt>
					<dd>
						<strong>
							<em><span></span><span class="unit">${totalPrice}원</span></em>
						</strong>
					</dd>
				</dl>
				<dl>
					<dt>배달팁</dt>
					<c:choose>
						<c:when test="${totalPrice>12000}">
							<dd>
								<strong>
									<em><span></span><span class="unit">0원</span></em>
								</strong>
							</dd>
						</c:when>
					</c:choose>
					<c:otherwise>
							<dd>
								<strong>
									<em><span></span><span class="unit">3000원</span></em>
								</strong>
							</dd>
					</c:otherwise>
				</dl>
			</div>
		</div>
		<div class="totamountWrap">
			<div class="c_btn m_item2">
				<button type="button" class="btn01 m" onclick="cancel()"><span>취소</span></button>
				<button type="button" class="btn01 m red" onclick="go_order_insert()"><span>주문하기</span></button>
			</div>
		</div>
	</div>
</div>
</article>
<%@ include file="/footer/footer.jsp" %>