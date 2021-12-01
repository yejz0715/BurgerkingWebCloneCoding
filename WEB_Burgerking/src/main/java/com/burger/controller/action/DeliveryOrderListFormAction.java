package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.OrderDao;
import com.burger.dto.MemberVO;
import com.burger.dto.orderVO;

public class DeliveryOrderListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/orderList.jsp";
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
		    url = "burger.do?command=loginForm";
		}else {
			OrderDao odao = OrderDao.getInstance();
			//  order_view 에서 주문번호와  로그인 아이디로 주문을 검색
			ArrayList<orderVO> list = odao.listOrderById( mvo.getId() , oseq );
			int totalPrice=0;
			for(orderVO ovo : list)  // 조회된 주문의 총 결제금액 계산
				totalPrice+=ovo.getPrice1() * ovo.getQuantity();	
			// 리퀘스트에 저장
			
			System.out.println(list);
			
			request.setAttribute("orderList", list);
	        request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
