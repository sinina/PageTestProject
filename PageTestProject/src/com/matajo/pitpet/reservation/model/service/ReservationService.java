package com.matajo.pitpet.reservation.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;

import com.matajo.pitpet.reservation.model.dao.ReservationDao;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

public class ReservationService {

	public List<ReservationVo> getReservation() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReservationVo> list = new ReservationDao().selectReservation(con);
		JDBCTemplate.close(con);
		return list;
	}

}
