package com.burger.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.MyAddressDao;
import com.burger.dto.MemberVO;
import com.burger.dto.MyAddressVO;



public class MyAddressAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="Delivery/myPage.jsp";
		
		
		HttpSession session =request.getSession();
		MemberVO mvo=(MemberVO) session.getAttribute("loginUser");
		if(mvo==null) {
			url="burger.do?command=LoginFormAction";
		}else {
			int mseq = mvo.getMseq();
			String zip_num=request.getParameter("zip_num");
			String addr1=request.getParameter("addr1");
			String addr2=request.getParameter("addr2");
			String address=addr1 + " " + addr2;
			
			MyAddressDao madao=MyAddressDao.getInstance();
			madao.insertMyAddress(mseq, address,zip_num);
		   
		    request.setAttribute("MemberVO", mvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);		
	}
}