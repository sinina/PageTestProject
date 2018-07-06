package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.matajo.pitpet.common.JDBCTemplate;

public class MemberChartDao {
	 public int getTotalMemberCount(Connection con, String area){
	        Statement stmt = null;
	        ResultSet rs = null;
	        int result =0;

	        String query ="";

	        try {
	            stmt= con.createStatement();
	            query="SELECT COUNT(*) AS TotalCnt" +
	                    "  FROM MEMBER " +
	                    "WHERE M_MEMBER_CODE = '2' AND M_ADDRESS LIKE '%"+area+"%'";
	            rs= stmt.executeQuery(query);

	            if(rs.next()){
	                result = rs.getInt("TotalCnt");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            JDBCTemplate.close(rs);
	            JDBCTemplate.close(stmt);
	        }
	        return result;


	    }

}
