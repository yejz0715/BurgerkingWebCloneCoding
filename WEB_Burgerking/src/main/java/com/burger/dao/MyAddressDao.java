package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.burger.dto.MemberVO;
import com.burger.dto.MyAddressVO;
import com.burger.util.DBman;



public class MyAddressDao {
	private MyAddressDao() { }
	private static MyAddressDao ist = new MyAddressDao();
	public static MyAddressDao getInstance() { 	return ist;	}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	

	public void insertMyAddress(int mseq, String address, String zip_num) {
		MyAddressVO mavo = null;
		String sql= " insert into Myaddress(mseq,address,zip_num) values(?,?,?) ";
		con = DBman.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.setString(2, address);
			pstmt.setString(3, zip_num);
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	
	}



	public void updateMyAddress(int mseq, String address, String zip_num) {
		MyAddressVO mavo = null;
		String sql= " update Myaddress set address=?, zip_num=? where mseq=? ";
		con = DBman.getConnection();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, zip_num);
			pstmt.setInt(3, mseq);
			
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}	
		
	}
	
	
}
