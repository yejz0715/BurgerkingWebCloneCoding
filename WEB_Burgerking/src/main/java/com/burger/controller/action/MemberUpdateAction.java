package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class MemberUpdateAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		if (mvo == null) {
			String url = "burger.do?command=LoginFormAction";
		}else {

		//MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setPhone(request.getParameter("phone"));

		System.out.print("mvo, " + mvo);

		MemberDao mdao = MemberDao.getInstance();
		mdao.updateMember(mvo);

		
		session.setAttribute("loginUser", mvo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("burger.do?command=deliveryForm");
		dispatcher.forward(request, response);
		}
	}

}
