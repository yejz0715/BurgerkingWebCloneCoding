package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.ProductVO;
import com.burger.dto.shortProductVO;
import com.burger.util.DBman;

public class ProductDao {
	private ProductDao() {}
	private static ProductDao ist = new ProductDao();
	public static ProductDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ProductVO getProduct(String kind1) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where kind1 = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setKind1(kind1);
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}

	public ArrayList<ProductVO> getProductdetail(String pseq) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from product where pseq = ? and kind3=4";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(Integer.parseInt(pseq));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		}catch(SQLException e) {e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<ProductVO> getProductkind(String kind2, String kind1) {
		ArrayList<ProductVO> list2 = new ArrayList<ProductVO>();
		String sql = "select * from product where kind1 = ? and kind2 = ? and kind3<4";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, kind1);
			pstmt.setString(1, kind2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setKind1(kind1);
				pvo.setKind2(kind2);
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
				list2.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list2;
	}

	public ProductVO getDeliverydetail(String pseq) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where pseq = ? and kind3=4";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setPseq(Integer.parseInt(pseq));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}
	
	public ArrayList<ProductVO> getShortProduct(String kind1) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from product where kind1 = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}


	public ProductVO getShortProductdetail(String spseq) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where pseq=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, spseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}


	public ProductVO getshortProduct(String pseq) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where pseq = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}

	public ArrayList<ProductVO> getProductList(String kind1) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from product where kind1 = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setKind1(kind1);
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
				list.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public ProductVO getProducts(String pseq) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where pseq = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setPseq(Integer.parseInt(pseq));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}
	public void deleteProduct(String pseq) {
		String sql = "delete from product where pseq=?";
		con = DBman.getConnection();
		
		try {
		      pstmt = con.prepareStatement(sql); 
		      pstmt.setInt(1, Integer.parseInt(pseq));
		      pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
	    } finally { 
	    	DBman.close(con, pstmt, rs);
	    }   		
	}
}









