package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.EventDao;
import com.burger.dto.AdminVO;
import com.burger.dto.EventVO;

public class AdminEventDetailAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/event/eventDetail.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) { 
			url = "burger.do?command=admin"; 
		}else { 
			String eseq = request.getParameter("eseq"); 
			// 이미 만들어져 있는 메소드 사용 
			EventDao edao =	 EventDao.getInstance();
			EventVO evo = edao.getEvent(eseq);
			
			request.setAttribute("eventVO", evo); 
		}
		request.getRequestDispatcher(url).forward(request,response);
	}
}
