package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.AdminDao;
import com.burger.dto.AdminVO;
import com.burger.dto.MemberVO;

public class AdminMemberUpdateAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "burger.do?command=adminMemberList";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) url = "burger.do?command=admin"; 
		else { 
			MemberVO mvo = new MemberVO();
			mvo.setMseq(Integer.parseInt(request.getParameter("mseq")));
			mvo.setId(request.getParameter("id"));
			mvo.setName(request.getParameter("name"));
			mvo.setPwd(request.getParameter("pwd"));
			mvo.setPhone(request.getParameter("phone"));
			AdminDao adao = AdminDao.getInstance(); 
			adao.updateMember(mvo);
		} 
		response.sendRedirect(url);
	}
}
