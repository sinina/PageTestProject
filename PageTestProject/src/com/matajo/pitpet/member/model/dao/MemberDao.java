package com.matajo.pitpet.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public ArrayList<MemberVo> selectMemberList(Connection con, int selectNo) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = null;
		String query="";
		try {
			//쿼리 전송 객체 생성
			stmt = con.createStatement();
			if(selectNo == 1){
				query = "SELECT * FROM MEMBER WHERE M_MEMBER_CODE=1";
			}else{
				query = "SELECT * FROM MEMBER WHERE M_MEMBER_CODE=2";
			}
			
			//쿼리 실행
			rs = stmt.executeQuery(query);
			
			//결과 처리(resultset)
			//rs를 list로 파싱
			list= new ArrayList<MemberVo>();
			MemberVo temp=null;
			
			while(rs.next()){
				temp=new MemberVo();
				
				System.out.println("test");
				temp.setNo(rs.getInt("m_member_no")) ;
				temp.setId(rs.getString("m_userid"));
				temp.setName(rs.getString("m_username"));
				temp.setGender(rs.getString("m_gender").charAt(0));
				temp.setAge(rs.getInt("m_age"));
				temp.setPhone(rs.getString("m_phone"));
				temp.setEnrollDate(rs.getDate("m_enrolldate"));
				
				list.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
			
			System.out.println(query);
		}
		return list;
	}


	public int deleteMember(Connection con, int memberNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "DELETE FROM MEMBER WHERE M_MEMBER_NO=?";
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection con, int memberNo, int selectNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		query = "UPDATE MEMBER SET M_MEMBER_CODE='2' WHERE M_MEMBER_NO=?";
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1,memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


}
