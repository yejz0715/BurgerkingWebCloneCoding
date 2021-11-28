function go_qna_search(){
	if(document.frm.key.value=="")
		return;
		
	var url = "burger.do?command=adminQnaList&page=1";
	// 보던 페이지가 어떤 페이지이던간에 검색 결과의 1페이지로 가기위해 파라미터 page를 1로 전송
	document.frm.action = url;
	document.frm.submit();
}

function go_qna_total(){
	document.frm.key.value="";
	document.frm.action = "burger.do?command=adminQnaList&page=1";
	document.frm.submit();
}