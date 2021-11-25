package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;

public class AdminLogoutAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=admin";
		HttpSession session = request.getSession();
		session.removeAttribute("loginAdmin");
		request.getRequestDispatcher(url).forward(request, response);
	}
}
