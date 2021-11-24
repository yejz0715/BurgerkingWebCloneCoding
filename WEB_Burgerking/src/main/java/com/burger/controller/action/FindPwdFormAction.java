package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindPwdFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Member/findPwdForm.jsp";
		if(request.getParameter("id")!="");
		{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
