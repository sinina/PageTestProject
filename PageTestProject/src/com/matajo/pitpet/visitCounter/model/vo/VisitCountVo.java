package com.matajo.pitpet.visitCounter.model.vo;

import java.util.Date;

public class VisitCountVo {
	//방문자 테이블에 방문날짜 컬럼 있음
	private Date visitDate;
	private int jan;
	private int feb;
	private int mar;
	private int apr;
	private int may;
	private int jun;
	private int jul;
	private int aug;
	private int sep;
	private int out;
	private int nov;
	private int dec;
	
	
	public int getJan() {
		return jan;
	}

	public void setJan(int jan) {
		this.jan = jan;
	}

	public int getFeb() {
		return feb;
	}

	public void setFeb(int feb) {
		this.feb = feb;
	}

	public int getMar() {
		return mar;
	}

	public void setMar(int mar) {
		this.mar = mar;
	}

	public int getApr() {
		return apr;
	}

	public void setApr(int apr) {
		this.apr = apr;
	}

	public int getMay() {
		return may;
	}

	public void setMay(int may) {
		this.may = may;
	}

	public int getJun() {
		return jun;
	}

	public void setJun(int jun) {
		this.jun = jun;
	}

	public int getJul() {
		return jul;
	}

	public void setJul(int jul) {
		this.jul = jul;
	}

	public int getAug() {
		return aug;
	}

	public void setAug(int aug) {
		this.aug = aug;
	}

	public int getSep() {
		return sep;
	}

	public void setSep(int sep) {
		this.sep = sep;
	}

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

	public int getNov() {
		return nov;
	}

	public void setNov(int nov) {
		this.nov = nov;
	}

	public int getDec() {
		return dec;
	}

	public void setDec(int dec) {
		this.dec = dec;
	}

	public VisitCountVo(){}

	public VisitCountVo(Date visitDate) {
		super();
		this.visitDate = visitDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public VisitCountVo(Date visitDate, int jan, int feb, int mar, int apr, int may, int jun, int jul, int aug, int sep,
			int out, int nov, int dec) {
		super();
		this.visitDate = visitDate;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		this.apr = apr;
		this.may = may;
		this.jun = jun;
		this.jul = jul;
		this.aug = aug;
		this.sep = sep;
		this.out = out;
		this.nov = nov;
		this.dec = dec;
	}

	@Override
	public String toString() {
		return "VisitCountVo [visitDate=" + visitDate + ", jan=" + jan + ", feb=" + feb + ", mar=" + mar + ", apr="
				+ apr + ", may=" + may + ", jun=" + jun + ", jul=" + jul + ", aug=" + aug + ", sep=" + sep + ", out="
				+ out + ", nov=" + nov + ", dec=" + dec + "]";
	}
	
	
	
}
