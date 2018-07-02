package com.matajo.pitpet.member.model.vo;


public class PetsitterApplyVo {
	private int no  ;
	private int type ;
	private int openarea ;
	private int jobstyle ;
	private String adComment ;
	private String opportunity ;
	private String activityHistory ;
	private int long_term ;
	private int pickup ;
	private String prContext ;
	private String sitterCareer ;
	private String petSize; 
	private String petAge ;
	private int animalCheck ;
	private int animalCount ;
	private int child ;
	private int camera ;
	private int distance ;
	private String hospital ;
	private String hospitalPhoneNumber ;
	private int oneDayCount ;
	private String bank ;
	private String bankName ;
	private String bankNumber ;
	//관리자페이지에서 리스트 출력할때 이름도 출력하기위해 보람이가 넣음!
	private String name;
	
	public PetsitterApplyVo() {
	}

	public PetsitterApplyVo(int no, int type, int openarea, int jobstyle, String adComment, String opportunity,
			String activityHistory, int long_term, int pickup, String prContext, String sitterCareer, String petSize,
			String petAge, int animalCheck, int animalCount, int child, int camera, int distance, String hospital,
			String hospitalPhoneNumber, int oneDayCount, String bank, String bankName, String bankNumber) {
		this.no = no;
		this.type = type;
		this.openarea = openarea;
		this.jobstyle = jobstyle;
		this.adComment = adComment;
		this.opportunity = opportunity;
		this.activityHistory = activityHistory;
		this.long_term = long_term;
		this.pickup = pickup;
		this.prContext = prContext;
		this.sitterCareer = sitterCareer;
		this.petSize = petSize;
		this.petAge = petAge;
		this.animalCheck = animalCheck;
		this.animalCount = animalCount;
		this.child = child;
		this.camera = camera;
		this.distance = distance;
		this.hospital = hospital;
		this.hospitalPhoneNumber = hospitalPhoneNumber;
		this.oneDayCount = oneDayCount;
		this.bank = bank;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOpenarea() {
		return openarea;
	}

	public void setOpenarea(int openarea) {
		this.openarea = openarea;
	}

	public int getJobstyle() {
		return jobstyle;
	}

	public void setJobstyle(int jobstyle) {
		this.jobstyle = jobstyle;
	}

	public String getAdComment() {
		return adComment;
	}

	public void setAdComment(String adComment) {
		this.adComment = adComment;
	}

	public String getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}

	public String getActivityHistory() {
		return activityHistory;
	}

	public void setActivityHistory(String activityHistory) {
		this.activityHistory = activityHistory;
	}

	public int getLong_term() {
		return long_term;
	}

	public void setLong_term(int long_term) {
		this.long_term = long_term;
	}

	public int getPickup() {
		return pickup;
	}

	public void setPickup(int pickup) {
		this.pickup = pickup;
	}

	public String getPrContext() {
		return prContext;
	}

	public void setPrContext(String prContext) {
		this.prContext = prContext;
	}

	public String getSitterCareer() {
		return sitterCareer;
	}

	public void setSitterCareer(String sitterCareer) {
		this.sitterCareer = sitterCareer;
	}

	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}

	public String getPetAge() {
		return petAge;
	}

	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}

	public int getAnimalCheck() {
		return animalCheck;
	}

	public void setAnimalCheck(int animalCheck) {
		this.animalCheck = animalCheck;
	}

	public int getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(int animalCount) {
		this.animalCount = animalCount;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getHospitalPhoneNumber() {
		return hospitalPhoneNumber;
	}

	public void setHospitalPhoneNumber(String hospitalPhoneNumber) {
		this.hospitalPhoneNumber = hospitalPhoneNumber;
	}

	public int getOneDayCount() {
		return oneDayCount;
	}

	public void setOneDayCount(int oneDayCount) {
		this.oneDayCount = oneDayCount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PetsitterApplyVo [nickname=" + no + ", type=" + type + ", openarea=" + openarea + ", jobstyle="
				+ jobstyle + ", adComment=" + adComment + ", opportunity=" + opportunity + ", activityHistory="
				+ activityHistory + ", long_term=" + long_term + ", pickup=" + pickup + ", prContext=" + prContext
				+ ", sitterCareer=" + sitterCareer + ", petSize=" + petSize + ", petAge="
				+ petAge + ", animalCheck=" + animalCheck + ", animalCount=" + animalCount + ", child="
				+ child + ", camera=" + camera + ", distance=" + distance + ", hospital=" + hospital
				+ ", hospitalPhoneNumber=" + hospitalPhoneNumber + ", oneDayCount=" + oneDayCount + ", bank=" + bank
				+ ", bankName=" + bankName + ", bankNumber=" + bankNumber + "]";
	}
	
	
}
