package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.NonMemberDao;
import com.burger.dto.NonMemberVO;

public class NonMemberJoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NonMemberVO nmvo = new NonMemberVO();
		nmvo.setId(request.getParameter("id"));
		nmvo.setPwd(request.getParameter("password"));
		nmvo.setPhone(request.getParameter("phone"));
		
		NonMemberDao mdao = NonMemberDao.getInstance();
		mdao.insertNonMember(nmvo);
		
		NonMemberDao mdao1 = NonMemberDao.getInstance();
		NonMemberVO nmvo1 = mdao1.getNonMember(nmvo.getId());
		
		System.out.println(nmvo1);
		
		HttpSession session = request.getSession();
		session.setAttribute("NonloginUser", nmvo1);
		
		response.sendRedirect("burger.do?command=nonDeliveryForm&kind1=1");
	}

}
