package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 필요한 값 전달 코드 작성 필요
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
