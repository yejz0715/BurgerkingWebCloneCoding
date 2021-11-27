package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.MemberDao;
import com.burger.dto.AdminVO;
import com.burger.dto.MemberVO;

public class AdminMemberUpdateFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/memberUpdate.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "burger.do?command=admin";
		}else {
			// 전달된 상품번호로 상품 상세 내역을 조회하고 리퀘스트에 저장합니다.
			String mseq = request.getParameter("mseq");
			MemberDao mdao = MemberDao.getInstance();
			MemberVO mvo = mdao.getMember_mseq(mseq);
			request.setAttribute("memberVO", mvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
