package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.dao.MemberDao;
import com.burger.dto.AddressVO;


public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dong=request.getParameter("dong");
		if( dong != null) {
			if( dong.equals("") == false ) {
				MemberDao mdao = MemberDao.getInstance();
				ArrayList<AddressVO> list = mdao.selectAddressByDong(dong);
				request.setAttribute("addressList", list);
				System.out.println(dong);
				System.out.println(list.size());
			}
		}else {
			// 아무 것도 안하고 그냥 findZipNum.jsp 로 이동
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Member/findZipNum.jsp");
		dispatcher.forward(request, response); 

	}

}
