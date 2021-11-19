package com.burger.dto;

import java.sql.Timestamp;

public class MemberVO {
	private int mseq;
	private String id;
	private String pwd;
	private String phone;
	private Timestamp indate;
	private Timestamp lastdate;
	private String name;
	private int memberkind;
	
	public int getMseq() {
		return mseq;
	}
	public void setMseq(int mseq) {
		this.mseq = mseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public Timestamp getLastdate() {
		return lastdate;
	}
	public void setLastdate(Timestamp lastdate) {
		this.lastdate = lastdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemberkind() {
		return memberkind;
	}
	public void setMemberkind(int memberkind) {
		this.memberkind = memberkind;
	}
}
