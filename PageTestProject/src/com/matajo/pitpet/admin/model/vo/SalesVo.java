package com.matajo.pitpet.admin.model.vo;

public class SalesVo {
	
	private String month;
	private int number;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public SalesVo(String month, int number) {
		super();
		this.month = month;
		this.number = number;
	}
	
	public SalesVo(){}

	@Override
	public String toString() {
		return "SalesVo [month=" + month + ", number=" + number + "]";
	}
	
	

}
