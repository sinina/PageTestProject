package com.matajo.pitpet.reservation.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;

import com.matajo.pitpet.reservation.model.dao.ReservationDao;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

public class ReservationService {

	//예약 현황 캘린더 
	public List<ReservationVo> getReservation() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReservationVo> list = new ReservationDao().selectReservation(con);
		JDBCTemplate.close(con);
		return list;
	}

	public int updateAccDny(int resNo, int accDny) {
		Connection con = JDBCTemplate.getConnection();
		int result = new ReservationDao().updateAccDny(con, resNo,accDny);
		if(result>0){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public int insertReservation(ReservationVo res) {
		Connection con = JDBCTemplate.getConnection();
		int result = new ReservationDao().insertReservation(con, res);
		if(result>0){
			
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	//예약 정보들 가지고 예약 번호 가져오기
	public int selectResNo(ReservationVo res) {
		Connection con = JDBCTemplate.getConnection();
		int resNo = new ReservationDao().selectResNo(con,res);
		JDBCTemplate.close(con);
		return resNo;
	}

	//예약 번호 가지고 예약 정보 가져오기
	public ReservationVo selectResInfo(int resNo) {
		Connection con = JDBCTemplate.getConnection();
		ReservationVo res = new ReservationDao().selectResInfo(con,resNo);
		JDBCTemplate.close(con);
		return res;
	}

}
