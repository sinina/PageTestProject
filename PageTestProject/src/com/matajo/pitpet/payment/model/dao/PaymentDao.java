package com.matajo.pitpet.payment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.payment.model.vo.PaymentVo;

public class PaymentDao {

	public int insertPayment(Connection con, PaymentVo pv) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="";
		System.out.println(pv.getPetoNo());
		System.out.println(pv.getPetsNo());
		
		query="INSERT INTO PAYMENT VALUES(?,?,SYSDATE,DEFAULT,?,?,SEQ_PAYMENT.NEXTVAL)";
		try {
			pstmt=con.prepareStatement(query);
				
			pstmt.setString(1, pv.getPayKind());
			pstmt.setInt(2, pv.getPetoNo());
			pstmt.setInt(3, pv.getPetsNo());
			pstmt.setInt(4, pv.getPrice());
			//System.out.println(res.getEnd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


}
