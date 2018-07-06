package com.matajo.pitpet.admin.model.vo;

public class MatchingVo {
	private int res;
	private int resC;
	private int pay;
	private int resR;
	
	private String date1;
	
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public int getResC() {
		return resC;
	}
	public void setResC(int resC) {
		this.resC = resC;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getResR() {
		return resR;
	}
	public void setResR(int resR) {
		this.resR = resR;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public MatchingVo(){}
	public MatchingVo(int res, int resC, int pay, int resR, String date1) {
		super();
		this.res = res;
		this.resC = resC;
		this.pay = pay;
		this.resR = resR;
		this.date1 = date1;
	}
	
	
}
