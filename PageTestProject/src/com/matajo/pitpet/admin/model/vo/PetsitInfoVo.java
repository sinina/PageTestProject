package com.matajo.pitpet.admin.model.vo;

import java.util.Date;

public class PetsitInfoVo {
	private int p_i_no;
	private Date p_i_up;
	private int p_i_level;
	
	private String name;
	public int getP_i_no() {
		return p_i_no;
	}
	public void setP_i_no(int p_i_no) {
		this.p_i_no = p_i_no;
	}
	public Date getP_i_up() {
		return p_i_up;
	}
	public void setP_i_up(Date p_i_up) {
		this.p_i_up = p_i_up;
	}
	public int getP_i_level() {
		return p_i_level;
	}
	public void setP_i_level(int p_i_level) {
		this.p_i_level = p_i_level;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetsitInfoVo(int p_i_no, Date p_i_up, int p_i_level) {
		super();
		this.p_i_no = p_i_no;
		this.p_i_up = p_i_up;
		this.p_i_level = p_i_level;
	}
	
	public PetsitInfoVo(){}
}
