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
<style>
#header_container {
	position: fixed;
	left: 0;
	top: 0;
	right: 0;
	z-index: 50;
	background-color: #fff;
}

#web_container {
	max-width: 1184px;
	height: 120px;
	position: relative;
	margin: 0 auto;
	padding: 0 20px;
	padding-top: 24px;
}

#logo {
	position: absolute;
	left: 20px;
	top: 20px;
}

#top_menu {
	position: relative;
	margin-left: 15%;
}

d, dl, dt, em, figure, h1, h2, h3, h4, h5, h6, li, ol, p, ul {
	margin: 0;
	padding: 0;
}

ul {
	list-style: none;
}

.menu_item {
	position: relative;
	float: left;
	width: 25%;
	padding: 20px 0 0;
	z-index: 11;
	padding-bottom: 20px;
	font-weight: 700;
	font-size: 1.375rem;
	text-align: left;
	line-height: 55px;
	cursor: default;
}

#order_btn {
	position: absolute;
	right: 0;
	top: 20px;
}
</style>
</head>
<body>
	<div id="header_container">
		<header id="web_container">
			<a id="logo" href="burger?command=index"> <img
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