package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.controller.action.Action;
import com.burger.dao.QnaDao;

public class AdminQnaDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] qseqArr = request.getParameterValues("delete");
		
		QnaDao qdao = QnaDao.getInstance();
		for(String qseq : qseqArr) { 
			qdao.deleteQna(qseq);
		}
		response.sendRedirect("burger.do?command=adminQnaList");

	}

}
