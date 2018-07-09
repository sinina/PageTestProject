package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.admin.model.vo.SalesVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class SalesDao {

	public ArrayList<SalesVo> selectSalesSum(Connection con) {
		ArrayList<SalesVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="";
		
		query="SELECT TO_CHAR(PAY_DAY,'MM') AS MONTH, SUM(PAY_PRICE) AS PRICE "
				+ "FROM PAYMENT "
				+ "WHERE TO_CHAR(PAY_DAY, 'YYYY') = TO_CHAR(SYSDATE, 'YYYY') "
				+ "GROUP BY TO_CHAR(PAY_DAY,'MM')";
		try {
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			list = new ArrayList<SalesVo>();
			SalesVo temp = new SalesVo();
			while(rs.next()){
				temp = new SalesVo();
				temp.setMonth(rs.getInt("MONTH"));
				temp.setNumber(rs.getInt("PRICE"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
