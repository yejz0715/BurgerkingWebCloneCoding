package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.AdminDao;
import com.burger.dto.AdminVO;
import com.burger.dto.QnaVO;

public class AdminQnaRepsaveAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=adminQnaDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) {
			url = "burger.do?command=admin";
		}else {
			AdminDao adao = AdminDao.getInstance();
			QnaVO qvo = new QnaVO();
			qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
			qvo.setReply(request.getParameter("reply"));
			// 답글 저장 및 답글 상태 변경('1' -> '2')
			adao.updateQna(qvo);
			// 원래 보던 Qna 페이지로 이동
			url = url + "&qseq=" + request.getParameter("qseq");
		}
		response.sendRedirect(url);
	}
}
