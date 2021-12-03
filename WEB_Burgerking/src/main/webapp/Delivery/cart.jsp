<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="deli_header.jsp"%>
<div class="clear"></div>
<form name="cartForm" method="post" action="burger.do" style="background: #f2ebe6;">
<input type="hidden" name="cseq" value="">
<article>
<div class="location">
	<ul>
		<li><a href="burger.do?command=deliveryForm&kind1=1">딜리버리</a>&nbsp;>&nbsp;</li>
		<li>메뉴</li>
	</ul>
</div>
<div class="contentsBox01">
<div class="web_container1">
	<div class="subtitWrap">
		<h2 class="page_tit">딜리버리 카트</h2>			
	</div>
	<div class="container01 cartWrap">
		<c:choose>
		<c:when test="${empty cartList}">
			<div class="tab_cont">
				<div class="nodata"><p>주문내역이 없습니다.</p></div>
			</div>
		</c:when>
		<c:otherwise>
		<div class="allchk01">
			<label><input type="checkbox" class="check02" onclick="selectAllDelete(this)" name="all">
			<span>전체선택</span></label>
			<div class="rcen_btn"></div>
				<button type="button" class="btn04" id="delete" onclick="del_cart(this)"><strong>삭제</strong></button>
		</div>
		<ul class="cart_list01">
		<c:forEach var="cartList" items="${cartList}" varStatus="status">
		<li>
			<div class="cont">
				<div class="menu_titWrap">
					<label class="menu_name">
						<input type="checkbox" name="menu" title="선택" class="check02" value="${cartList.cseq}">
						<span class="tit">${cartList.pname}</span>
						<span class="set_info"></span>
						<span class="price">
							<strong><span>${cartList.price1}</span><span class="unit">원</span></strong>
						</span>
					</label>
					<div class="prd_img"><img src="image/menu/${cartList.kind1}/${cartList.image}"></div>
				</div>
				<div class="quantity"><strong class="tit">수량</strong>
					<div class="num_set">
						<button type="button" class="btn_minus"
						 onclick="location.href='burger.do?command=minusQuantity&cseq=${cartList.cseq}'"><span>-</span></button>
						<div class="result">${cartList.quantity}</div>
						<button type="button" class="btn_plus"
						 onclick="location.href='burger.do?command=plusQuantity&cseq=${cartList.cseq}'"><span>+</span></button>
					</div>
				</div>
				<button type="button" name="submit" class="btn_del02" onclick="go_cart_delete('${cartList.cseq}')"><span>Delete menu</span></button>
			</div>
		</li> 
		</c:forEach>
		</ul>
		
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
		</c:otherwise>
		</c:choose>
		<div class="cartinfo">
			<div class="c_btn item2">
				<button type="button" class="btn01 m ico add" 
				onclick="location.href='burger.do?command=deliveryForm&kind1=1'"><span>메뉴 추가</span></button>
				<c:if test="${!empty cartList}">
					<button type="button" class="btn01 m red" onclick="go_order_insert()"><span>주문하기</span></button>
				</c:if>
			</div>
			<ul class="txtlist01">
				<li>주문서를 작성하기 전에 선택하신 상품명, 수량 및 가격이 정확한지 확인해주세요.</li>
				<li>해당매장의 주문배달 최소금액은 12,000원 입니다.</li>
			</ul>
		</div>
	
	</div>
</div>
</div>
</article>
</form>
<c:if test="${empty cartList}">
<%@ include file="/footer/footer.jsp" %>
</c:if>