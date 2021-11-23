package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.ProductVO;
import com.burger.dto.shortProductVO;
import com.burger.util.DBman;

public class ShortProductDao {
	private ShortProductDao() {}
	private static ShortProductDao ist = new ShortProductDao();
	public static ShortProductDao getInstance() {return ist;}
	
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
				spvo.setKind1(rs.getInt("kind1"));
				spvo.setKind2(rs.getInt("kind2"));
				spvo.setUseyn(rs.getInt("useyn"));
				list.add(spvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}
}









