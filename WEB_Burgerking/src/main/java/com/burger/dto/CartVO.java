package com.burger.dto;

import java.sql.Timestamp;

public class CartVO {
	private int cseq;
	private String id;
	private int pseq;
	private int quantity;
	private String result;
	private Timestamp date;
	
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
