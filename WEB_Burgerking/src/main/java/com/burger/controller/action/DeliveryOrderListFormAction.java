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
import com.burger.dto.NonMemberVO;
import com.burger.dto.orderVO;

public class DeliveryOrderListFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/orderList.jsp";
		int oseq = Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo1 = mdao.getMember(session.getId());
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		NonMemberVO nmvo = (NonMemberVO)session.getAttribute("NonloginUser");
		
		if (mvo == null&&nmvo==null) {
		    url = "burger.do?command=loginForm&non=1";
		}else if(mvo == null&&nmvo!=null){
			CartDao cdao = CartDao.getInstance();
			OrderDao odao = OrderDao.getInstance();
			//  order_view 에서 주문번호와  로그인 아이디로 주문을 검색
			ArrayList<orderVO> list = odao.nonListOrderById( nmvo.getId() , oseq );
			int totalPrice=0;
			for(orderVO ovo : list)  // 조회된 주문의 총 결제금액 계산
				totalPrice+=ovo.getPrice1() * ovo.getQuantity();	
			// 리퀘스트에 저장
			orderVO ovo = list.get(0);	
			
			ArrayList<orderVO> list2 = odao.getNonOrderList(nmvo.getId());
			ArrayList<CartVO> list3 = cdao.nonSelectCart( nmvo.getId() );
			request.setAttribute("ovo", list2);
			request.setAttribute("cvo", list3);
			
			request.setAttribute("nonMemberVO", nmvo);
			request.setAttribute("orderVO", ovo);
			request.setAttribute("orderList", list);
	        request.setAttribute("totalPrice", totalPrice);
		}else {
			CartDao cdao = CartDao.getInstance();
			OrderDao odao = OrderDao.getInstance();
			//  order_view 에서 주문번호와  로그인 아이디로 주문을 검색
			ArrayList<orderVO> list = odao.listOrderById( mvo.getId() , oseq );
			int totalPrice=0;
			for(orderVO ovo : list)  // 조회된 주문의 총 결제금액 계산
				totalPrice+=ovo.getPrice1() * ovo.getQuantity();	
			// 리퀘스트에 저장
			orderVO ovo = list.get(0);	
			
			ArrayList<orderVO> list2 = odao.getOrderList(mvo.getId());
			ArrayList<CartVO> list3 = cdao.selectCart( mvo.getId() );
			request.setAttribute("ovo", list2);
			request.setAttribute("cvo", list3);
			
			request.setAttribute("orderVO", ovo);
			request.setAttribute("memberVO", mvo1);
			request.setAttribute("orderList", list);
	        request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
