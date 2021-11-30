package com.burger.controller.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.burger.controller.action.Action;
import com.burger.dao.AdminDao;
import com.burger.dto.AdminVO;
import com.burger.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;


public class AdminProductWriteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=adminProductList";
		
		HttpSession session = request.getSession(); 
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo == null) { 
			url = "burger.do?command=admin"; }
		else {
			// 현재 프로젝트의 세션을 통해 적용할 저장경로 얻음
			ServletContext context = session.getServletContext(); String uploadFilePath =
			context.getRealPath("image/menu");
			
			// MultipartRequest 객체 생성 - 파일 업로드 
			MultipartRequest multi = new MultipartRequest( request, uploadFilePath, 5*1024*1024, "UTF-8");
			
			String k1 = multi.getParameter("kind1");
			String k2 = multi.getParameter("kind2");
			String k3 = multi.getParameter("kind3");
			
			AdminDao adao = AdminDao.getInstance();
			int result = adao.checkShortProductYN(k1, k2, k3);
			
			if(result == 2) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('해당하는 종류분류 값이 없습니다.'); location.href='burger.do?command=adminProductWriteForm';</script>");
				writer.close();
			}else if(result == 3) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('해당하는 분류번호 값이 이미 있습니다.'); location.href='burger.do?command=adminProductWriteForm';</script>");
				writer.close();
			}else if(result == 4) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('입력할 수 없는 세부 값입니다.'); location.href='burger.do?command=adminProductWriteForm';</script>");
				writer.close();
			}
			
			// 나머지 파라미터들을 dto에 저장
			ProductVO pvo = new ProductVO();
			pvo.setKind1(multi.getParameter("kind1"));
			pvo.setKind2(multi.getParameter("kind2"));
			pvo.setKind3(multi.getParameter("kind3"));
			pvo.setPname(multi.getParameter("pname"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt("0"));
			pvo.setPrice3(Integer.parseInt("0"));
			pvo.setContent(multi.getParameter("content"));
			pvo.setImage(multi.getFilesystemName("image"));
			pvo.setUseyn(multi.getParameter("useyn"));
			 
			adao.insertProduct(pvo); 
		}
		response.sendRedirect(url);
	}
}
