package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.matajo.pitpet.admin.model.vo.PetsitInfoVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class PetsitInfoDao {

	public ArrayList<PetsitInfoVo> selectGradePetsit(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PetsitInfoVo> pI = null;
		String query="";
		
		query="SELECT P.*, M.M_USERNAME FROM PETSIT_INFO P JOIN MEMBER M ON(P.P_I_NO=M.M_MEMBER_NO) "
				+ "WHERE P_I_UP<=(SELECT TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYY-MM-DD') "
				+ "FROM DUAL) AND P_I_LEVEL=0";
		try {
			pstmt = con.prepareStatement(query);
			rs= pstmt.executeQuery();
			pI = new ArrayList<PetsitInfoVo>();
			PetsitInfoVo temp= null;
			
			while(rs.next()){
				temp= new PetsitInfoVo();
				
				temp.setP_i_no(rs.getInt("p_i_no"));
				temp.setP_i_level(rs.getInt("p_i_level"));
				temp.setP_i_up(rs.getDate("p_i_up"));
				temp.setName(rs.getString("m_username"));
				
				pI.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return pI;
	}

	public int updatePetsGrade(Connection con, int memberNo) {
		int result=0;
		PreparedStatement pstmt = null;
		String query="";
		
		query="UPDATE PETSIT_INFO SET P_I_LEVEL='1' WHERE P_I_NO=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
