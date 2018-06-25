package com.matajo.pitpet.visitCounter.model.vo;

import java.util.Date;

public class VisitCountVo {
	//방문자 테이블에 방문날짜 컬럼 있음
	private Date visitDate;
	
	public VisitCountVo(){}

	public VisitCountVo(Date visitDate) {
		super();
		this.visitDate = visitDate;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	
}
