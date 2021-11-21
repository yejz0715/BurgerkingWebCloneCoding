<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>딜리버리</title>
		<link href="css/burger.css" rel="stylesheet">
		<link rel="icon" href="image/icon.PNG">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Do+Hyeon&display=swap" rel="stylesheet">
		<style type="text/css">
.web_container{
	max-width: 1184px;
	position: relative;
	margin: 0 auto;
	height: 120px;
    padding-top: 48px;
}
.WEB_logo{
	display: inline-block;
    position: static;
    width: auto;
    height: 120px;
    padding-left: 80px;
    padding-right: 10px;
    font-weight: 700;
    font-size: 2.25rem;
    color: #fff;
    text-indent: 0;
    line-height: 120px;
    cursor: pointer;
	background: url(https://www.burgerking.co.kr/dist/img/logo_delivery.26d1d682.png) no-repeat 0; 
}
.utilWrap {
    position: absolute;
    right: 20px;
    top: 0;
    overflow: hidden;
}
		</style>
	</head>
	<body style="margin-top:168px;'">
		<div id="header_container" style="background-color: red;">
			<div class="web_container">
				<h1 class="WEB_logo">
					<span>버거킹</span>
				</h1>
				
				<div class="WEB utilWrap">
					<a><span>브랜드홈</span></a>
					<a style="display: none;"><span>로그아웃</span></a>
					<a style="display: none;"><span>MY킹</span></a>
					<a><span>로그인</span></a>
					<a><span>고객센터</span></a>
				</div>
			</div>
		</div>