package com.matajo.pitpet.member.model.vo;

import java.util.Date;

public class MemberVo {
	private String id;
	private String pwd;
	private String name;
	private char gender;
	private int age;
	private String phone;
	private String address;
	private Date enrollDate;
	private char code;
	private int no;
	
	 public MemberVo() {
	
	}

	 
	public MemberVo(String id, String pwd, String name, char gender, int age, String phone, String address,
			Date enrollDate, char code, int no) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.enrollDate = enrollDate;
		this.code = code;
		this.no = no;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", phone=" + phone + ", address=" + address + ", enrollDate=" + enrollDate + ", code=" + code
				+ ", no=" + no + "]";
	}
	 
	
}
