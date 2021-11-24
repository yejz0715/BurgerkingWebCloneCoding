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
		
		ProductDao pdao = ProductDao.getInstance();
		ShortProductDao spdao = ShortProductDao.getInstance();
		
		//String pname = request.getParameter("pname");
		//shortProductVO spvo = spdao.getShortProductdetail(pname);
		String spseq = request.getParameter("spseq");
		shortProductVO spvo = spdao.getShortProductdetail(spseq);
		
		ArrayList<ProductVO> list = pdao.getProductdetail(spvo.getKind1(), spvo.getKind2());
		
		System.out.println(spvo);
		System.out.println(list);
		
		request.setAttribute("productVO", list);
		request.setAttribute("shortProductVO", spvo);
		request.getRequestDispatcher(url).forward(request, response);	

	}

}
