package com.matajo.pitpet.review.model.vo;

import java.util.Date;

public class ReviewVo {
	private int memberNo;
	private Date enrollDate;
	private int grdNum;
	private String info;
	private char postType;
	private char delFlag;
	private int no;
	
	//후기글 쓴 게시글의 번호
	private int boardNo;
	
	private String memberName;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getGrdNum() {
		return grdNum;
	}
	public void setGrdNum(int grdNum) {
		this.grdNum = grdNum;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public char getPostType() {
		return postType;
	}
	public void setPostType(char postType) {
		this.postType = postType;
	}
	public char getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(char delFlag) {
		this.delFlag = delFlag;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public ReviewVo(int memberNo, Date enrollDate, int grdNum, String info, char postType, char delFlag, int no,
			String memberName) {
		super();
		this.memberNo = memberNo;
		this.enrollDate = enrollDate;
		this.grdNum = grdNum;
		this.info = info;
		this.postType = postType;
		this.delFlag = delFlag;
		this.no = no;
		this.memberName = memberName;
	}
	
	public ReviewVo(){}
	

}
