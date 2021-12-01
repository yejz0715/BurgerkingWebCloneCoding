package com.burger.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.burger.controller.action.Action;
import com.burger.dao.OrderDao;

public class AdminOrderDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] oseqArr = request.getParameterValues("delete");
		
		OrderDao odao = OrderDao.getInstance();
		for(String odseq : oseqArr) { 
			// odseq 값으로 해당 번호 값을 가진 주문의 oseq 값 추출
			int oseq = odao.getOseq(odseq);
			
			// 제거하려했던 odseq 값과 추출한 oseq 값을 이용해 orders와 order_detail에서 데이터 제거
			// 자세한 설명은 해당 메소드 참조.
			odao.deleteOrder(odseq, oseq);
		}
		response.sendRedirect("burger.do?command=adminOrderList");
	}
}
