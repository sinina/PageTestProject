package com.matajo.pitpet.petsiterApply.model.vo;

public class PetsiterApplyVo {
	private int applyNo;
	private String job;
	private int memberNo;
	private String info;
	private String license;
	
	private String memberId;
	private String memberName;
	private String phone;
	
	
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "PetsiterApplyVo [applyNo=" + applyNo + ", job=" + job + ", memberNo=" + memberNo + ", info=" + info
				+ ", license=" + license + "]";
	}
	
	public PetsiterApplyVo(){}
	
	public PetsiterApplyVo(int applyNo, String job, int memberNo, String info, String license) {
		super();
		this.applyNo = applyNo;
		this.job = job;
		this.memberNo = memberNo;
		this.info = info;
		this.license = license;
	}
	
	

}
