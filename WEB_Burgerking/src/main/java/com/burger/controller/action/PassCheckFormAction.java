package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.QnaDao;
import com.burger.dto.QnaVO;

public class PassCheckFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ServiceCenter/passChk.jsp";
		QnaDao qdao = QnaDao.getInstance();
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		QnaVO qvo = qdao.getQna2(qseq);
		request.setAttribute("qvo", qvo);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
