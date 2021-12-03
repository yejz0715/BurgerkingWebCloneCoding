package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.burger.dto.MyAddressVO;
import com.burger.dto.NonMemberVO;
import com.burger.util.DBman;

public class NonMemberDao {
	private NonMemberDao() { }
	private static NonMemberDao ist = new NonMemberDao();
	public static NonMemberDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public void insertNonMember(NonMemberVO nmvo) {
		String sql = "insert into non_member(mseq, id, password, phone) values(mseq.nextVal, ?, ?, ?)";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nmvo.getId());
			pstmt.setString(2, nmvo.getPwd());
			pstmt.setString(3, nmvo.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		
	}
	public NonMemberVO getNonMember(String id) {
		NonMemberVO nmvo = null;
		String sql = "select * from non_member where id=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nmvo = new NonMemberVO();
				nmvo.setMseq(rs.getInt("mseq"));
				nmvo.setId(rs.getString("id"));
				nmvo.setPhone(rs.getString("phone"));
				nmvo.setPwd(rs.getString("password"));
				nmvo.setMemberkind(rs.getInt("memberkind"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return nmvo;
	}
	public int checkNonMyAddress(int mseq) {
		int result = 0;
		String sql = " select * from myaddress where mseq=? ";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}

		return result;
	}
	public MyAddressVO getNonMyAddress(int mseq) {
		MyAddressVO mavo = null;
		String sql = " select * from myaddress where mseq=? ";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mavo = new MyAddressVO();
				mavo.setAddress(rs.getString("address"));
				mavo.setMseq(rs.getInt("mseq"));
				mavo.setZip_num(rs.getString("zip_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return mavo;
	}
}
