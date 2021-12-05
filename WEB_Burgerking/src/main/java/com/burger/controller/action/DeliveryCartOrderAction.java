package com.burger.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.MyAddressDao;
import com.burger.dao.OrderDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.MyAddressVO;

public class DeliveryCartOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
		    url = "burger.do?command=loginForm&non=1";
		}else{
			MyAddressDao madao = MyAddressDao.getInstance();
			MyAddressVO mavo = null;
			mavo =  madao.getAddress(mvo.getMseq());
			if(mavo.getAddress() == null || mavo.getAddress().equals("")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('입력하신 배송지가 없습니다.'); location.href='burger.do?command=myAddressForm';</script>");
				writer.close();
			}else {
				CartDao cdao = CartDao.getInstance();
				// 주문자 아이디로 검색한 카트 목록(지금 주문 처리할) 목록을 먼저 조회합니다
				ArrayList<CartVO> list = cdao.selectCart( mvo.getId() );
							
				OrderDao odao = OrderDao.getInstance();
				// 추출한 list 와 주문자의 아디를 갖고 OrderDao 에 가서 오더 와 오더 디테일에 데이터를 추가합니다.
				// 방금 추가한 주문의 주문번호를 리턴받습니다
				int Oseq = odao.insertOrder(list, mvo.getId());
				
				// 방금 주문에 성공한 주문 번호를 갖고 오더 리스트로 이동합니다.
				url = "burger.do?command=deliveryOrderList&oseq="+ Oseq;
			}
		}
		response.sendRedirect(url);
	}

}
