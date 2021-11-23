package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.controller.action.Action;

public class FaqFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String f = request.getParameter("fnum");
		String url = "ServiceCenter/faqList" + f + ".jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
