<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/burger.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="script/burger.js" type="text/javascript"></script>
<script src="script/index.js" type="text/javascript"></script>
<link rel="icon" href="image/main/favicon.ico">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Nanum+Myeongjo:wght@800&family=Noto+Sans+KR&display=swap" rel="stylesheet">
</head>
<body>
<div class="popWrap">
	<div class="popbox01">
		<div class="pop_header01 st02">
			<div class="titleBar">
				<h1>재료를 추가해 더 맛있게 즐겨보세요!</h1>
			</div>
		</div>
		<div class="popcont bg_basic"> 
			<ul class="menu_sub_list check_mode">
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/bacon2.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>롱베이컨 2장</span></p>
						<p class="price"><span>+1,200원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/hallapinyo4.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>할라피뇨4 추가</span></p>
						<p class="price"><span>+800원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/bacon1.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>롱베이컨 1장</span></p>
						<p class="price"><span>+600원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/cheese2.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>치즈 2장</span></p>
						<p class="price"><span>+600원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/hallapinyo2.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>할라피뇨2 추가</span></p>
						<p class="price"><span>+400원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/cheese1.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>치즈 1장</span></p>
						<p class="price"><span>+300원</span></p>
					</div>
				</li>
				<li>
					<input type="checkbox" title="재료 추가" class="check03">
					<div class="prd_img">
						<img src="image/menu/plus/allextra.png" alt="재료">
					</div>
					<div class="cont">
						<p class="tit"><span>올엑스트라 300원</span></p>
						<p class="price"><span>+300원</span></p>
					</div>
				</li>
			</ul>
		</div>
		<div class="pop_btn c_btn item2">
			<button type="button" class="btn02 dark m_btn01_s"
			onclick="go_cart('${pvo.pseq}','${loginUser}')"><span>추가안함</span></button>
			<button type="button" class="btn02 red m_btn01_s"><span>추가함</span></button>
		</div>
	</div>
</div>
</body>
</html>