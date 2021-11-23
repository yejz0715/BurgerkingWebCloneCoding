package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=loginForm";
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		request.getRequestDispatcher(url).forward(request, response);
	}
}
