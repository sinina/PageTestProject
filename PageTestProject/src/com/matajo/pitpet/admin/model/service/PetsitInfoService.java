package com.matajo.pitpet.admin.model.service;

import java.sql.Connection;

import com.matajo.pitpet.admin.model.dao.PetsitInfoDao;
import com.matajo.pitpet.admin.model.vo.PetsitInfoVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class PetsitInfoService {

	public PetsitInfoVo getGradePetsit() {
		Connection con = JDBCTemplate.getConnection();
		PetsitInfoVo pI= new PetsitInfoDao().selectGradePetsit(con);
		JDBCTemplate.close(con);

		return pI;
	}

}
