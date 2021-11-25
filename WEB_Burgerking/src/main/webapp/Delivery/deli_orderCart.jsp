<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="css/burger.css" rel="stylesheet">
<article>
 <div class="web_deliveryContainer">
 
  
 <a href="burger.do?command=deliveryOrderListForm">
 <div class="deliveryOrder">
 <img class= "deliveryIcon" src="image/main/my_delivery.png" />
 <c:choose>
 <c:when test="${orderList.size() == 0}">
 <dl>
 <dt><strong>딜리버리 주문내역</strong></dt>
 <dd>주문내역이 없습니다.</dd>
 </dl>
 </c:when>
 <c:otherwise>
 <dl>
 <dt><strong>딜리버리 주문내역</strong>
 <em class="count">
 <span>숫자</span>
 </em>
 </dt>
 <dd>주문내역</dd>
 </dl>
 </c:otherwise> 
 </c:choose>
 </div>
 </a>
 
 
 <a href="burger.do?command=deliveryCartForm">
 <div class="deliveryCart">
 <img class= "deliveryIcon" src="image/main/my_cart.png" />
 <c:choose>
 <c:when test="${cartList.size() == 0}">
 <dl>
 <dt><strong>카트</strong></dt>
 <dd>카트에 담은 상품이 없습니다.</dd>
 </dl>
 </c:when>
 <c:otherwise>
 <dl>
 <dt><strong>카트</strong>
 <em class="count">
 <span>1</span>
 </em>
 </dt>
 <dd>카트에 담은 상품</dd>
 </dl>
 </c:otherwise> 
 </c:choose> 

 </div>
  </a>
  
 </div>
 </article>
 
 
 
 