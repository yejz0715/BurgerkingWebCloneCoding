package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.OrderDao;
import com.burger.dao.subProductDao;
import com.burger.dao.subproductOrderDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.orderVO;
import com.burger.dto.subProductVO;
import com.burger.dto.subproductOrderVO;

public class DeliveryCartFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/cart.jsp"; // 최종 목적지

		
		HttpSession session = request.getSession(); 
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		
		if (mvo == null) {
		    url = "burger.do?command=loginForm&non=1";
		}else{
			// 로그인 유저의 아이디로 카트물건들을 검색해서 리턴받습니다 
			ArrayList<subProductVO> sublist = null;
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list = cdao.selectCart( mvo.getId() );		
			
			request.setAttribute("cartList", list); // 리퀘스트에 리턴받은 리스트 저장 
			// 리턴받은 카트 리스트에 있는 상품들의 총구매금액을 계산합니다 
			int totalPrice = 0; 
			for(CartVO cvo : list) totalPrice += cvo.getPrice1() * cvo.getQuantity(); // 금액*수량이 누적 -> 총금액을 추가로 계산
			OrderDao odao = OrderDao.getInstance();
			ArrayList<orderVO> list1 = odao.getOrderList(mvo.getId());
			ArrayList<CartVO> list2 = cdao.selectCart(mvo.getId());
			
			subproductOrderDao spodao = subproductOrderDao.getInstance();
			ArrayList<subproductOrderVO> spovo = spodao.selectSubProductOrder(mvo.getMseq());
			request.setAttribute("spseqAm", spovo);
			for(int i = 0; i < spovo.size(); i++) {
				totalPrice += spovo.get(i).getAddprice();
			}
	
			request.setAttribute("totalPrice", totalPrice); // 리퀘스트에 저장
			request.setAttribute("ovo", list1);
			request.setAttribute("cvo", list2);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
