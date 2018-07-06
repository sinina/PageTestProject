package com.matajo.pitpet.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.admin.model.dao.PetsitInfoDao;
import com.matajo.pitpet.admin.model.vo.PetsitInfoVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class PetsitInfoService {

	public List<PetsitInfoVo> getGradePetsit() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<PetsitInfoVo> pI= new PetsitInfoDao().selectGradePetsit(con);
		JDBCTemplate.close(con);

		return pI;
	}

	public int updatePetsGrade(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PetsitInfoDao().updatePetsGrade(con, memberNo);
		
		if(result>0){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
	}

}
