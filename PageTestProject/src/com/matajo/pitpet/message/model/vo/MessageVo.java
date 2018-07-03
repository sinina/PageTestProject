package com.matajo.pitpet.message.model.vo;

import java.util.Date;

public class MessageVo {
	private int msgNo;
	private int senderNo;
	private int resverNo;
	private String content;
	private Date writeDate;
	private char msgFlag;
	
	private String senderName;
	private String resverName;
	
	
	public int getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(int msgNo) {
		this.msgNo = msgNo;
	}
	public int getSenderNo() {
		return senderNo;
	}
	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}
	public int getResverNo() {
		return resverNo;
	}
	public void setResverNo(int resverNo) {
		this.resverNo = resverNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public char getMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(char msgFlag) {
		this.msgFlag = msgFlag;
	}
	
	
	
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getResverName() {
		return resverName;
	}
	public void setResverName(String resverName) {
		this.resverName = resverName;
	}
	public MessageVo(){}
	public MessageVo(int msgNo, int senderNo, int resverNo, String content, Date writeDate, char msgFlag) {
		super();
		this.msgNo = msgNo;
		this.senderNo = senderNo;
		this.resverNo = resverNo;
		this.content = content;
		this.writeDate = writeDate;
		this.msgFlag = msgFlag;
	}
}
