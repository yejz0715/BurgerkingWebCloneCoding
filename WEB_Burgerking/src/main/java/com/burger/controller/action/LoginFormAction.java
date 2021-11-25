package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Member/login.jsp";
		if(request.getParameter("non").equals("2")) {
			String non = "2";
			request.setAttribute("non", non);
		}else {
			 String non = "1";
			 request.setAttribute("non", non);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
