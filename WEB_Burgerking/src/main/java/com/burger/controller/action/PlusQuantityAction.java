package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.CartDao;
import com.burger.dto.CartVO;

public class PlusQuantityAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cseq = request.getParameter("cseq");
		
		CartDao cdao = CartDao.getInstance();
		
		cdao.plusQuantity(cseq);
		
		
		response.sendRedirect("burger.do?command=deliveryCartForm");

	}

}
