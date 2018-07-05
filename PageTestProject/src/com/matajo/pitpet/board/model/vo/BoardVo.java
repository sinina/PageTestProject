package com.matajo.pitpet.board.model.vo;

public class BoardVo {
	private String name;
	private String address;
	private String title;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private  int level;
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(String name, String address, String title, String photo1, String photo2, String photo3,
			String photo4 ,int level) {
		super();
		this.name = name;
		this.address = address;
		this.title = title;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.level = level;
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
		return "BoardVo [name=" + name + ", address=" + address + ", title=" + title + ", photo1=" + photo1
				+ ", photo2=" + photo2 + ", photo3=" + photo3 + ", photo4=" + photo4 + ", level=" + level + "]";
	}

	
}
