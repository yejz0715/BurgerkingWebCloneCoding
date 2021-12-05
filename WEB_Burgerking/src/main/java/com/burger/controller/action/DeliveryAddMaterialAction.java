package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.ProductDao;
import com.burger.dao.subProductDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.ProductVO;
import com.burger.dto.subProductVO;

public class DeliveryAddMaterialAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url;
		if (mvo == null) {
		    url = "burger.do?command=loginForm&non=1";
		}else{
			String pseq = request.getParameter("pseq");
			
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProducts(pseq);
			
			//로그인이 되어 있다면 로그인 정보에스 id 를 추출하고  상품번호와 아이디를  CartVO 에 담아서
			CartVO cvo = new CartVO();
			cvo.setId( mvo.getId() );   // 아이디 저장
			cvo.setPseq( Integer.parseInt( request.getParameter("pseq")));  // 상품번호저장
			CartDao cdao = CartDao.getInstance();   
			subProductDao spdao = subProductDao.getInstance();
			ArrayList<subProductVO> list = spdao.getSubProduct();
			// Cart 테이블에 추가합니다
			System.out.println(list);
			
			cdao.insertCart( cvo );   // 레코드 추가
			url = "Delivery/addMeterial.jsp";
			request.setAttribute("subProductVO", list);
			request.setAttribute("pvo", pvo);
			request.setAttribute("cvo", cvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}