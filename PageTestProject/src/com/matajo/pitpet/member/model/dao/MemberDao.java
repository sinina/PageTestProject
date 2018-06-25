package com.matajo.pitpet.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.MemberVo;

public class MemberDao {

	public MemberVo selectMember(Connection con, String userId) {
		MemberVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury="SELECT * FROM MEMBER WHERE M_USERID = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				result = new MemberVo();
				result.setPwd(rs.getString("m_password"));
				result.setAddress(rs.getString("m_address"));
				result.setAge(rs.getInt("m_age"));
				result.setCode(rs.getString("m_member_code").charAt(0));
				result.setEnrollDate(rs.getDate("m_enrolldate"));
				result.setGender(rs.getString("m_gender").charAt(0));
				result.setId(userId);
				result.setName(rs.getString("m_username"));
				result.setNo(rs.getInt("m_member_no"));
				result.setPhone(rs.getString("m_phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return result;
	}

	public int insertMember(Connection con, MemberVo member) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "INSERT INTO MEMBER VALUES(?, ?, ?, ? , ?, ?, ?, SYSDATE, DEFAULT, SEQ_MEMBER.NEXTVAL)";
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, String.valueOf(member.getGender()));
			pstmt.setInt(5,  member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
