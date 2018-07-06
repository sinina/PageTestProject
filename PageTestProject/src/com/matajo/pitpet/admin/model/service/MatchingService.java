package com.matajo.pitpet.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.admin.model.dao.MatchingDao;
import com.matajo.pitpet.admin.model.vo.MatchingVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class MatchingService {

	public List<MatchingVo> getMatching() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<MatchingVo> list = new MatchingDao().selectMatchingCount(con);
		JDBCTemplate.close(con);
		return list;
	}

}
