package com.matajo.pitpet.petsiterApply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo;

public class PetsiterApplyDao {

	public int insertApply(Connection con, PetsiterApplyVo apply) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO PETS_APPLY VALUES(SEQ_PETS_APPLY.NEXTVAL,?,?,?,?)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정 - ?의 갯수만큼
	/*		pstmt.setString(1, apply.getPetsJob());
			pstmt.setInt(2, apply.getMemberNo());
			pstmt.setString(3, apply.getInfo());
			pstmt.setString(4, apply.getLicense());*/
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 리턴
		return result;
	}

}
