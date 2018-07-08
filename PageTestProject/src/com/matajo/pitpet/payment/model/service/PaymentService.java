package com.matajo.pitpet.payment.model.service;

import java.sql.Connection;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.payment.model.dao.PaymentDao;
import com.matajo.pitpet.payment.model.vo.PaymentVo;

public class PaymentService {

	public int insertPayment(PaymentVo pv) {
		Connection con = JDBCTemplate.getConnection();
		int result = new PaymentDao().insertPayment(con,pv);
		JDBCTemplate.close(con);
		return result;
	}

}
