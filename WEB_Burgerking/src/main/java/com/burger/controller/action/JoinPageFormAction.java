package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class JoinPageFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setName(request.getParameter("name"));
		

		MemberDao mdao = MemberDao.getInstance();
		mdao.insertMember(mvo);
		
		response.sendRedirect("burger.do?command=complet");

	}

}
