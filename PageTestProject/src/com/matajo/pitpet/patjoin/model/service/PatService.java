package com.matajo.pitpet.patjoin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.MemberDao;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.message.model.dao.MessageDao;
import com.matajo.pitpet.message.model.vo.MessageVo;
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

	public ArrayList<PatVo> Selectpat(String id) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<PatVo> list = new PatDao().SelectPatcon(con, id);
		JDBCTemplate.close(con);
		return list;
	}

	public int patSelect2(String id) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PatDao().patSelect2(con,id);
		JDBCTemplate.close(con);
		return result;
	}

	public List<PatVo> patSelect(int petoNo) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<PatVo> pInfo = new PatDao().selectPatinfo(con,petoNo);
		JDBCTemplate.close(con);
		return pInfo;
		
	}

	

}
