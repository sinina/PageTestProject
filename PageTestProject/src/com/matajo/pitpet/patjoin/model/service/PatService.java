package com.matajo.pitpet.patjoin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.MemberDao;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.patjoin.model.dao.PatDao;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

public class PatService {

	public int insertPat(PatVo pat) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new PatDao().insertPat(con, pat);
		
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}

	public int updatepat(PatVo pat) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PatDao().updatePat(con, pat);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}

	public int PatEarlse(int id) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PatDao().earlsePat(con, id);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}

	public PatVo Patjoin(String patNo) {
		Connection con = JDBCTemplate.getConnection();
		
		PatVo pat = new PatDao().SelectPat(con, patNo);
		
		JDBCTemplate.close(con);
		
		return pat;
	}

	public PatVo patSelect(String id) {
		Connection con = JDBCTemplate.getConnection();
		PatVo pat = new PatDao().patSelect(con,id);
		JDBCTemplate.close(con);
		return pat;
	}

	//예약 신청할떄 반려주의 펫정보 가져오기위해 만듬
	public PatVo patSelect(int petoNo) {
		Connection con = JDBCTemplate.getConnection();
		PatVo pInfo = new PatDao().patSelect(con,petoNo);
		JDBCTemplate.close(con);
		return pInfo;
		
	}

}
