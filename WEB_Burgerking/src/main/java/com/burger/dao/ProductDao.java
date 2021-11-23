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
	
	public ProductVO getProduct(String pseq) {
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
				pvo.setKind2(rs.getString("kind3"));
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

	public ProductVO getProductdetail(int kind1, int kind2) {
		ProductVO pvo = new ProductVO();
		String sql = "select * from product where kind1=?, kind2=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kind1);
			pstmt.setInt(2, kind2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setPname(rs.getString("pname"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind2(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return pvo;
	}
	
}









