package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.QnaDao;
import com.burger.dto.MemberVO;
import com.burger.dto.QnaVO;

public class QnaWriteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=qnaForm";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			url = "burger.do?command=index";
		}else {
			QnaVO qvo = new QnaVO();
			qvo.setId(request.getParameter("id"));
			qvo.setSubject(request.getParameter("subject"));
			qvo.setContent(request.getParameter("content"));
			qvo.setPass(Integer.parseInt(request.getParameter("pass")));
			QnaDao qdao = QnaDao.getInstance();
			qdao.writeQna(qvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
