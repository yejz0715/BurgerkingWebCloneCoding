package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventTab3Action implements Action {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Event/eventTab3.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
