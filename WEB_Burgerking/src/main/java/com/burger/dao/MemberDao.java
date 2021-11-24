package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.burger.dto.MemberVO;
import com.burger.util.DBman;

public class MemberDao {
	private MemberDao() { }
	private static MemberDao ist = new MemberDao();
	public static MemberDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberVO getMember(String id) {
		MemberVO mvo = null;
		String sql = "select * from member where id = ?";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setMseq(rs.getInt("mseq"));
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setLastdate(rs.getTimestamp("lastdate"));
				mvo.setMemberkind(rs.getInt("memberkind"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return mvo;
	}

	public MemberVO findMember(String name, String phone) {
		MemberVO mvo = null;
		String sql = "select * from member where name=? and phone=?";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setMseq(rs.getInt("mseq"));
				mvo.setId(rs.getString("id"));
				mvo.setPwd(rs.getString("pwd"));
				mvo.setName(rs.getString("name"));
				mvo.setPhone(rs.getString("phone"));
				mvo.setIndate(rs.getTimestamp("indate"));
				mvo.setLastdate(rs.getTimestamp("lastdate"));
				mvo.setMemberkind(rs.getInt("memberkind"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return mvo;
	}

	public void setLastDate(MemberVO mvo) {
		String sql = "update member set lastdate=sysdate where mseq = ?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mvo.getMseq());
			pstmt.executeUpdate();
			
			sql = "select lastdate from member where mseq=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mvo.getMseq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.setLastdate(rs.getTimestamp("lastdate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}
}
