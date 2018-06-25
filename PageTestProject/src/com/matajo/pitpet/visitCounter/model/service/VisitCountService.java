package com.matajo.pitpet.visitCounter.model.service;

import java.sql.Connection;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.visitCounter.model.dao.VisitCountDao;


public class VisitCountService {
	public int setVisit() {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new VisitCountDao().setTotalCount(con);
		
        if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public int getTotalCount() {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new VisitCountDao().getTotalCount(con);
		
        if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public int getTodayCount() {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new VisitCountDao().getTodayCount(con);
		
        if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}
}
