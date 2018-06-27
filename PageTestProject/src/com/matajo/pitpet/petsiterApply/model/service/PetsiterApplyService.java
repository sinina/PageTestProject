package com.matajo.pitpet.petsiterApply.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.MemberDao;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.petsiterApply.model.dao.PetsiterApplyDao;
import com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo;

public class PetsiterApplyService {

	public int writeApply(PetsiterApplyVo apply) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PetsiterApplyDao().insertApply(con, apply);
		if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public List<PetsiterApplyVo> getApplyList() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<PetsiterApplyVo> list = new PetsiterApplyDao().selectMemberList(con);
		JDBCTemplate.close(con);
		return list;
	}

}
