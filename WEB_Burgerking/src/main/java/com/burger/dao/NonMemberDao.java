package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NonMemberDao {
	private NonMemberDao() { }
	private static NonMemberDao ist = new NonMemberDao();
	public static NonMemberDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
