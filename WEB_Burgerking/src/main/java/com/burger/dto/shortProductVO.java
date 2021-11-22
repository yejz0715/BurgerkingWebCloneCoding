package com.burger.dto;

public class shortProductVO {
	private int spseq;
	private String pname;
	private int kind1;
	private int kind2;
	private String image;
	
	public int getSpseq() {
		return spseq;
	}
	public void setSpseq(int spseq) {
		this.spseq = spseq;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getKind1() {
		return kind1;
	}
	public void setKind1(int kind1) {
		this.kind1 = kind1;
	}
	public int getKind2() {
		return kind2;
	}
	public void setKind2(int kind2) {
		this.kind2 = kind2;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getUseyn() {
		return useyn;
	}
	public void setUseyn(int useyn) {
		this.useyn = useyn;
	}
	private int useyn;
}
