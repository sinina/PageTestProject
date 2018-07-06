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
		
		if(msgCode==0){
			query= "SELECT  SUBSTR(R.RES_START_TIME,1,14),  SUBSTR(R.RES_END_TIME,1,14), R.RES_PETO_ANIMAL_KINDS, "
					+ "R.RES_PRICE, M2.M_USERNAME, R.RES_REQUEST  "
					+ "FROM RESERVATION R INNER JOIN MESSAGE M1 ON(R.RES_PETO_NO=M1.MES_SENDER_NO)"
					+ "INNER JOIN MEMBER M2 ON(R.RES_PETO_NO=M2.M_MEMBER_NO) "
					+ "WHERE M1.MES_CODE=("
					+ "SELECT MES_CODE FROM MESSAGE "
					+ "WHERE MES_MSG_NO=?)";
		}else{
			query="SELECT SUBSTR(R.RES_START_TIME,1,14),  SUBSTR(R.RES_END_TIME,1,14), R.RES_PETO_ANIMAL_KINDS, "
					+ "R.RES_PRICE, M2.M_USERNAME, R.RES_REQUEST "
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return res;
	}

	public int updqteAccDny(Connection con, int resNo, int accDny) {
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
		}
		
		return result;
	}

}
