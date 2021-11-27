package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.ProductDao;
import com.burger.dto.ProductVO;

public class DeliveryAddMaterialAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=addCart";
		
		request.setCharacterEncoding("UTF-8");
		String pseq = request.getParameter("pseq");
		String kind1 = request.getParameter("kind1");
		
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProducts(pseq);

		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
