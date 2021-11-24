package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class FindIdAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "Member/showIdForm.jsp";
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.findMember(name, phone);
		
		request.setAttribute("memberVO", mvo);
		request.getRequestDispatcher(sql).forward(request, response);
	}
}
