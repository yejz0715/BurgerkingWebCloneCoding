package com.burger.dto;

import java.sql.Timestamp;

public class CartVO {
	private int cseq;
	private String id;
	private int pseq;
	private int quantity;
	private String result;
	private Timestamp date;
	private String pname;
	private String mname;
	private String image;
	private int price1;
	private String kind1;
	private String kind3;
	private String nid;
	private String phone;
	private String memberkind;
	
	public String getMemberkind() {
		return memberkind;
	}
	public void setMemberkind(String memberkind) {
		this.memberkind = memberkind;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public String getKind3() {
		return kind3;
	}
	public void setKind3(String kind3) {
		this.kind3 = kind3;
	}
	public String getKind1() {
		return kind1;
	}
	public void setKind1(String kind1) {
		this.kind1 = kind1;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice1() {
		return price1;
	}
	public void setPrice1(int price1) {
		this.price1 = price1;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
