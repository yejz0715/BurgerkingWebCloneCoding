package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.QnaDao;
import com.burger.dto.MemberVO;
import com.burger.dto.QnaVO;

public class QnaFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ServiceCenter/qnaList.jsp";
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			
		}else {
			QnaDao qdao = QnaDao.getInstance();
			ArrayList<QnaVO> list = qdao.getQna(mvo.getId());
			request.setAttribute("qnaList", list);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
