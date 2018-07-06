package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.matajo.pitpet.admin.model.vo.PetsitInfoVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class PetsitInfoDao {

	public PetsitInfoVo selectGradePetsit(Connection con) {
		PetsitInfoVo pI = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="";
		
		query="SELECT P.*, M.M_USERNAME FROM PETSIT_INFO P JOIN MEMBER M ON(P.P_I_NO=M.M_MEMBER_NO) "
				+ "WHERE P_I_UP<=(SELECT TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYY-MM-DD') "
				+ "FROM DUAL) ";
		try {
			pstmt = con.prepareStatement(query);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				pI = new PetsitInfoVo();
				pI.setP_i_no(rs.getInt("p_i_no"));
				pI.setP_i_level(rs.getInt("p_i_level"));
				pI.setP_i_up(rs.getDate("p_i_up"));
				pI.setName(rs.getString("m_username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return pI;
	}

}
