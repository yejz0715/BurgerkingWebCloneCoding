package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.EventDao;
import com.burger.dto.EventVO;

public class EventListFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Event/eventList.jsp";

		EventDao edao = EventDao.getInstance();
		ArrayList<EventVO> list = edao.getAllEvents();
		request.setAttribute("eventlist", list);
		request.getRequestDispatcher(url).forward(request, response);

	}
}
