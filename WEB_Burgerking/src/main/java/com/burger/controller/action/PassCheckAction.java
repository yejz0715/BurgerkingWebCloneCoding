package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.QnaDao;
import com.burger.dto.MemberVO;
import com.burger.dto.QnaVO;

public class PassCheckAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=qnaView";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			url = "buger.do?command=index";
		}else {
			int qseq = Integer.parseInt(request.getParameter("qseq"));
			System.out.println(qseq);
			int pass = Integer.parseInt(request.getParameter("pass"));
			QnaDao qdao = QnaDao.getInstance();
			QnaVO qvo = qdao.getQna2(qseq);
			if(qvo.getPass() == pass) {
				url = url + "&qseq="+ qseq;
				request.setAttribute("qnaVO", qvo);
			}else {
				url = "burger.do?command=qnaForm";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
