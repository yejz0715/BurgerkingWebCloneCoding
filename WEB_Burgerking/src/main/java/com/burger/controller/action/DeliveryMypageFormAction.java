package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.MemberDao;
import com.burger.dao.OrderDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.orderVO;

public class DeliveryMypageFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Delivery/myPage.jsp";	
	       
		HttpSession session =request.getSession();
		MemberVO mvo=(MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url="burger.do?command=LoginFormAction&non=1";
			
		}
		OrderDao odao = OrderDao.getInstance();
		ArrayList<orderVO> list1 = odao.getOrderList(mvo.getId());
		CartDao cdao = CartDao.getInstance();
		ArrayList<CartVO> list2 = cdao.selectCart( mvo.getId() );	
		
		request.setAttribute("ovo", list1);
		request.setAttribute("cvo", list2);
		request.setAttribute("MemberVO", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
