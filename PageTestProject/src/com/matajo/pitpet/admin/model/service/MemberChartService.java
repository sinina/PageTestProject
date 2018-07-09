package com.matajo.pitpet.admin.model.service;

import java.sql.Connection;

import com.matajo.pitpet.admin.model.dao.MemberChartDao;
import com.matajo.pitpet.common.JDBCTemplate;

public class MemberChartService {
	
    public int getOMemberCount(String area) {

        Connection con = JDBCTemplate.getConnection();
        int result = new MemberChartDao().getOwnerCount(con, area);

        if (0 < result) {
            JDBCTemplate.commit(con);
        } else {
            JDBCTemplate.rollback(con);
        }
        JDBCTemplate.close(con);
        return result;
    }

    public int getPSMemberCount(String area) {

        Connection con = JDBCTemplate.getConnection();
        int result = new MemberChartDao().getPetsCount(con, area);

        if (0 < result) {
            JDBCTemplate.commit(con);
        } else {
            JDBCTemplate.rollback(con);
        }
        JDBCTemplate.close(con);
        return result;
    }

}
