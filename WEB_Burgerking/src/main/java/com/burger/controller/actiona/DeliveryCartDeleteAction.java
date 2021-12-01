package com.burger.controller.actiona;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.CartDao;
import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class DeliveryCartDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=deliveryCartForm";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo == null) {
			url = "burger.do?command=loginForm&non=1";
		}else {
			String cseqArr = request.getParameter("menu");
			String[] cA = cseqArr.split(",");
			CartDao cdao = CartDao.getInstance();
			for(String cseq : cA) { 
				cdao.deleteCart(cseq);
			}
			response.sendRedirect("burger.do?command=deliveryCartForm");
		}
	}
}
