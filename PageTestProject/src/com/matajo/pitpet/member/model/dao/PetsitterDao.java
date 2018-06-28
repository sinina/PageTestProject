package com.matajo.pitpet.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.PetsitterApplyVo;

public class PetsitterDao {

	public int insertPetsitterInfo(Connection con, PetsitterApplyVo petSitterInfo) {
		int result=0;
		String query="";
		PreparedStatement pstmt=null;
		
		try {
			query="INSERT INTO PETS_APPLY VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,petSitterInfo.getNo());
			pstmt.setInt(2, petSitterInfo.getType());
			pstmt.setInt(3, petSitterInfo.getOpenarea());
			pstmt.setInt(4, petSitterInfo.getJobstyle());
			pstmt.setString(5, petSitterInfo.getAdComment());
			pstmt.setString(6, petSitterInfo.getOpportunity());
			pstmt.setString(7, petSitterInfo.getActivityHistory());
			pstmt.setInt(8,petSitterInfo.getLong_term() );
			pstmt.setInt(9, petSitterInfo.getPickup());
			pstmt.setString(10, petSitterInfo.getPetSize());
			pstmt.setString(11, petSitterInfo.getPetAge());
			pstmt.setInt(12, petSitterInfo.getAnimalCheck());
			pstmt.setInt(13, petSitterInfo.getAnimalCount());
			pstmt.setInt(14, petSitterInfo.getChild());
			pstmt.setInt(15, petSitterInfo.getCamera());
			pstmt.setInt(16, petSitterInfo.getDistance());
			pstmt.setString(17, petSitterInfo.getHospital());
			pstmt.setString(18, petSitterInfo.getHospitalPhoneNumber());
			pstmt.setInt(19, petSitterInfo.getOneDayCount());
			pstmt.setString(20, petSitterInfo.getBank());
			pstmt.setString(21, petSitterInfo.getBankName());
			pstmt.setString(22, petSitterInfo.getBankNumber());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
				
		return result;
	}

}
