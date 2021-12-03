package com.burger.dto;

public class NonMemberVO {
	private String id;
	private String pwd;
	private String phone;
	private int memberkind;
	private int mseq;
	
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
	public int getMemberkind() {
		return memberkind;
	}
	public void setMemberkind(int memberkind) {
		this.memberkind = memberkind;
	}
}
