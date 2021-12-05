package com.burger.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.dao.CartDao;
import com.burger.dao.subProductDao;
import com.burger.dao.subproductOrderDao;
import com.burger.dto.CartVO;
import com.burger.dto.MemberVO;
import com.burger.dto.subProductVO;

public class InsertAddMeterialAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=deliveryCartForm&addM="+request.getParameter("addM");
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if (mvo == null) {
		    url = "burger.do?command=loginForm&non=1";
		}else{
			ArrayList<subProductVO> sublist = null;
			if(request.getParameter("addM") != null) { // meterial값이 있다면
				String addMeterial = request.getParameter("addM"); // 값을 받아와서
				System.out.println(addMeterial);
				String[] am = addMeterial.split(","); // 분할 저장([0] : pseq, [1]~ : spseq)
				if(am.length == 1) { // am 배열의 길이가 1이라면 pseq값만 온 것이므로 선택한 메뉴가 없다. 즉 그냥 pass
					request.setAttribute("spseqAm", null);
				}else {
					// 넘어온 spseq 값이 있다면 해당 sub_productVO 정보를 list로 저장한다.
					CartDao cdao = CartDao.getInstance();
					sublist = new ArrayList<subProductVO>();
					subProductDao spdao = subProductDao.getInstance();
					for(int i = 1; i < am.length; i++)
					{
						sublist.add(spdao.getSubProduct(am[i]));
					}
					
					CartVO Am_cvo = cdao.getPseqCart(am[0]);
					System.out.println(Am_cvo);
					subproductOrderDao spodao = subproductOrderDao.getInstance();
					spodao.insertSubProductOrder(Am_cvo.getCseq(), sublist, mvo.getMseq());
				}
			}
			response.sendRedirect(url);
		}
	}
}
