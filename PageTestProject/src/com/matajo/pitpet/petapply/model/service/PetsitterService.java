package com.matajo.pitpet.petapply.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.petapply.model.dao.PetsitterDao;
import com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo;


public class PetsitterService {

	public int insertPetsitterInfo(PetsitterApplyVo petSitterInfo,ArrayList<String> list) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PetsitterDao().insertPetsitterInfo(con,petSitterInfo,list);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public ArrayList<PetsitterApplyVo> getApplyList(int okayN) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<PetsitterApplyVo> list = new PetsitterDao().selectApplyList(con,okayN);
		JDBCTemplate.close(con);
		return list;
	}

	public int updateOkayN(int memberNo,int selectNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PetsitterDao().updateOkayN(con,memberNo,selectNo);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	//관리자가 펫시터 신청 상세정보 보려고 할때
	public PetsitterApplyVo selectApplyDetail(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		PetsitterApplyVo apply = new PetsitterDao().selectApplyDetail(con,memberNo);
		JDBCTemplate.close(con);
		return apply;
	}
	
}
