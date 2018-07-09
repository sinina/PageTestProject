package com.matajo.pitpet.board.model.vo;

public class BoardVo {
	private int no;
	private String name;
	private String address;
	private String title;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private int level;
	private String opportunity;
	private String activityhisotry;
	private String prcontext;
	private int pickup;
	private int camera;
	private String license1;
	private String license2;
	private String license3;
	private String license4;
	private int child;
	private int jobstyle;
	private int animalcheck;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	

	
	public BoardVo(int no, String name, String address, String title, String photo1, String photo2, String photo3,
			String photo4, int level, String opportunity, String activityhisotry, String prcontext, int pickup,
			int camera, String license1, String license2, String license3, String license4, int child, int jobstyle,
			int animalcheck) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
		this.title = title;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.level = level;
		this.opportunity = opportunity;
		this.activityhisotry = activityhisotry;
		this.prcontext = prcontext;
		this.pickup = pickup;
		this.camera = camera;
		this.license1 = license1;
		this.license2 = license2;
		this.license3 = license3;
		this.license4 = license4;
		this.child = child;
		this.jobstyle = jobstyle;
		this.animalcheck = animalcheck;
	}




	public int getNo() {
		return no;
	}




	public void setNo(int no) {
		this.no = no;
	}




	public String getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}

	public String getActivityhisotry() {
		return activityhisotry;
	}

	public void setActivityhisotry(String activityhisotry) {
		this.activityhisotry = activityhisotry;
	}

	public String getPrcontext() {
		return prcontext;
	}

	public void setPrcontext(String prcontext) {
		this.prcontext = prcontext;
	}

	public int getPickup() {
		return pickup;
	}

	public void setPickup(int pickup) {
		this.pickup = pickup;
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public String getLicense1() {
		return license1;
	}

	public void setLicense1(String license1) {
		this.license1 = license1;
	}

	public String getLicense2() {
		return license2;
	}

	public void setLicense2(String license2) {
		this.license2 = license2;
	}

	public String getLicense3() {
		return license3;
	}

	public void setLicense3(String license3) {
		this.license3 = license3;
	}

	public String getLicense4() {
		return license4;
	}

	public void setLicense4(String license4) {
		this.license4 = license4;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getJobstyle() {
		return jobstyle;
	}

	public void setJobstyle(int jobstyle) {
		this.jobstyle = jobstyle;
	}

	public int getAnimalcheck() {
		return animalcheck;
	}

	public void setAnimalcheck(int animalcheck) {
		this.animalcheck = animalcheck;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}




	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", name=" + name + ", address=" + address + ", title=" + title + ", photo1="
				+ photo1 + ", photo2=" + photo2 + ", photo3=" + photo3 + ", photo4=" + photo4 + ", level=" + level
				+ ", opportunity=" + opportunity + ", activityhisotry=" + activityhisotry + ", prcontext=" + prcontext
				+ ", pickup=" + pickup + ", camera=" + camera + ", license1=" + license1 + ", license2=" + license2
				+ ", license3=" + license3 + ", license4=" + license4 + ", child=" + child + ", jobstyle=" + jobstyle
				+ ", animalcheck=" + animalcheck + "]";
	}
	



}
