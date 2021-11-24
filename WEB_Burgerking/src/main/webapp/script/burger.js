
$(document).ready(function(){
	consol.log(`hi`);
	 $('.header_submenu').hover(function() {
		$('.header_container').addClass('.header_container_open');
	
	});
});
	


function login_chk(){
	if(document.frm.id.value==""){
		alert("아이디를 입력하여 주세요.");
		document.frm.id.focus();
		return false;
	}else if(document.frm.pwd.value==""){
		alert("비밀번호를 입력하여 주세요.");
		document.frm.pwd.focus();
		return false;
	}
	return true;
}


function check_input1(){
	var a = document.getElementById("name");
	var b = document.getElementById("name_coment");
	if(a.value != ""){
		b.innerText = "";
	}else{
		b.innerText = "이름을 입력해 주세요.";
	}
}

function check_input2(){
	var a = document.getElementById("phone");
	var b = document.getElementById("phone_coment");
	if(a.value != ""){
		b.innerText = "";
	}else{
		b.innerText = "휴대폰 번호를 입력해 주세요.";
	}
}
function check_input3(){
	var a = document.getElementById("id");
	var b = document.getElementById("id_coment");
	if(a.value != ""){
		b.innerText = "";
	}else{
		b.innerText = "아이디를 입력해 주세요.";
	}
}
