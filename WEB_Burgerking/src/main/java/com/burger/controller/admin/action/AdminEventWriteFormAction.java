package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dto.AdminVO;

public class AdminEventWriteFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/event/eventWrite.jsp";
		
		HttpSession session = request.getSession();

		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin"); 
		if(avo == null) {
			url = "burger.do?command=admin"; 
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
