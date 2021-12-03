package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.OrderDao;
import com.burger.dao.ProductDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.NonMemberVO;
import com.burger.dto.ProductVO;
import com.burger.dto.orderVO;


public class DeliveryFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/delivery.jsp";
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(); 
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		NonMemberVO nmvo = (NonMemberVO)session.getAttribute("NonloginUser");
		
		if (mvo == null&&nmvo==null) {
		    url = "burger.do?command=loginForm&non=1";
		}else if(mvo == null&&nmvo!=null){
			String kind1 = request.getParameter("kind1");
			
			ProductDao pdao = ProductDao.getInstance();
	
			ArrayList<ProductVO> list = pdao.getProductList(kind1);
			
	
			OrderDao odao = OrderDao.getInstance();
			ArrayList<orderVO> list1 = odao.getOrderList(nmvo.getId());
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list2 = cdao.nonSelectCart(nmvo.getId() );	
			
			request.setAttribute("ovo", list1);
			request.setAttribute("cvo", list2);
			request.setAttribute("productList", list);
		}else {
			String kind1 = request.getParameter("kind1");
			
			ProductDao pdao = ProductDao.getInstance();
	
			ArrayList<ProductVO> list = pdao.getProductList(kind1);
			
	
			OrderDao odao = OrderDao.getInstance();
			ArrayList<orderVO> list1 = odao.getOrderList(mvo.getId());
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list2 = cdao.selectCart( mvo.getId() );	
			
			request.setAttribute("ovo", list1);
			request.setAttribute("cvo", list2);
			request.setAttribute("productList", list);
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
