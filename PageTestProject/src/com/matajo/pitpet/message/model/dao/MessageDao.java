package com.matajo.pitpet.message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.message.model.vo.MessageVo;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

public class MessageDao {
	public int insertMessage(Connection con, MessageVo message) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		query = "INSERT INTO MESSAGE VALUES('예약 요청이 들어왔습니다.',SYSDATE,SEQ_MESSAGE.NEXTVAL,?,?,1,default,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, message.getSenderNo());
			pstmt.setInt(2, message.getResverNo());
			pstmt.setInt(3, message.getRes_no());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
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
				
				if(rs.next()){
					count= new MessageVo();
					count.setnFlagCnt(rs.getInt("COUNT(M1.MES_FLAG)"));
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

	public int insertPetsMsg(Connection con, ReservationVo res) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		query = "INSERT INTO MESSAGE VALUES(?,SYSDATE,SEQ_MESSAGE.NEXTVAL,?,?,?,default,?)";
		try {
			pstmt = con.prepareStatement(query);
			System.out.println(res.getAccDny());
			if(res.getAccDny()=='1'){
				pstmt.setString(1, "예약 승인 되었습니다. 결제 해주세요.");
				pstmt.setInt(4, 2);
				
			}else{
				pstmt.setString(1, "예약이 거절 되었습니다.");
				pstmt.setInt(4, 3);
			}
			pstmt.setInt(2, res.getPetsNo());
			pstmt.setInt(3, res.getPetoNo());
			pstmt.setInt(5, res.getResNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertPaymentMsg(Connection con, MessageVo message) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		query = "INSERT INTO MESSAGE VALUES('결제가 완료 되었습니다.',SYSDATE,SEQ_MESSAGE.NEXTVAL,?,?,4,default,?)";
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, message.getSenderNo());
			pstmt.setInt(2, message.getResverNo());
			pstmt.setInt(3, message.getRes_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
