package com.matajo.pitpet.admin.model.vo;

public class MemberChartVo {
	 private int address;
	    private int member_code;

	    public int getAddress() {
	        return this.address;
	    }

	    public int getMember_code() {
	        return this.member_code;
	    }

	    public void setAddress(int address) {
	        this.address = address;
	    }

	    public void setMember_code(int member_code) {
	        this.member_code = member_code;
	    }

	    public MemberChartVo(int address, int member_code) {
	        this.address = address;
	        this.member_code = member_code;
	    }

}
