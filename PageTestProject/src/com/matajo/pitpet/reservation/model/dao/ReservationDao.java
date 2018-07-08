package com.matajo.pitpet.reservation.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

public class ReservationDao {

	public ArrayList<ReservationVo> selectReservation(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReservationVo> list = null;
		String query="";
		
		try {
			query="SELECT TO_CHAR(R.RES_START_TIME,'YYYY-MM-DD HH24:MI:SS') AS \"START\", "
					+ "TO_CHAR(R.RES_END_TIME,'YYYY-MM-DD HH24:MI:SS') AS \"END\", M.M_USERNAME"
					+" FROM RESERVATION R, MEMBER M WHERE RES_ACC_DNY=1 AND M.M_MEMBER_NO=R.RES_PETO_NO";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			list= new ArrayList<ReservationVo>();
			ReservationVo temp=null;
			
			while(rs.next()){
				temp= new ReservationVo();
				temp.setTitle(rs.getString("M_USERNAME"));
				temp.setStart(rs.getString("START"));
				temp.setEnd(rs.getString("END"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ReservationVo selectResInfo(Connection con, int messageNo,int msgCode) {
		ReservationVo res = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="";
		
		if(msgCode==1){
			query="SELECT SUBSTR(R.RES_START_TIME,1,14),  SUBSTR(R.RES_END_TIME,1,14), R.RES_PETO_ANIMAL_KINDS, "
					+ "R.RES_PRICE, M2.M_USERNAME, R.RES_REQUEST, R.RES_NO, R.RES_PETO_NO, R.RES_PETS_NO  "
					+ "FROM RESERVATION R INNER JOIN MESSAGE M1 ON(R.RES_PETO_NO=M1.MES_SENDER_NO)"
					+ "INNER JOIN MEMBER M2 ON(R.RES_PETO_NO=M2.M_MEMBER_NO) "
					+ "WHERE M1.MES_CODE=("
					+ "SELECT MES_CODE FROM MESSAGE "
					+ "WHERE MES_MSG_NO=?)";
		}else{
			query= "SELECT  SUBSTR(R.RES_START_TIME,1,14),  SUBSTR(R.RES_END_TIME,1,14), R.RES_PETO_ANIMAL_KINDS, "
					+ "R.RES_PRICE, M2.M_USERNAME, R.RES_REQUEST, R.RES_NO, R.RES_PETO_NO, R.RES_PETS_NO  "
					+ "FROM RESERVATION R INNER JOIN MESSAGE M1 ON(R.RES_PETS_NO=M1.MES_SENDER_NO)"
					+ "INNER JOIN MEMBER M2 ON(R.RES_PETO_NO=M2.M_MEMBER_NO) "
					+ "WHERE M1.MES_CODE=("
					+ "SELECT MES_CODE FROM MESSAGE "
					+ "WHERE MES_MSG_NO=?)";
			System.out.println("msgCode!=0");
		}		
		try {
			
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				res = new ReservationVo();
				res.setStart(rs.getString("SUBSTR(R.RES_START_TIME,1,14)"));
				res.setEnd(rs.getString("SUBSTR(R.RES_END_TIME,1,14)"));
				res.setAnimalKind(rs.getString("RES_PETO_ANIMAL_KINDS"));
				res.setPrice(rs.getInt("RES_PRICE"));
				res.setPetoName(rs.getString("m_username"));
				res.setRequest(rs.getString("RES_REQUEST"));
				res.setPetoNo(rs.getInt("RES_PETO_NO"));
				res.setPetsNo(rs.getInt("RES_PETS_NO"));
				res.setResNo(rs.getInt("RES_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return res;
	}

	//예약 승인/거절
	public int updateAccDny(Connection con, int resNo, int accDny) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="";
		
		query="UPDATE RESERVATION SET RES_ACC_DNY=? WHERE RES_NO=?";
		try {
			pstmt=con.prepareStatement(query);
				if(accDny==1){
					pstmt.setInt(1, 1);}
				else{
					pstmt.setInt(1, 2);
				}
			pstmt.setInt(2, resNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertReservation(Connection con, ReservationVo res) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query="";
		
		query="INSERT INTO RESERVATION VALUES(to_date(?,'YYYY-MM-DD hh24:mi'), to_date(?,'YYYY-MM-DD hh24:mi'),"
				+" ?,?,?,?,?,DEFAULT,SEQ_RESERVATION.NEXTVAL,?)";
		try {
			pstmt=con.prepareStatement(query);
				
			pstmt.setString(1, res.getStart());
			pstmt.setString(2, res.getEnd());
			pstmt.setInt(3, res.getPetoNo());
			pstmt.setString(4, res.getAnimalKind());
			pstmt.setInt(5, res.getPetsNo());
			pstmt.setInt(6, res.getPrice());
			pstmt.setInt(7, res.getAnimalNo());
			pstmt.setString(8, res.getRequest());
			//System.out.println(res.getEnd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int selectResNo(Connection con, ReservationVo res) {
		PreparedStatement pstmt = null;
		int resNo = 0;
		ResultSet rs = null;
		String query="";
		
		try {
			query="SELECT RES_NO FROM RESERVATION WHERE RES_PETS_NO=? AND RES_PETO_NO=? AND RES_PRICE=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, res.getPetsNo());
			pstmt.setInt(2, res.getPetoNo());
			pstmt.setInt(3, res.getPrice());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				resNo = rs.getInt("res_no");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return resNo;
	}

	public ReservationVo selectResInfo(Connection con, int resNo) {
		PreparedStatement pstmt = null;
		ReservationVo res = null;
		ResultSet rs = null;
		String query="";
		
		query="SELECT R.*, M.M_USERNAME FROM RESERVATION R JOIN MEMBER M ON(R.RES_PETO_NO=M.M_MEMBER_NO) WHERE RES_NO=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, resNo);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()){
				res = new ReservationVo();
				res.setStartTime(rs.getDate("res_start_time"));
				res.setEndTime(rs.getDate("res_end_time"));
				res.setPetoNo(rs.getInt("res_peto_no"));
				res.setAnimalKind(rs.getString("res_peto_animal_kinds"));
				res.setPetsNo(rs.getInt("res_pets_no"));
				res.setPrice(rs.getInt("res_price"));
				res.setAnimalNo(rs.getInt("res_animal_no"));
				res.setAccDny(rs.getString("res_acc_dny").charAt(0));
				res.setResNo(resNo);
				res.setRequest(rs.getString("res_request"));
				res.setPetoName(rs.getString("m_username"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return res;
	}

}
