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
		String qeury="SELECT M_USERID ,M_PASSWORD ,M_USERNAME ,M_GENDER ,M_AGE ,M_PHONE ,M_ADDRESS ,M_ENROLLDATE ,M_MEMBER_CODE ,M_MEMBER_NO, NVL((select p_okay from member m join pets_apply p on((select m_member_no from member where m_userid=?)=p.p_no)where m_member_code = '1'),5) as p_no  FROM MEMBER where  M_USERID = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
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
				result.setP_okay(rs.getInt("p_no"));
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

	//관리자가 펫시터 신청자 승인할때
	public int updateMember(Connection con, int memberNo, int selectNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		
		
		if(selectNo==1){
			query = "UPDATE MEMBER SET M_MEMBER_CODE='2' WHERE M_MEMBER_NO=?";
		}else {
			//selectNo==2 는 승인취소 
			query = "UPDATE MEMBER SET M_MEMBER_CODE='1' WHERE M_MEMBER_NO=?";
		}
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

	public MemberVo selectSearchMember(Connection con, String name) {
		MemberVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury="SELECT * FROM MEMBER WHERE M_USERNAME = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new MemberVo();
				result.setPwd(rs.getString("m_password"));
				result.setAddress(rs.getString("m_address"));
				result.setAge(rs.getInt("m_age"));
				result.setCode(rs.getString("m_member_code").charAt(0));
				result.setEnrollDate(rs.getDate("m_enrolldate"));
				result.setGender(rs.getString("m_gender").charAt(0));
				result.setId(rs.getString("m_userid"));
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

	public int updateMember(Connection con, String id, String tempPass) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE MEMBER SET M_PASSWORD=? WHERE M_USERID=? ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,tempPass);
			pstmt.setString(2,id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int updatepassMember(Connection con, MemberVo member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE MEMBER SET M_USERID= ?, M_PASSWORD=?, M_USERNAME=?, M_GENDER=?, M_AGE=?, M_PHONE=?, M_ADDRESS=?, M_ENROLLDATE=SYSDATE, M_MEMBER_CODE=DEFAULT WHERE M_USERID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, String.valueOf(member.getGender()));
			pstmt.setInt(5, member.getAge());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int MemberDelete(Connection con, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		query = "DELETE FROM MEMBER WHERE M_USERID='"+id+"'";
		
		try {
			pstmt = con.prepareStatement(query);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo selectMemberInfo(Connection con, int memberNo) {
		MemberVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury="SELECT * FROM MEMBER WHERE M_MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setInt(1,memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new MemberVo();
				result.setId(rs.getString("m_userid"));
				result.setPwd(rs.getString("m_password"));
				result.setAddress(rs.getString("m_address"));
				result.setAge(rs.getInt("m_age"));
				result.setCode(rs.getString("m_member_code").charAt(0));
				result.setGender(rs.getString("m_gender").charAt(0));
				result.setName(rs.getString("m_username"));
				result.setPhone(rs.getString("m_phone"));
				result.setNo(rs.getInt("m_member_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateMemberInfo(Connection con, MemberVo mv) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE MEMBER SET M_USERID= ?, M_PASSWORD=?, M_USERNAME=?, M_GENDER=?, M_AGE=?, M_PHONE=?, M_ADDRESS=? WHERE M_MEMBER_NO = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, mv.getId());
			pstmt.setString(2, mv.getPwd());
			pstmt.setString(3, mv.getName());
			pstmt.setString(4, String.valueOf(mv.getGender()));
			pstmt.setInt(5, mv.getAge());
			pstmt.setString(6, mv.getPhone());
			pstmt.setString(7, mv.getAddress());
			pstmt.setInt(8, mv.getNo());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo SelectPass(Connection con, String id, String pwd) {
		MemberVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury="SELECT * FROM MEMBER WHERE M_USERID = ? AND M_PASSWORD = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new MemberVo();
				result.setPwd(rs.getString("m_password"));
				result.setAddress(rs.getString("m_address"));
				result.setAge(rs.getInt("m_age"));
				result.setCode(rs.getString("m_member_code").charAt(0));
				result.setEnrollDate(rs.getDate("m_enrolldate"));
				result.setGender(rs.getString("m_gender").charAt(0));
				result.setId(id);
				result.setName(rs.getString("m_username"));
				result.setNo(rs.getInt("m_member_no"));
				result.setPhone(rs.getString("m_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}

	public MemberVo SelectPhone(Connection con, String phone) {
		MemberVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury="SELECT * FROM MEMBER WHERE M_PHONE = ?";
		
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = new MemberVo();
				result.setPwd(rs.getString("m_password"));
				result.setAddress(rs.getString("m_address"));
				result.setAge(rs.getInt("m_age"));
				result.setCode(rs.getString("m_member_code").charAt(0));
				result.setEnrollDate(rs.getDate("m_enrolldate"));
				result.setGender(rs.getString("m_gender").charAt(0));
				result.setId(rs.getString("m_userid"));
				result.setName(rs.getString("m_username"));
				result.setNo(rs.getInt("m_member_no"));
				result.setPhone(rs.getString("m_phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}
}

