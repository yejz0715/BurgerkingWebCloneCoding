package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.AdminVO;
import com.burger.dto.ProductVO;
import com.burger.dto.shortProductVO;
import com.burger.util.DBman;
import com.burger.util.Paging;

public class AdminDao {
	private AdminDao() { }
	private static AdminDao ist = new AdminDao();
	public static AdminDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO adminCheck(String adminId) {
		AdminVO avo = null;
		String sql = "select * from admin where id=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avo = new AdminVO();
				avo.setId(rs.getString("id"));
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return avo;
	}

	public int getAllCount(String tableName, String fieldName, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tableName + " where "
				+ fieldName + " like '%'||?||'%'";
		// 필드명 like '%?%'에서 ?가 빈칸이거나 널이면, 해당 필드의 조건은 검색하지 않은 것과 같아집니다.
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return count;
	}

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		//String sql ="select * from product order by pseq desc";
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from product where pname like '%'||?||'%' order by pseq desc) p)"
				+ ") where rn >=?"
				+ ") where rn <=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setPname(rs.getString("pname"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setKind3(rs.getString("kind3"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				list.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public ArrayList<shortProductVO> listShortProduct(Paging paging, String key) {
		ArrayList<shortProductVO> list = new ArrayList<shortProductVO>();
		//String sql ="select * from product order by pseq desc";
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from shortproduct where pname like '%'||?||'%' order by spseq desc) p)"
				+ ") where rn >=?"
				+ ") where rn <=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shortProductVO pvo = new shortProductVO();
				pvo.setSpseq(rs.getInt("spseq"));
				pvo.setPname(rs.getString("pname"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getInt("useyn"));
				list.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}
}
