package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dto.MemberVO;

public class DeliveryOrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Delivery/userDetail.jsp";

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
			url = "burger.do?command=LoginFormAction&non=1";
		}else {
			
			
			
		}

		
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
