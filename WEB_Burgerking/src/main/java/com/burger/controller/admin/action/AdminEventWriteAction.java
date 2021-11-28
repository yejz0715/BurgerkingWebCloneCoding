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

public class AdminEventWriteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=adminEventList";
		
		HttpSession session = request.getSession(); 
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo == null) { 
			url = "burger.do?command=admin"; }
		else {
			// 현재 프로젝트의 세션을 통해 적용할 저장경로 얻음
			ServletContext context = session.getServletContext(); 
			String uploadFilePath = context.getRealPath("image/main/event/eventDetail");
			
			// MultipartRequest 객체 생성 - 파일 업로드 
			MultipartRequest multi = new MultipartRequest( request, uploadFilePath, 5*1024*1024, "UTF-8");
			
			AdminDao adao = AdminDao.getInstance();
			
			// 나머지 파라미터들을 dto에 저장
			EventVO evo = new EventVO();
			evo.setSubject(multi.getParameter("subject"));
			evo.setContent(multi.getParameter("content"));
			evo.setEnddate(Timestamp.valueOf(multi.getParameter("enddate")));
			evo.setImage(multi.getFilesystemName("image"));
			adao.insertEvent(evo);
		}
		response.sendRedirect(url);
	}
}
