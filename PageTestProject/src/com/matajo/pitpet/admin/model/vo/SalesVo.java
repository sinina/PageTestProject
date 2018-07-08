package com.matajo.pitpet.admin.model.vo;

public class SalesVo {
	
	private int month;
	private int number;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public SalesVo(int month, int number) {
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
