package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.controller.action.Action;
import com.burger.dao.MemberDao;
import com.burger.dao.ProductDao;

public class AdminMemberDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] mseqArr = request.getParameterValues("delete");
		
		MemberDao mdao = MemberDao.getInstance();
		for(String mseq : mseqArr) { 
			mdao.deleteMember(mseq);
		}
		response.sendRedirect("burger.do?command=adminMemberList");
	}
}
