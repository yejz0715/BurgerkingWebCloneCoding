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
		String sql = " select * from event";
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
				evo.setStartdate(rs.getString("startdate").substring(0, 10));
				evo.setEnddate(rs.getString("enddate").substring(0, 10));
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

}
