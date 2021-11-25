package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.ProductDao;
import com.burger.dto.ProductVO;

public class DeliveryDetailFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="delivery/deliveryDetail.jsp";
		
		ProductDao pdao = ProductDao.getInstance();
		
		String pseq = request.getParameter("pseq");
		ArrayList<ProductVO> list = pdao.getProductdetail(pseq);
		ProductVO pvo = list.get(0);
		
		ArrayList<ProductVO> list2 = pdao.getProductkind(pvo.getKind1(), pvo.getKind2());
		
		System.out.println(list2);
		
		request.setAttribute("list2", list2);
		request.setAttribute("pvo", pvo);
		request.getRequestDispatcher(url).forward(request, response);	

	}

}
