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

	<div class="clear"></div>






	<div id="wrap">
		<header>
			<!-- 로고, 주메뉴, 카테고리 메뉴 등이 표시되는 영역 -->

			<div id="top_logo">
				<!-- 메인로고 시작 -->
				<a href="buger.do?command=index">
				<img src="image/main/my_logo.png" ></a>
				<span><a id="top_logofont" href="buger.do?command=****">버거킹</a></span>
			</div>
			<!-- 메인로고 끝 -->
			<nav id="top_menu">
				<!-- 상단 메뉴 시작 : 로그인 CART MyPage 등-->
				<ul>
					<li><a href="buger.do?command=****">브랜드홈</a></li>
					<li><a href="buger.do?command=****">로그인</a></li>
					<li><a href="buger.do?command=****">고객센터</a></li>
				</ul>
				<a href="buger.do?command=index">
				<img src="image/main/join.png" ></a>
			</nav>
			<!-- 상단 메뉴 끝 -->
		</header>
	</div>