package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.admin.model.vo.SalesVo;

public class SalesDao {

	public ArrayList<SalesVo> selectSalesSum(Connection con) {
		ArrayList<SalesVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="";
		
		query="";
		try {
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
