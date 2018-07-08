package com.matajo.pitpet.reservation.model.vo;

import java.util.Date;

public class ReservationVo {
	private Date startTime;
	private Date endTime;
	private int petoNo;
	private String animalKind;
	private int petsNo;
	private int price;
	private int animalNo;
	private char accDny;
	private int resNo;
	
	private String start;
	private String end;
	private String title;
	private String petoName;
	private String petsName;
	private String request;
	
	
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getPetoNo() {
		return petoNo;
	}
	public void setPetoNo(int petoNo) {
		this.petoNo = petoNo;
	}
	public String getAnimalKind() {
		return animalKind;
	}
	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}
	public int getPetsNo() {
		return petsNo;
	}
	public void setPetsNo(int petsNo) {
		this.petsNo = petsNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAnimalNo() {
		return animalNo;
	}
	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}
	public char getAccDny() {
		return accDny;
	}
	public void setAccDny(char accDny) {
		this.accDny = accDny;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	public String getPetoName() {
		return petoName;
	}
	public void setPetoName(String petoName) {
		this.petoName = petoName;
	}
	
	
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPetsName() {
		return petsName;
	}
	public void setPetsName(String petsName) {
		this.petsName = petsName;
	}
	@Override
	public String toString() {
		return "ReservationVo [start=" + start + ", end=" + end + ", title=" + title + "]";
	}
	public ReservationVo(Date startTime, Date endTime, int petoNo, String animalKind, int petsNo, int price,
			int animalNo, char accDny, int resNo) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.petoNo = petoNo;
		this.animalKind = animalKind;
		this.petsNo = petsNo;
		this.price = price;
		this.animalNo = animalNo;
		this.accDny = accDny;
		this.resNo = resNo;
	}
	
	
	
	public ReservationVo(int petoNo, String animalKind, int petsNo, int price, int animalNo, String start, String end,
			String request) {
		super();
		this.petoNo = petoNo;
		this.animalKind = animalKind;
		this.petsNo = petsNo;
		this.price = price;
		this.animalNo = animalNo;
		this.start = start;
		this.end = end;
		this.request = request;
	}
	public ReservationVo(int petoNo, int petsNo, String start, String end) {
		super();
		this.petoNo = petoNo;
		this.petsNo = petsNo;
		this.start = start;
		this.end = end;
	}
	public ReservationVo(){}
}
