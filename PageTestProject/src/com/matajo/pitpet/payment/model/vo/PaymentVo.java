package com.matajo.pitpet.payment.model.vo;

import java.util.Date;

public class PaymentVo {
	
	private String payKind;
	private int petoNo;
	private int petsNo;
	private Date payDate;
	private char paySuccess;
	private int price;
	private int payNo;
	public String getPayKind() {
		return payKind;
	}
	public void setPayKind(String payKind) {
		this.payKind = payKind;
	}
	public int getPetoNo() {
		return petoNo;
	}
	public void setPetoNo(int petoNo) {
		this.petoNo = petoNo;
	}
	public int getPetsNo() {
		return petsNo;
	}
	public void setPetsNo(int petsNo) {
		this.petsNo = petsNo;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public char getPaySuccess() {
		return paySuccess;
	}
	public void setPaySuccess(char paySuccess) {
		this.paySuccess = paySuccess;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public PaymentVo(String payKind, int petoNo, int petsNo, Date payDate, char paySuccess, int price, int payNo) {
		super();
		this.payKind = payKind;
		this.petoNo = petoNo;
		this.petsNo = petsNo;
		this.payDate = payDate;
		this.paySuccess = paySuccess;
		this.price = price;
		this.payNo = payNo;
	}
	
	public PaymentVo(){}
	public PaymentVo(String payKind, int petoNo, int petsNo, int price) {
		super();
		this.payKind = payKind;
		this.petoNo = petoNo;
		this.petsNo = petsNo;
		this.price = price;
	}
	
	
	

}
