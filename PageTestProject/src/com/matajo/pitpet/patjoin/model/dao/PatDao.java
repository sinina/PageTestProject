package com.matajo.pitpet.patjoin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

public class PatDao {

	public int insertPat(Connection con, PatVo pat) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
	
		query = "INSERT INTO PET_INFO VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SEQ_PET_INFO.NEXTVAL)";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pat.getPatName());
			pstmt.setString(2, pat.getPatkg());
			pstmt.setString(3, pat.getPatImage());
			pstmt.setString(4, pat.getKinds());
			pstmt.setString(5, pat.getKinds_of());
			pstmt.setInt(6, pat.getPatage());
			pstmt.setString(7, pat.getPatInfo());
			pstmt.setInt(8, pat.getOwner_no());//회원확인
			pstmt.setString(9, String.valueOf(pat.getPatgender()));//성별
			pstmt.setString(10, String.valueOf(pat.getOperation()));//중성화여부
			pstmt.setString(11, pat.getUniquness());
			pstmt.setString(12, pat.getHospital());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updatePat(Connection con, PatVo pat) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "UPDATE PET_INFO SET P_NAME = ?, P_WEIGHT=?, P_IMAGE =?, P_KINDS=?, P_KINDS_OF=?, P_AGE=?, P_INFO=?, P_OWNER_NO=?, P_GENDER=?, P_NE_OPERATION=?, P_UNIQUENESS=?, P_HOSPITAL=?, P_NO=SEQ_PET_INFO.NEXTVAL; ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pat.getPatName());
			pstmt.setString(2, pat.getPatkg());
			pstmt.setString(3, pat.getPatImage());
			pstmt.setString(4, pat.getKinds());
			pstmt.setString(5, pat.getKinds_of());
			pstmt.setInt(6, pat.getPatage());
			pstmt.setString(7, pat.getPatInfo());
			pstmt.setInt(8, pat.getOwner_no());//회원확인
			pstmt.setString(9, String.valueOf(pat.getPatgender()));//성별
			pstmt.setString(10, String.valueOf(pat.getOperation()));//중성화여부
			pstmt.setString(11, pat.getUniquness());
			pstmt.setString(12, pat.getHospital());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int earlsePat(Connection con, int id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "DELETE FROM PET_INFO WHERE P_OWNER_NO= ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public PatVo SelectPat(Connection con, String patNo) {
		PreparedStatement pstmt = null;
		PatVo pat = null;
		String query = "";
		ResultSet rs = null;
		
		query = "SELECT P_NAME, P_WEIGHT, P_IMAGE, P_KINDS, P_KINDS_OF, P_AGE, P_INFO, P_OWNER_NO, P_GENDER, P_NE_OPERATION, P_UNIQUENESS, P_HOSPITAL, P_NO"
				+ " FROM PET_INFO"
				+ " JOIN MEMBER ON (P_OWNER_NO = M_MEMBER_NO)"
				+ " WHERE M_USERID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, patNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pat = new PatVo();
				pat.setPatName(rs.getString("P_NAME"));
				pat.setPatkg(rs.getString("P_WEIGHT"));
				pat.setPatImage(rs.getString("P_IMAGE"));
				pat.setKinds(rs.getString("P_KINDS"));
				pat.setKinds_of(rs.getString("P_KINDS_OF"));
				pat.setPatage(rs.getInt("P_AGE"));
				pat.setPatInfo(rs.getString("P_INFO"));
				pat.setOwner_no(rs.getInt("P_OWNER_NO"));
				pat.setPatgender(rs.getString("P_GENDER").charAt(0));
				pat.setOperation(rs.getString("P_NE_OPERATION").charAt(0));
				pat.setUniquness(rs.getString("P_UNIQUENESS"));
				pat.setHospital(rs.getString("P_HOSPITAL"));
				pat.setNo(rs.getInt("P_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return pat;
	}

	public PatVo patSelect(Connection con, String id) {
		PreparedStatement pstmt = null;
		PatVo pat = null;
		String query = "";
		ResultSet rs = null;
		
		query = "SELECT P_NAME, P_WEIGHT, P_IMAGE, P_KINDS, P_KINDS_OF, P_AGE, P_INFO, P_OWNER_NO, P_GENDER, P_NE_OPERATION, P_UNIQUENESS, P_HOSPITAL, P_NO"
				+ " FROM PET_INFO"
				+ " JOIN MEMBER ON (P_OWNER_NO = M_MEMBER_NO)"
				+ " WHERE M_USERID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pat = new PatVo();
				pat.setPatName(rs.getString("P_NAME"));
				pat.setPatkg(rs.getString("P_WEIGHT"));
				pat.setPatImage(rs.getString("P_IMAGE"));
				pat.setKinds(rs.getString("P_KINDS"));
				pat.setKinds_of(rs.getString("P_KINDS_OF"));
				pat.setPatage(rs.getInt("P_AGE"));
				pat.setPatInfo(rs.getString("P_INFO"));
				pat.setOwner_no(rs.getInt("P_OWNER_NO"));
				pat.setPatgender(rs.getString("P_GENDER").charAt(0));
				pat.setOperation(rs.getString("P_NE_OPERATION").charAt(0));
				pat.setUniquness(rs.getString("P_UNIQUENESS"));
				pat.setHospital(rs.getString("P_HOSPITAL"));
				pat.setNo(rs.getInt("P_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return pat;
	}
}