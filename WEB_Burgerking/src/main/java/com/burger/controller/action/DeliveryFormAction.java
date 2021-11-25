package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.ProductDao;
import com.burger.dao.ShortProductDao;
import com.burger.dto.ProductVO;
import com.burger.dto.shortProductVO;

public class DeliveryFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/delivery.jsp";
		
		request.setCharacterEncoding("UTF-8");
		String kind1 = request.getParameter("kind1");
		
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductVO> list = pdao.getProduct(kind1);

		request.setAttribute("productList", list);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
