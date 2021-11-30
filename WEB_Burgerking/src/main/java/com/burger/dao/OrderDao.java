package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.CartVO;
import com.burger.dto.orderVO;
import com.burger.util.DBman;


public class OrderDao {
	private OrderDao() { }
	private static OrderDao ist = new OrderDao();
	public static OrderDao getInstance() { 	return ist; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int insertOrder(ArrayList<CartVO> list, String id) {
		int oseq = 0; // orders 테이블에 추가된 주문번호를 리턴할 에정입니다
		con = DBman.getConnection();
		
		// 1. 주문 번호(시퀀스 자동입력)와 구매자 아이디로 orders 테이블에 레코드 추가
		String sql = "insert into orders(oseq, id, memberkind) values( orders_seq.nextVal , ?, 1)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			// 2. Orders 테이블에 시퀀스로 입력된 가장 마지막(방금추가한) 주문 번호 조회
			pstmt.close();
			sql = "select max(oseq) as max_oseq from orders";
			pstmt = con.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			if(rs.next()) oseq = rs.getInt("max_oseq");
			
			// 3. list 의 카트목록들을 Orders 에서 얻은 max_oseq 와 함꼐 order_detail 에 추가
			pstmt.close();
			
			// 반복실행문을 이용 list 의 갯수만큼 반복
			for(CartVO cvo : list) {
				sql = "insert into order_detail(odseq, oseq, pseq, quantity) "
				  		+ "values(order_detail_seq.nextval , ? , ? , ? )";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				pstmt.setInt(2, cvo.getPseq() );
				pstmt.setInt(3, cvo.getQuantity() );
				pstmt.executeUpdate();
				
				// 4. order_detail 에 추가된 카트 내용은  cart 테이블에서 처리되었으므로 삭제 또는 result  를 2로 변경
				pstmt.close();
				sql = "delete from cart where cseq = ?"; 
				//sql = "Update cart set result='2' where cseq=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cvo.getCseq());
				pstmt.executeUpdate();
			}			
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs);  }
		return oseq;
	}
	public ArrayList<orderVO> listOrderById(String id, int oseq) {
		ArrayList<orderVO> list = new ArrayList<orderVO>();
		String sql = "select * from order_view  where id=? and result ='1' and oseq=?";
		con = DBman.getConnection();
		try {
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setString(1, id);
			  pstmt.setInt(2, oseq);
			  rs = pstmt.executeQuery();
			  while(rs.next()) {
				    orderVO ovo = new orderVO();
					ovo.setOdseq(rs.getInt("odseq"));
					ovo.setOseq(rs.getInt("oseq"));
					ovo.setId(rs.getString("id"));
					ovo.setIndate(rs.getTimestamp("indate"));
					ovo.setMname(rs.getString("mname"));
					ovo.setZip_num(rs.getString("zip_num"));
					ovo.setAddress(rs.getString("address"));
					ovo.setPhone(rs.getString("phone"));
					ovo.setPname(rs.getString("pname"));
					ovo.setPrice1(rs.getInt("price1"));
					ovo.setPseq(rs.getInt("pseq"));
					ovo.setQuantity(rs.getInt("quantity"));
					ovo.setResult(rs.getString("result"));
					list.add(ovo);
			  }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBman.close(con, pstmt, rs); } 
		return list;
	}
}







