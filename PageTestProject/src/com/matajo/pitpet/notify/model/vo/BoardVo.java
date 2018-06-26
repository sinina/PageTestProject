package com.matajo.pitpet.notify.model.vo;


import java.util.Date;


public class BoardVo {
		private String title;
		private int price;
		private String place;
		private String sitterName;
		private boolean baby;
		private char family;
		private String animal;
		private String interv;
		private String info;
		private char type;
		private String image;
		private int no;
		private int memberNo;
		private boolean delFlag;
		private Date writeDate;
		private String petonimal;
		private char animalNo;
		
		
	public BoardVo(){
			
		}
	
	
		public BoardVo(String title, int price, String place, String sitterName, boolean baby, char family, String animal,
			String interv, String info, char type, String image, int no, int memberNo, boolean delFlag, Date writeDate,
			String petonimal, char animalNo) {
		super();
		this.title = title;
		this.price = price;
		this.place = place;
		this.sitterName = sitterName;
		this.baby = baby;
		this.family = family;
		this.animal = animal;
		this.interv = interv;
		this.info = info;
		this.type = type;
		this.image = image;
		this.no = no;
		this.memberNo = memberNo;
		this.delFlag = delFlag;
		this.writeDate = writeDate;
		this.petonimal = petonimal;
		this.animalNo = animalNo;
	}



		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public String getPlace() {
			return place;
		}


		public void setPlace(String place) {
			this.place = place;
		}


		public String getSitterName() {
			return sitterName;
		}


		public void setSitterName(String sitterName) {
			this.sitterName = sitterName;
		}


		public boolean isBaby() {
			return baby;
		}


		public void setBaby(boolean baby) {
			this.baby = baby;
		}


		public char getFamily() {
			return family;
		}


		public void setFamily(char family) {
			this.family = family;
		}


		public String getAnimal() {
			return animal;
		}


		public void setAnimal(String animal) {
			this.animal = animal;
		}


		public String getInterv() {
			return interv;
		}


		public void setInterv(String interv) {
			this.interv = interv;
		}


		public String getInfo() {
			return info;
		}


		public void setInfo(String info) {
			this.info = info;
		}


		public char getType() {
			return type;
		}


		public void setType(char type) {
			this.type = type;
		}


		public String getImage() {
			return image;
		}


		public void setImage(String image) {
			this.image = image;
		}


		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}


		public int getMemberNo() {
			return memberNo;
		}


		public void setMemberNo(int memberNo) {
			this.memberNo = memberNo;
		}


		public boolean isDelFlag() {
			return delFlag;
		}


		public void setDelFlag(boolean delFlag) {
			this.delFlag = delFlag;
		}


		public Date getWriteDate() {
			return writeDate;
		}


		public void setWriteDate(Date writeDate) {
			this.writeDate = writeDate;
		}


		public String getPetonimal() {
			return petonimal;
		}


		public void setPetonimal(String petonimal) {
			this.petonimal = petonimal;
		}


		public char getAnimalNo() {
			return animalNo;
		}


		public void setAnimalNo(char animalNo) {
			this.animalNo = animalNo;
		}


		@Override
		public String toString() {
			return "BoardVo [title=" + title + ", price=" + price + ", place=" + place + ", sitterName=" + sitterName
					+ ", baby=" + baby + ", family=" + family + ", animal=" + animal + ", interv=" + interv + ", info="
					+ info + ", type=" + type + ", image=" + image + ", no=" + no + ", memberNo=" + memberNo
					+ ", delFlag=" + delFlag + ", writeDate=" + writeDate + ", petonimal=" + petonimal + ", animalNo="
					+ animalNo + "]";
		}


	
		
		
		
		
	
	
	
}
