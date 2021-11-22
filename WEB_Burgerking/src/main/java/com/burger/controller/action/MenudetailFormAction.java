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

public class MenudetailFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Product/productDetail.jsp";
		String pseq = request.getParameter("pseq");
		String kind1 = request.getParameter("kind1");
		
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct(pseq);
		
		ShortProductDao spdao = ShortProductDao.getInstance();
		ArrayList<shortProductVO> list = spdao.getShortProduct(kind1);
		
		request.setAttribute("ProductList", pvo);
		request.setAttribute("ShortProductList", list);
		request.getRequestDispatcher(url).forward(request, response);	

	}

}
