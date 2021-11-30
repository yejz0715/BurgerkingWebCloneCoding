package com.burger.controller.admin.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.AdminDao;
import com.burger.dto.AdminVO;
import com.burger.dto.EventVO;
import com.oreilly.servlet.MultipartRequest;

public class AdminEventUpdateAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=adminEventDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) url = "burger.do?command=admin"; 
		else { 
			EventVO evo = new EventVO();
			ServletContext context = session.getServletContext(); 
			String path = context.getRealPath("image/main/event/eventDetail");
			
			MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024,
					"UTF-8");
			evo.setEseq(Integer.parseInt(multi.getParameter("eseq")));
			evo.setSubject(multi.getParameter("subject"));
			evo.setContent(multi.getParameter("content"));
			evo.setEnddate(Timestamp.valueOf(multi.getParameter("enddate")));
			
			if(multi.getFilesystemName("image") == null)
				evo.setImage(multi.getParameter("oldImage"));
			else
				evo.setImage(multi.getFilesystemName("image"));
		
			AdminDao adao = AdminDao.getInstance(); 
			adao.updateEvent(evo);
		
			url = url + "&eseq=" + evo.getEseq(); 
		} 
		response.sendRedirect(url);
	}
}
