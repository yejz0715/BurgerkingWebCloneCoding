package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.CartVO;
import com.burger.util.DBman;

public class CartDao {
	private CartDao() { }
	private static CartDao ist = new CartDao();
	public static CartDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public void insertCart(CartVO cvo) {
		String sql = "insert into cart( cseq , id, pseq)"
				+ "values( cseq.nextVal, ? , ? )";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  cvo.getId() );
			pstmt.setInt(2,  cvo.getPseq());			
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs); }
		
	}
	public ArrayList<CartVO> selectCart(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		String sql = "select * from cart_view where id=? and result='1'";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				CartVO cvo = new CartVO();				
				cvo.setCseq(rs.getInt("cseq"));  		
				cvo.setId(rs.getString("id"));
				cvo.setMname(rs.getString("mname")); 
				cvo.setPseq(rs.getInt("pseq"));				
				cvo.setPname(rs.getString("pname"));
				cvo.setImage(rs.getString("image"));
				cvo.setKind1(rs.getString("kind1"));
				cvo.setKind3(rs.getString("kind3"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice1(rs.getInt("price1"));  
				cvo.setDate(rs.getTimestamp("indate"));
				list.add(cvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs); }
		return list;
	}
	public void deleteCart(String cseq) {
		String sql = "delete from cart_view where cseq=?";
		con = DBman.getConnection();
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, Integer.parseInt(cseq));
		      pstmt.executeUpdate();
		      
		      sql = "delete from subproduct_order where cseq = ?";
	          pstmt = con.prepareStatement(sql); 
	          pstmt.setInt(1, Integer.parseInt(cseq));
	          pstmt.executeUpdate();
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBman.close(con, pstmt, rs); }  
	}
	
	public CartVO minusQuantity(String cseq) {
		CartVO cvo = new CartVO();
		String sql = "update cart set quantity=quantity-1 where cseq = ?";
		con = DBman.getConnection();
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, Integer.parseInt(cseq));
		      rs = pstmt.executeQuery();
		      if(rs.next()) {
		    	cvo.setCseq(rs.getInt("cseq"));  		
				cvo.setId(rs.getString("id"));
				cvo.setMname(rs.getString("mname")); 
				cvo.setPseq(rs.getInt("pseq"));				
				cvo.setPname(rs.getString("pname"));
				cvo.setImage(rs.getString("image"));
				cvo.setKind1(rs.getString("kind1"));
				cvo.setKind3(rs.getString("kind3"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice1(rs.getInt("price1"));  
				cvo.setDate(rs.getTimestamp("indate"));
		      }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBman.close(con, pstmt, rs); }  
		return cvo;
	}
	public CartVO plusQuantity(String cseq) {
		CartVO cvo = new CartVO();
		String sql = "update cart set quantity=quantity+1 where cseq = ?";
		con = DBman.getConnection();
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, Integer.parseInt(cseq));
		      rs = pstmt.executeQuery();
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBman.close(con, pstmt, rs); }  
		return cvo;
	}
	public CartVO selectCartList(String cseq) {
		CartVO cvo = new CartVO();
		String sql = "select * from cart where cseq = ?";
		con = DBman.getConnection();
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, Integer.parseInt(cseq));
		      rs = pstmt.executeQuery();
		      if(rs.next()) {
				cvo.setQuantity(rs.getInt("quantity"));
		      }
		} catch (Exception e) { e.printStackTrace();
	    } finally { DBman.close(con, pstmt, rs); }  
		return cvo;
	}
	public void NoninsertCart(CartVO cvo) {
		String sql = "insert into cart( cseq , id, pseq)"
				+ "values( cart_seq.nextVal, ? , ? )";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  cvo.getId() );
			pstmt.setInt(2,  cvo.getPseq());			
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs); }
		
	}
	public ArrayList<CartVO> nonSelectCart(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		String sql = "select * from non_cart_view where id=? and result='1'";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				CartVO cvo = new CartVO();				
				cvo.setCseq(rs.getInt("cseq"));  		
				cvo.setId(rs.getString("id"));
				cvo.setNid(rs.getString("nid")); 
				cvo.setPseq(rs.getInt("pseq"));				
				cvo.setPname(rs.getString("pname"));
				cvo.setImage(rs.getString("image"));
				cvo.setKind1(rs.getString("kind1"));
				cvo.setKind3(rs.getString("kind3"));
				cvo.setQuantity(rs.getInt("quantity"));
				cvo.setPrice1(rs.getInt("price1"));  
				cvo.setDate(rs.getTimestamp("indate"));
				cvo.setResult(rs.getString("result"));
				list.add(cvo);
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs); }
		return list;
	}
	public CartVO getPseqCart(String pseq) {
      CartVO cvo = null;

      String sql = "select * from cart_view where pseq = ? order by indate desc";
      con = DBman.getConnection();
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, Integer.parseInt(pseq));
         rs = pstmt.executeQuery();
         if (rs.next()) {
            cvo = new CartVO();
            cvo.setCseq(rs.getInt("cseq"));
            cvo.setPseq(rs.getInt("pseq"));
            cvo.setQuantity(rs.getInt("quantity"));
            cvo.setId(rs.getString("id"));
            cvo.setDate(rs.getTimestamp("indate"));
            cvo.setPrice1(rs.getInt("price1"));
            cvo.setKind1(rs.getString("kind1"));
            cvo.setKind3(rs.getString("kind3"));
            cvo.setImage(rs.getString("image"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBman.close(con, pstmt, rs);
      }

      return cvo;
   }
}

