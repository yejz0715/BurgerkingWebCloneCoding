package com.burger.controller.admin.action;

import java.io.IOException;
import java.sql.Timestamp;

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
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductUpdateAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "burger.do?command=adminProductDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) url = "burger.do?command=admin"; 
		else { 
			ProductVO pvo = new ProductVO();
			ServletContext context = session.getServletContext(); 
			String path = context.getRealPath("image/menu");
			
			MultipartRequest multi = new MultipartRequest(request, path, 5*1024*1024,
					"UTF-8");
		 
			pvo.setPseq(Integer.parseInt(multi.getParameter("pseq")));
			pvo.setKind1(multi.getParameter("kind1"));
			pvo.setKind2(multi.getParameter("kind2"));
			pvo.setKind3(multi.getParameter("kind3"));
			pvo.setPname(multi.getParameter("pname"));
			pvo.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			pvo.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			pvo.setPrice3(Integer.parseInt(multi.getParameter("price3")));
			pvo.setContent(multi.getParameter("content"));
			pvo.setUseyn(multi.getParameter("useyn"));
			if(multi.getFilesystemName("image") == null)
				pvo.setImage(multi.getParameter("oldImage"));
			else
				pvo.setImage(multi.getFilesystemName("image"));
		
			AdminDao adao = AdminDao.getInstance(); 
			adao.updateProduct(pvo);
		
			url = url + "&pseq=" + pvo.getPseq(); 
		} 
		response.sendRedirect(url);
	}
}
