package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.EventVO;
import com.burger.util.DBman;

public class EventDao {
	private EventDao() {
	}

	private static EventDao ist = new EventDao();

	public static EventDao getInstance() {
		return ist;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<EventVO> getAllEvents() {
		ArrayList<EventVO> list = new ArrayList<EventVO>();
		String sql = " select * from event order by eseq asc";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO evo = new EventVO();
				evo.setEseq(rs.getInt("eseq"));
				evo.setSubject(rs.getString("subject"));
				evo.setContent(rs.getString("content"));
				evo.setImage(rs.getString("image"));
				evo.setStartdate(rs.getTimestamp("startdate"));
				evo.setEnddate(rs.getTimestamp("enddate"));
				evo.setState(rs.getInt("state"));
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<EventVO> getOngoingEvents() {
		ArrayList<EventVO> list = new ArrayList<EventVO>();
		String sql= " select * from event where state = 1 order by eseq asc ";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO evo = new EventVO();
				evo.setEseq(rs.getInt("eseq"));
				evo.setSubject(rs.getString("subject"));
				evo.setContent(rs.getString("content"));
				evo.setImage(rs.getString("image"));
				evo.setStartdate(rs.getTimestamp("startdate"));
				evo.setEnddate(rs.getTimestamp("enddate"));
				evo.setState(rs.getInt("state"));
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<EventVO> getPastEvents() {
		ArrayList<EventVO> list = new ArrayList<EventVO>();
		String sql= " select * from event where state =0 order by eseq asc";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO evo = new EventVO();
				evo.setEseq(rs.getInt("eseq"));
				evo.setSubject(rs.getString("subject"));
				evo.setContent(rs.getString("content"));
				evo.setImage(rs.getString("image"));
				evo.setStartdate(rs.getTimestamp("startdate"));
				evo.setEnddate(rs.getTimestamp("enddate"));
				evo.setState(rs.getInt("state"));
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public EventVO getDetailEvent(String eseq) {
		EventVO evo=new EventVO();
		String sql= " select * from event where eseq = ?";
		
		con=DBman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(eseq));
			rs = pstmt.executeQuery();
			if(rs.next()) {
			evo.setEseq(Integer.parseInt(eseq));	
			evo.setSubject(rs.getString("subject"));
			evo.setContent(rs.getString("content"));
			evo.setImage(rs.getString("image"));
			evo.setStartdate(rs.getTimestamp("startdate"));
			evo.setEnddate(rs.getTimestamp("enddate"));
			evo.setState(rs.getInt("state"));	
			} 
	    } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return evo;
	}
	
}
