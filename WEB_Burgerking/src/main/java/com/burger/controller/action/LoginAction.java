package com.burger.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.MemberDao;
import com.burger.dto.MemberVO;

public class LoginAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember(id);
		
		if(mvo == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('입력하신 아이디가 없습니다.'); location.href='burger.do?command=loginForm';</script>");
			writer.close();
		}else if(mvo.getPwd() == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원정보 오류 관리자에게 문의하세요'); location.href='burger.do?command=loginForm';</script>");
			writer.close();
		}else if(!mvo.getPwd().equals(pwd)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('비밀번호가 틀렸습니다.'); location.href='burger.do?command=loginForm';</script>");
			writer.close();
		}else {
			HttpSession session = request.getSession();
			mdao.setLastDate(mvo);
			session.setAttribute("loginUser", mvo);
			url="burger.do?command=deliveryForm&kind1=1";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
