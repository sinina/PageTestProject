package com.matajo.pitpet.visitCounter.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.PetsitterDao;
import com.matajo.pitpet.member.model.vo.PetsitterApplyVo;
import com.matajo.pitpet.visitCounter.model.dao.VisitCountDao;
import com.matajo.pitpet.visitCounter.model.vo.VisitCountVo;


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

	public List<VisitCountVo> getMonthCount() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<VisitCountVo> list = new VisitCountDao().selectMonthCount(con);
		JDBCTemplate.close(con);
		return list;
	}
}
