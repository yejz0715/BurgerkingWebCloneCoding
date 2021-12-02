package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String sql = "insert into non_member(id, password, phone) values(?, ?, ?)";
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
		NonMemberVO nmvo = new NonMemberVO();
		String sql = "select * from non_member where id=?";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nmvo.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				nmvo.setId(rs.getString(id));
				nmvo.setPhone(rs.getString("phone"));
				nmvo.setPwd(rs.getString("pwd"));
				nmvo.setMemberkind(rs.getInt("memberkind"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return nmvo;
	}
}
