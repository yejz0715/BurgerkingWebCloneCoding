package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class FindPwdAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Member/sendPwdForm.jsp";
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.findPwd(name, id);
		
		request.setAttribute("memberVO", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
