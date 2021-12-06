package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.ProductDao;
import com.burger.dto.AdminVO;
import com.burger.dto.ProductVO;

public class AdminProductDetailAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productDetail.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) { 
			url = "burger.do?command=admin"; 
		}else { 
			String pseq = request.getParameter("pseq"); 
			// 이미 만들어져 있는 메소드 사용 
			ProductDao pdao =	ProductDao.getInstance();
			ProductVO pvo = pdao.getshortProduct(pseq);
		
			// 카테고리 별 타이틀을 배열에 저장 
			String kindList1[] = {"0", "스페셜&할인팩", "프리미엄", "와퍼", "주니어&버거", "올데이킹&치킨버거", "사이드", "음료&디저트", "독퍼"}; // 검색해온 상품에서 kind 값 추출 & 상품의 kind 값을 정수로 변환
			int index = Integer.parseInt(pvo.getKind1());
			String kindList3[] = {"0", "Single", "Set", "LargeSet", "Menu list"};
			int index2 = Integer.parseInt(pvo.getKind3());
			// 추출한 kind 번호로 배열에서 해당 타이틀 추출 & 리퀘스트에 저장 
			request.setAttribute("kind1", kindList1[index]);
			request.setAttribute("kind3", kindList3[index2]);
			request.setAttribute("productVO", pvo); 
		}
		request.getRequestDispatcher(url).forward(request,response);
	}
}
