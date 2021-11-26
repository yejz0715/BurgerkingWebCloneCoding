package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dto.AdminVO;

public class AdminProductWriteFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productWrite.jsp";
		
		HttpSession session = request.getSession();

		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin"); 
		if(avo == null) {
			url = "burger.do?command=admin"; 
		}else { 
			String kindList[] = {"스페셜&할인팩", "프리미엄", "와퍼", "주니어&버거", "올데이킹&치킨버거", "사이드", "음료&디저트", "독퍼"};
			request.setAttribute("kindList", kindList); 
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
