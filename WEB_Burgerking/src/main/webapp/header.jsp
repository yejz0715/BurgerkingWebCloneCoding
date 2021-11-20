<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/burger.css" rel="stylesheet">
</head>
<body>
	<div id="header_container">
		<header id="web_container">
			<a id="logo" href="burger.do?command=index"> <img
				src="image/main/burgerkinglogo.png" width="83" height="82" />
			</a>

			<nav id="top_menu">
				<ul>
					<li class="menu_item"><span>메뉴소개</span></li>
					<li class="menu_item"><span>이벤트</span></li>
					<li class="menu_item"><span>브랜드스토리</span></li>
				</ul>

				<a id="order_btn" href="burger?command=Delivery/delivery"> <img
					src="image/main/delivery1.png" width="160" height="50" />
				</a>

			</nav>
		</header>
	</div>