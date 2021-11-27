package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.AdminVO;
import com.burger.dto.MemberVO;
import com.burger.dto.ProductVO;
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
				+ "((select * from product where pname like '%'||?||'%' and kind3 between 1 and 3 order by pseq desc) p)"
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

	public ArrayList<ProductVO> listShortProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		//String sql ="select * from product order by pseq desc";
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from product where pname like '%'||?||'%' and kind3='4' order by pseq desc) p)"
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

	public int getshortPCount(String tableName, String fieldName, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tableName + " where "
				+ fieldName + " like '%'||?||'%' and kind3 = '4'";
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

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set kind1=?, useyn=?, pname=?, price1=?, "
				+ " content=?, image=?, kind2=?, kind3=? where pseq=?";
		
		con = DBman.getConnection();
		try {			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind1());
		    pstmt.setString(2, pvo.getUseyn());
		    pstmt.setString(3, pvo.getPname());
		    pstmt.setInt(4, pvo.getPrice1());
		    pstmt.setString(5, pvo.getContent());
		    pstmt.setString(6, pvo.getImage());
		    pstmt.setString(7, pvo.getKind2());
		    pstmt.setString(8, pvo.getKind3());
		    pstmt.setInt(9, pvo.getPseq());
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs);  }	
		
	}

	public void insertProduct(ProductVO pvo) {
		String sql = "insert into product(pseq, kind1, kind2, kind3, pname, price1, price2, price3,"
				+ " content, image, useyn) values(pseq.nextVal, ?,?,?,?,?,?,?,?,?,?)";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind1());      
			pstmt.setString(2, pvo.getKind2());
			pstmt.setString(3, pvo.getKind3());
		    pstmt.setString(4, pvo.getPname());
		    pstmt.setInt(5, pvo.getPrice1());
		    pstmt.setInt(6, pvo.getPrice2());
		    pstmt.setInt(7, pvo.getPrice3());
		    pstmt.setString(8, pvo.getContent());
		    pstmt.setString(9, pvo.getImage());  
		    pstmt.setString(10, pvo.getUseyn());
		    pstmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
		} finally { DBman.close(con, pstmt, rs); 	}
		
	}

	public int checkShortProductYN(String k1, String k2, String k3) {
		int result=1;
		String sql = "select * from product where kind1 = ?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, k1);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				result = 2;
				return result;
			}
			
			sql = "select * from product where kind1=? and kind2 = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, k1);
			pstmt.setString(2, k2);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 3;
				return result;
			}
			
			if(k3.equals("4")) {
				result = 4;
				return result;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return result;
	}

	public int checkShortProductYN2(String k1, String k2) {
		int result=1;
		String sql = "select * from product where kind1=? and kind2 = ?";
		
		try {
			con = DBman.getConnection();			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, k1);
			pstmt.setString(2, k2);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 2;
				return result;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return result;
	}

	public ArrayList<MemberVO> listMember(Paging paging, String key) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		//String sql ="select * from product order by pseq desc";
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, m.* from "
				+ "((select * from member where name like '%'||?||'%' order by mseq desc) m)"
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
				MemberVO mvo = new MemberVO();
				mvo.setId(rs.getString("id"));
				mvo.setName(rs.getString("name"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setMseq(rs.getInt("mseq"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setLastdate(rs.getTimestamp("lastdate"));
				mvo.setMemberkind(rs.getInt("memberkind"));
				list.add(mvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}
}
