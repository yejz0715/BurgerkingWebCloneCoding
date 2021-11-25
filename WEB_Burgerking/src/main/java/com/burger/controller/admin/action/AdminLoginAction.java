package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.AdminDao;
import com.burger.dto.AdminVO;

public class AdminLoginAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		String url = "burger.do?command=admin";
		String msg = ""; // 로그인 결과를 저장했다가 request.를 통해 전송될 변수
		
		// AdminDao 생성 후 인스턴스를 얻습니다.
		AdminDao adao = AdminDao.getInstance();
		// AdminDao 안의 workerCheck 메소드를 생성 후 호출합니다.
		
		AdminVO avo = adao.adminCheck(adminId);
		
		if (avo == null) {
			msg = "없는 아이디 입니다.";
		} else if (avo.getPwd() == null) {
			msg = "DB 오류. 관리자에게 문의하세요.";
		} else if (!avo.getPwd().equals(adminPwd)) {
			msg = "암호가 다릅니다.";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", avo);
			/* url = "burger.do?command=adminProductList"; */
			url = "admin/main.jsp";
		}
		request.setAttribute("message", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
