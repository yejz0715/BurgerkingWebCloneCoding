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

function check_input4(){
	var a = document.getElementById("pwd");
	var b = document.getElementById("pwd_coment");
	if(a.value != ""){
		b.innerText = "";
	}else{
		b.innerText = "새 비밀번호를 입력해 주세요.";
	}
}
function check_input5(){
	var a = document.getElementById("pwd_chk");
	var b = document.getElementById("pwd_chk_coment");
	if(a.value != ""){
		b.innerText = "";
	}else{
		b.innerText = "비밀번호 재확인";
	}
}

function inputidChk(){
	if(document.frm.name.value==""){
		alert("이름을 입력해주세요.");
		document.frm.name.focus();
		return false;
	}else if(document.frm.phone.value==""){
		alert("핸드폰 번호를 입력해주세요.");
		document.frm.phone.focus();
		return false;
	}
	return true;
}
function inputpwdChk(){
	if(document.frm.name.value==""){
		alert("이름을 입력해주세요.");
		document.frm.name.focus();
		return false;
	}else if(document.frm.id.value==""){
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	}
	return true;
}
function updatepwdChk(){
	if(document.frm.pwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.frm.pwd.focus();
		return false;
	}else if(document.frm.pwd.value!=document.frm.pwd_chk.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		document.frm.pwd_chk.focus();
		return false;
	}
	return true;
}

function deliveryDetail(pseq){
	var url = "burger.do?command=deliveryDetail&pseq="+pseq;
	var opt = "toolbar=no,menubar=no,scrollbars=yes,resizable=no,height=800,width=580,top=300, left=300";
	window.open(url, "delivery", opt);
}


function add_or_cart(kind1, pseq){
	var url="";
	if(kind1.value=="1"){
		url="burger.do?command=addCart&pseq"+pseq;
	}else if(kind1.value=="6"){
		url="burger.do?command=addCart&pseq"+pseq;
	}else if(kind1.value=="7"){
		url="burger.do?command=addCart&pseq"+pseq;
	}else if(kind1.value=="8"){
		url="burger.do?command=addCart&pseq"+pseq;
	}else{
		url="burger.do?command=deliveryAddMaterial&pseq="+pseq;
	}
	window.location.replace(url);
}

function go_cart(pseq, id){
	opener.document.cartForm.pseq.value=pseq;
	opener.document.cartForm.id.value=id;
	opener.cartForm.submit();
	self.close();
}
function go_cart02(id){
	document.cartForm.id.value=id;
	document.cartForm.action="burger.do?command=deliveryCartForm";
	document.cartForm.submit();
}


function go_cart_delete(cseq){
	var url="burger.do?command=cartDelete&cseq="+cseq;
	window.location.replace(url);
}


function menu_plus(){
	var url="burger.do?command=deliveryForm&kind1=1";
	window.location.replace(url);
}

function go_order_insert(){
	document.cartForm.id.value=id;
	document.cartForm.action="burger.do?command=deliveryCartOrder";
	document.cartForm.submit();
	var url="burger.do?command=deliveryCartOrder";
	window.location.replace(url);
}