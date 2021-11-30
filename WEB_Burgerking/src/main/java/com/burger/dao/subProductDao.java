package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.ProductVO;
import com.burger.dto.shortProductVO;
import com.burger.util.DBman;

public class subProductDao {
	private subProductDao() {}
	private static subProductDao ist = new subProductDao();
	public static subProductDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public ArrayList<shortProductVO> getShortProduct(String kind1) {
		ArrayList<shortProductVO> list = new ArrayList<shortProductVO>();
		String sql = "select * from shortproduct where kind1 = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				shortProductVO spvo = new shortProductVO();
				spvo.setSpseq(rs.getInt("spseq"));
				spvo.setPname(rs.getString("pname"));
				spvo.setImage(rs.getString("image"));
				spvo.setKind1(rs.getString("kind1"));
				spvo.setKind2(rs.getString("kind2"));
				spvo.setUseyn(rs.getInt("useyn"));
				list.add(spvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}


	public shortProductVO getShortProductdetail(String spseq) {
		shortProductVO spvo = new shortProductVO();
		String sql = "select * from shortproduct where spseq=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, spseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				spvo.setSpseq(Integer.parseInt(spseq));
				spvo.setPname(rs.getString("pname"));
				spvo.setKind1(rs.getString("kind1"));
				spvo.setKind2(rs.getString("kind2"));
				spvo.setImage(rs.getString("image"));
				spvo.setUseyn(rs.getInt("useyn"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return spvo;
	}


	public shortProductVO getshortProduct(String pseq) {
		shortProductVO pvo = new shortProductVO();
		String sql = "select * from shortproduct where spseq = ?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pvo.setSpseq(Integer.parseInt(pseq));
				pvo.setPname(rs.getString("pname"));
				pvo.setKind1(rs.getString("kind1"));
				pvo.setKind2(rs.getString("kind2"));
				pvo.setUseyn(rs.getInt("useyn"));
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









