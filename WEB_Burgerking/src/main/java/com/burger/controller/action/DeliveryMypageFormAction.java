package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class DeliveryMypageFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Delivery/myPage.jsp";
						
	    
		HttpSession session =request.getSession();
		MemberVO mvo=(MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url="burger.do?command=LoginFormAction";
		}
		request.setAttribute("MemberVO", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
