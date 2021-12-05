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
import com.burger.dto.MyAddressVO;
import com.burger.dto.orderVO;

public class MyAddressFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/myaddress.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
		    url = "burger.do?command=loginForm&non=1";
		}else{
			OrderDao odao = OrderDao.getInstance();
			ArrayList<orderVO> list1 = odao.getOrderList(mvo.getId());
			CartDao cdao = CartDao.getInstance();
			ArrayList<CartVO> list2 = cdao.selectCart( mvo.getId() );

			String id = request.getParameter("id");
			MemberDao mdao = MemberDao.getInstance();
			int result = mdao.checkMyAddress(mvo.getMseq());
			if (result == 1) {
				url = "Delivery/myaddressUpdate.jsp";
				MyAddressVO mavo=mdao.getMyAddress(mvo.getMseq());
				String m =mavo.getAddress();
				String[] m2= m.split(" ");
				String addr1="";
				for(int i=0; i<3; i++) {
					addr1 += m2[i] + " ";
				}
				String addr2="";
				for(int i=3; i<m2.length; i++) {
					addr2 += m2[i] + " ";
				}			 
				request.setAttribute("addr1", addr1);
				request.setAttribute("addr2", addr2);
				request.setAttribute("MyAddressVO", mavo);
				request.setAttribute("ovo", list1);
				request.setAttribute("cvo", list2);
				
				MemberVO mvo1 = mdao.getMember(id);
				request.setAttribute("MemberVO", mvo1);
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
