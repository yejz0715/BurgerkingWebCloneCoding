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
		String url = "Delivery/delivery.jsp";
		
		request.setCharacterEncoding("UTF-8");
		String pseq = request.getParameter("pseq");
		String kind1 = request.getParameter("kind1");
		
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProducts(pseq);
		if(kind1=="7") {
			//음료일경우 카트에 담기
			request.setAttribute("pvo", pvo);
			url = "burger.do?commend=deliveryOrderListForm";
		}else if(kind1=="6") {
			//사이드일경우 카트에 담기
			request.setAttribute("pvo", pvo);
			url = "burger.do?commend=deliveryOrderListForm";
		}else if(kind1=="8") {
			//독퍼일경우 카트에 담기
			request.setAttribute("pvo", pvo);
			url = "burger.do?commend=deliveryOrderListForm";
		}else if(kind1=="8") {
			//스페셜메뉴일경우 카트에 담기
			request.setAttribute("pvo", pvo);
			url = "burger.do?commend=deliveryOrderListForm";
		}else {
			request.setAttribute("pvo", pvo);
			url = "burger.do?commend=deliveryOrderListForm";
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
