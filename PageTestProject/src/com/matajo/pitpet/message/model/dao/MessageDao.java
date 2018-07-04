package com.matajo.pitpet.message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.message.model.vo.MessageVo;

public class MessageDao {
	public int insertMessage(Connection con, MessageVo message) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO MESSAGE VALUES(?,SYSDATE,SEQ_MESSAGE.NEXTVAL,?,?,DEFAULT,?)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정 - ?의 갯수만큼
			pstmt.setString(1, message.getContent());
			pstmt.setInt(2, message.getSenderNo());
			pstmt.setInt(3, message.getResverNo());
			pstmt.setInt(4, message.getMsgCode());
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

	public int updateMessage(Connection con, int messageNo) {
		
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE MESSAGE "
					+ "SET MES_FLAG = 'Y' "
					+ "WHERE MES_MSG_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<MessageVo> selectMessageList(Connection con,int memberNo) {
		ArrayList<MessageVo> list = new ArrayList<MessageVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			query = "SELECT M1.MES_CODE, M1.MES_MSG_NO, M1.MES_CONTENTS, M1.MES_ENROLLDATE, M1.MES_FLAG, M2.M_USERNAME "
					+ "FROM MESSAGE M1 JOIN MEMBER M2 ON(M1.MES_SENDER_NO=M2.M_MEMBER_NO) "
					+ "WHERE M1.MES_RESVER_NO = ?";

			pstmt= con.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rs= pstmt.executeQuery();
			
			MessageVo temp= null;
			while(rs.next()){
				temp= new MessageVo();
				temp.setMsgNo(rs.getInt("mes_msg_no"));
				temp.setSenderName(rs.getString("m_username"));
				temp.setWriteDate(rs.getDate("MES_ENROLLDATE"));
				temp.setContent(rs.getString("mes_contents"));
				temp.setMsgCode(rs.getInt("mes_code"));
				temp.setMsgFlag(rs.getString("mes_flag").charAt(0));
			
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
	}
		return list;
	}

	public MessageVo selectMessageFlag(Connection con, int memberNo) {
			PreparedStatement pstmt  = null;
			MessageVo count = null;
			ResultSet rs = null;
			String query = "";
			query = "SELECT COUNT(M1.MES_FLAG) "
					+ "FROM MESSAGE M1 JOIN MEMBER M2 ON (M1.MES_RESVER_NO=M2.M_MEMBER_NO) "
					+ "WHERE M1.MES_FLAG='N' AND M1.MES_RESVER_NO=?";
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, memberNo);
				rs = pstmt.executeQuery();
				
				/*MessageVo temp= null;*/
				if(rs.next()){
					count= new MessageVo();
					count.setnFlagCnt(rs.getInt("COUNT(M1.MES_FLAG)"));
					//System.out.println(count.getnFlagCnt());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			return count;
	}

	public int deleteMessage(Connection con, int messageNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "delete MESSAGE WHERE MES_MSG_NO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
