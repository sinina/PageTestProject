package com.matajo.pitpet.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.admin.model.dao.SalesDao;
import com.matajo.pitpet.admin.model.vo.SalesVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class SalesService {

	public List<SalesVo> getSales() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<SalesVo> list = new SalesDao().selectSalesSum(con);
		JDBCTemplate.close(con);
		return list;
	}

}
