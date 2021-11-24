package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.MemberDao;

public class UpdatePwdAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=loginForm";
		MemberDao mdao = MemberDao.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		mdao.updatePwd(id, pwd);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
