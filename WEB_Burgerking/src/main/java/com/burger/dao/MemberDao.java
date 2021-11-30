package com.burger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.burger.dto.AddressVO;
import com.burger.dto.MemberVO;
import com.burger.dto.MyAddressVO;
import com.burger.util.DBman;

public class MemberDao {
	private MemberDao() {
	}

	private static MemberDao ist = new MemberDao();

	public static MemberDao getInstance() {
		return ist;
	}

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

			if (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

			if (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

			if (rs.next()) {
				mvo.setLastdate(rs.getTimestamp("lastdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public MemberVO findPwd(String name, String id) {
		MemberVO mvo = null;
		String sql = "select * from member where name=? and id=?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}

		return mvo;
	}

	public void updatePwd(String mseq, String pwd) {
		String sql = "update member set pwd=? where mseq=?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, mseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public void deleteMember(String mseq) {
		String sql = "delete from member where mseq=?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(mseq));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public MemberVO getMember_mseq(String mseq) {
		MemberVO mvo = null;
		String sql = "select * from member where mseq = ?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mseq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}

		return mvo;
	}

	public int confirmID(String id) {
		int result = -1;
		String sql = "select * from member where id=?";
		con = DBman.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return result;
	}

	public void insertMember(MemberVO mvo) {
		String sql = "insert into member(mseq, id, pwd, phone, name) " + "values(mseq.nextVal, ?, ?, ?, ?)";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}

	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) {
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		String sql = "select * from address where dong like '%'||?||'%'";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AddressVO avo = new AddressVO();
				avo.setZip_num(rs.getString("zip_num"));
				avo.setSido(rs.getString("sido"));
				avo.setGugun(rs.getString("gugun"));
				avo.setDong(rs.getString("dong"));
				avo.setZip_code(rs.getString("zip_code"));
				avo.setBunji(rs.getString("bunji"));
				list.add(avo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
		return list;
	}

	public int checkMyAddress(int mseq) {
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

	public MyAddressVO getMyAddress(int mseq) {
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

	public void updateMember(MemberVO mvo) {
		String sql = " update member set pwd=?, name=?, phone=? where id=? ";
		con = DBman.getConnection();
		try {
			System.out.println("updateMember()...");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mvo.getPwd());
			pstmt.setString(2, mvo.getName());
			pstmt.setString(3, mvo.getPhone());
			pstmt.setString(4, mvo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public void deleteMember(int mseq) {
		String sql = " delete from member where mseq=? ";
		con = DBman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mseq);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBman.close(con, pstmt, rs);
		}
	}
}
