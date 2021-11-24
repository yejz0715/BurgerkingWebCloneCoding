package com.burger.controller.action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.EventDao;
import com.burger.dto.EventVO;

public class EventDetailFormAction implements Action {	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="Event/eventDetail.jsp";
        String eseq = request.getParameter("eseq");
        
		EventDao edao = EventDao.getInstance();
	    EventVO evo = edao.getDetailEvent(eseq);
	    request.setAttribute("EventVO", evo);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
