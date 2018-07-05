package com.matajo.pitpet.patjoin.model.vo;

public class PatVo {
	private String patName;
	private String patkg;
	private String patImage;
	private String kinds;
	private String kinds_of;
	private int patage;
	private String patInfo;
	private int owner_no;
	private char patgender;
	private char operation;//중성화수술여부
	private String uniquness;//특이사항
	private String hospital;//병원
	private int no;
	
	public PatVo(){
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatkg() {
		return patkg;
	}

	public void setPatkg(String patkg) {
		this.patkg = patkg;
	}

	public String getPatImage() {
		return patImage;
	}

	public void setPatImage(String patImage) {
		this.patImage = patImage;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getKinds_of() {
		return kinds_of;
	}

	public void setKinds_of(String kinds_of) {
		this.kinds_of = kinds_of;
	}

	public int getPatage() {
		return patage;
	}

	public void setPatage(int patage) {
		this.patage = patage;
	}

	public String getPatInfo() {
		return patInfo;
	}

	public void setPatInfo(String patInfo) {
		this.patInfo = patInfo;
	}

	public int getOwner_no() {
		return owner_no;
	}

	public void setOwner_no(int owner_no) {
		this.owner_no = owner_no;
	}

	public char getPatgender() {
		return patgender;
	}

	public void setPatgender(char patgender) {
		this.patgender = patgender;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public String getUniquness() {
		return uniquness;
	}

	public void setUniquness(String uniquness) {
		this.uniquness = uniquness;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public PatVo(String patName, String patkg, String patImage, String kinds, String kinds_of, int patage,
			String patInfo, int owner_no, char patgender, char operation, String uniquness, String hospital, int no) {
		this.patName = patName;
		this.patkg = patkg;
		this.patImage = patImage;
		this.kinds = kinds;
		this.kinds_of = kinds_of;
		this.patage = patage;
		this.patInfo = patInfo;
		this.owner_no = owner_no;
		this.patgender = patgender;
		this.operation = operation;
		this.uniquness = uniquness;
		this.hospital = hospital;
		this.no = no;
	}

	@Override
	public String toString() {
		return "PatVo [patName=" + patName + ", patkg=" + patkg + ", patImage=" + patImage + ", kinds=" + kinds
				+ ", kinds_of=" + kinds_of + ", patage=" + patage + ", patInfo=" + patInfo + ", owner_no=" + owner_no
				+ ", patgender=" + patgender + ", operation=" + operation + ", uniquness=" + uniquness + ", hospital="
				+ hospital + ", no=" + no + "]";
	}
	
}
