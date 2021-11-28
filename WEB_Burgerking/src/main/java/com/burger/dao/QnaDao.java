package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.QnaVO;
import com.burger.util.DBman;

public class QnaDao {
	private QnaDao() { }
	private static QnaDao ist = new QnaDao();
	public static QnaDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<QnaVO> getQna(String id) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from qna where id = ?";
		
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setId(rs.getString("id"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				qvo.setReadcount(rs.getInt("readcount"));
				qvo.setPass(rs.getInt("pass"));
				list.add(qvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void deleteQna(String qseq) {
		String sql = "delete from qna where qseq = ?";
		
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qseq);	
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public void writeQna(QnaVO qvo) {
String sql = "insert into qna(qseq, subject, content, indate, id, readcount, pass)"
		+ " values(qseq.nextVal, ?, ?, sysdate, ?, 0, ?)";
		
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getSubject());
			pstmt.setString(2, qvo.getContent());
			pstmt.setString(3, qvo.getId());
			pstmt.setInt(4, qvo.getPass());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public QnaVO getQna2(int qseq) {
		String sql = "select * from qna where qseq = ?";
		QnaVO qvo = new QnaVO();	
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setId(rs.getString("id"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				qvo.setReadcount(rs.getInt("readcount"));
				qvo.setPass(rs.getInt("pass"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return qvo;
	}

}
