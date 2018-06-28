package com.matajo.pitpet.member.model.service;

import java.sql.Connection;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.PetsitterDao;
import com.matajo.pitpet.member.model.vo.PetsitterApplyVo;

public class PetsitterService {

	public int insertPetsitterInfo(PetsitterApplyVo petSitterInfo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PetsitterDao().insertPetsitterInfo(con,petSitterInfo);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}
	
}
