package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.matajo.pitpet.common.JDBCTemplate;

public class MemberChartDao {
	  public int getOwnerCount(Connection con, String area){
            //총방문자수 가져오는 메소드
            Statement stmt = null;
            ResultSet rs = null;
            int result =0;

            String query = "";

            try {
                stmt= con.createStatement();
                query="select count(*)" +
                        "  from MEMBER" +
                        "where M_MEMBER_CODE = '1' and M_ADDRESS like '%"+area+"%'";
                rs= stmt.executeQuery(query);

                if(rs.next()){
                    result = rs.getInt("TotalOwnerCnt");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
            JDBCTemplate.close(rs);
            JDBCTemplate.close(stmt);
        }
        return result;

    }

    public int getPetsCount(Connection con, String area){
        //총방문자수 가져오는 메소드
        Statement stmt = null;
        ResultSet rs = null;
        int result =0;

        String query = "";

        try {
            stmt= con.createStatement();
            query="select count(*)" +
                    "  from MEMBER" +
                    "where M_MEMBER_CODE = '2' and M_ADDRESS like '%"+area+"%'";
            rs= stmt.executeQuery(query);

            if(rs.next()){
                result = rs.getInt("TotalPetsCnt");
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
