package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.controller.action.Action;
import com.burger.dao.EventDao;

public class AdminEventDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] eseqArr = request.getParameterValues("delete");
		
		EventDao edao = EventDao.getInstance();
		for(String eseq : eseqArr) { 
			edao.deleteEvent(eseq);
		}
		response.sendRedirect("burger.do?command=adminEventList");
	}
}
