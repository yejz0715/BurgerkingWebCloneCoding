package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.subProductVO;
import com.burger.dto.subproductOrderVO;
import com.burger.util.DBman;

public class subproductOrderDao {
	private subproductOrderDao() { }
	private static subproductOrderDao ist = new subproductOrderDao();
	public static subproductOrderDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertSubProductOrder(int cseq, ArrayList<subProductVO> sublist, int mseq) {
		for(subProductVO spvo : sublist) {
			String sql = "insert into subproduct_order(sposeq, cseq, spseq, sname, addprice, mseq, oseq, odseq)"
					+ " values(sposeq.nextVal, ?, ?, ?, ?, ?, 0, 0)";
			con = DBman.getConnection();
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cseq);
				pstmt.setInt(2, spvo.getSpseq());
				pstmt.setString(3, spvo.getSname());
				pstmt.setInt(4, spvo.getAddprice());
				pstmt.setInt(5, mseq);
				pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBman.close(con, pstmt, rs);
			}
		}
	}

	public ArrayList<subproductOrderVO> selectSubProductOrder(int mseq) {
		ArrayList<subproductOrderVO> list = new ArrayList<subproductOrderVO>();
		String sql = "select * from subproduct_order where mseq = ? and oseq = ? order by cseq";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.setInt(2, 0);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				subproductOrderVO spovo = new subproductOrderVO();
				spovo.setSposeq(rs.getInt("sposeq"));
				spovo.setSpseq(rs.getInt("spseq"));
				spovo.setCseq(rs.getInt("cseq"));
				spovo.setMseq(rs.getInt("mseq"));
				spovo.setOdseq(rs.getInt("odseq"));
				spovo.setOseq(rs.getInt("oseq"));
				spovo.setSname(rs.getString("sname"));
				spovo.setAddprice(rs.getInt("addprice"));
				list.add(spovo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	public ArrayList<subproductOrderVO> select2SubProductOrder(int mseq) {
		ArrayList<subproductOrderVO> list = new ArrayList<subproductOrderVO>();
		String sql = "select * from subproduct_order where mseq = ? and oseq != ? order by cseq";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.setInt(2, 0);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				subproductOrderVO spovo = new subproductOrderVO();
				spovo.setSposeq(rs.getInt("sposeq"));
				spovo.setSpseq(rs.getInt("spseq"));
				spovo.setCseq(rs.getInt("cseq"));
				spovo.setMseq(rs.getInt("mseq"));
				spovo.setOdseq(rs.getInt("odseq"));
				spovo.setOseq(rs.getInt("oseq"));
				spovo.setSname(rs.getString("sname"));
				spovo.setAddprice(rs.getInt("addprice"));
				list.add(spovo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public ArrayList<subproductOrderVO> selectSPODistinct() {
		String sql = "select distinct cseq from subproduct_order order by cseq";
		con = DBman.getConnection();
		ArrayList<subproductOrderVO> list = new ArrayList<subproductOrderVO>(); 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				subproductOrderVO spovo = new subproductOrderVO();
				spovo.setCseq(rs.getInt("cseq"));
				list.add(spovo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

}