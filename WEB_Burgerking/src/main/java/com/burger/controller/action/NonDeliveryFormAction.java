package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.NonMemberDao;
import com.burger.dao.ProductDao;
import com.burger.dto.MemberVO;
import com.burger.dto.NonMemberVO;
import com.burger.dto.ProductVO;

public class NonDeliveryFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/nondelivery.jsp";
		
		HttpSession session = request.getSession();
		NonMemberVO nmvo = (NonMemberVO)session.getAttribute("NonloginUser");
		
		System.out.println(nmvo);
		
		NonMemberDao nmdao = NonMemberDao.getInstance();
		NonMemberVO nmvo1 = nmdao.getNonMember("id");
		
		String kind1 = request.getParameter("kind1");
		
		ProductDao pdao = ProductDao.getInstance();
		ArrayList<ProductVO> list = pdao.getProductList(kind1);
		
		request.setAttribute("nonMemberVO", nmvo1);
		request.setAttribute("productList", list);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
