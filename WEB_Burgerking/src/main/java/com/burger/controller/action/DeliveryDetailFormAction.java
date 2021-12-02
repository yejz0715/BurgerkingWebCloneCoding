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
		String url="Delivery/deliveryDetail.jsp";
		
		ProductDao pdao = ProductDao.getInstance();
		String pseq = request.getParameter("pseq");
		System.out.println("deliveryDetailForm : " + pseq);
		ProductVO  pvo = pdao.getDeliverydetail(pseq);
		System.out.println("pvo pseq : " + pvo.getPseq());
		System.out.println("pvo kind1 : " + pvo.getKind1());
		System.out.println("pvo kind2 : " + pvo.getKind2());
		ArrayList<ProductVO> list2 = pdao.getProductkind(pvo.getKind1(), pvo.getKind2());
		for(int i = 0; i < list2.size(); i++) {
			System.out.println("list2 pseq : " + list2.get(i).getPseq());
			System.out.println("list2 kind1 : " + list2.get(i).getKind1());
			System.out.println("list2 kind2 : " + list2.get(i).getKind2());
		}
		request.setAttribute("list2", list2);
		request.setAttribute("pvo", pvo);
		request.getRequestDispatcher(url).forward(request, response);	

	}

}
