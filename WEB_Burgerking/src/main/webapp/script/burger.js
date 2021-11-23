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

function find_id(){
	var url = "burger.do?command=findIdForm";
	var opt = "toolbar=no, menubar=no, resizable=no, width=700, height=500, top=300, left=300";
	window.open(url, "Find Id", opt);
}
function find_pwd(){
	var url = "burger.do?command=findPwdForm";
	var opt = "toolbar=no, menubar=no, resizable=no, width=700, height=500, top=300, left=300";
	window.open(url, "Find Pwd", opt);
}