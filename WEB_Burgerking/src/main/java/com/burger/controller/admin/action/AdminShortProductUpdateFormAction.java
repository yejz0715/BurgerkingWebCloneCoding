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

public class AdminShortProductUpdateFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String url = "admin/product/shortproductUpdate.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "burger.do?command=admin";
		}else {
			// 전달된 상품번호로 상품 상세 내역을 조회하고 리퀘스트에 저장합니다.
			String pseq = request.getParameter("pseq");
			ProductDao pdao = ProductDao.getInstance();
			ProductVO pvo = pdao.getProduct(pseq);
			request.setAttribute("productVO", pvo);
			
			// 현재 상품의 카테고리(kind)값을 상품 종류로 변환하여 리퀘스트에 저장합니다.
			String kindList1[] = {"스페셜&할인팩", "프리미엄", "와퍼", "주니어&버거", "올데이킹&치킨버거", "사이드", "음료&디저트", "독퍼"}; // 검색해온 상품에서 kind 값 추출 & 상품의 kind 값을 정수로 변환
			request.setAttribute("kindList1", kindList1);
			int index = Integer.parseInt(pvo.getKind1());
			request.setAttribute("kind", kindList1[index-1]);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
