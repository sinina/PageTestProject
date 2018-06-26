package com.matajo.pitpet.message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.message.model.vo.MessageVo;

public class MessageDao {
	public int insertMessage(Connection con, MessageVo message) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO MESSAGE VALUES(?,SYSDATE,SEQ_MESSAGE.NEXTVAL,?,?,DEFAULT)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정 - ?의 갯수만큼
			pstmt.setString(1, message.getContent());
			pstmt.setInt(2, message.getSenderNo());
			pstmt.setInt(3, message.getResverNo());
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

	public int updateMessage(Connection con, int msgNo) {
		
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE MESSAGE "
					+ "SET MES_FLAG = 'Y' "
					+ "WHERE MES_MSG_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, msgNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
