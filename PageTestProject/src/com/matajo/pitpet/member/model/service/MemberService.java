package com.matajo.pitpet.member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.dao.MemberDao;
import com.matajo.pitpet.member.model.vo.MemberVo;

public class MemberService {

	public MemberVo selectMember(String userId) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo member = new MemberDao().selectMember(con,userId);
		JDBCTemplate.close(con);
		return member;
	}
	public MemberVo searchMember(String userPhone) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo member = new MemberDao().selectSearchMember(con,userPhone);
		JDBCTemplate.close(con);
		return member;
	}
	
	public int insertMember(MemberVo member) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(con, member);
		//결과 처리(트랜젝션)
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//자원 반납
		JDBCTemplate.close(con);
		//결과 return
		return result;
	}

	//관리자에서 회원 리스트 가져올때
	public List<MemberVo> getMemberList(int selectNo) {
		//커넥션을 맺는 역할 -> 서비스 
				//	-> 트랜젝션 관리를 해야 하기 때문에
				Connection con = JDBCTemplate.getConnection();
				ArrayList<MemberVo> list = new MemberDao().selectMemberList(con,selectNo);
				JDBCTemplate.close(con);
				return list;
	}

	//관리자에서 회원 탈퇴 시킬때
	public int deleteMember(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(con, memberNo);
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public int updateMember(int memberNo, int selectNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(con, memberNo,selectNo);
		int result1 = 0;
		int result2=0;
		PreparedStatement pstmt = null;
		String query = "";
		
		if(selectNo == 1){
			
			query="INSERT INTO PETSIT_INFO(P_I_NO, P_I_LEVEL, P_I_UP) "
					+ "VALUES ((SELECT M_MEMBER_NO FROM MEMBER WHERE M_MEMBER_NO=?),"
					+ "DEFAULT,SYSDATE)";
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1,memberNo);
				
				result1 = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCTemplate.close(pstmt);
			}
			
			if(result1>0){
				JDBCTemplate.commit(con);
			}else{
				JDBCTemplate.rollback(con);
			}
		}else if(selectNo==2){
			query="DELETE FROM PETSIT_INFO WHERE P_I_NO=?";
			try {
				pstmt = con.prepareStatement(query);
				
				pstmt.setInt(1,memberNo);
				
				result2 = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCTemplate.close(pstmt);
			}
			
			if(result2>0){
				JDBCTemplate.commit(con);
			}else{
				JDBCTemplate.rollback(con);
			}
		}
		
		
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		
		return result;
	}

	
	public int updatePass(String id, String tempPass) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(con, id,tempPass);
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}
	

	public int MemberDelete(String id) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().MemberDelete(con, id);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}
	
	
	public MemberVo selectMemberInfo(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo mv = new MemberDao().selectMemberInfo(con,memberNo);
		JDBCTemplate.close(con);
		return mv;
	}
	public int updateMemberInfo(MemberVo mv) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMemberInfo(con,mv);
		if(0<result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}
	public MemberVo selectPass(String id, String pwd) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo member = new MemberDao().SelectPass(con,id, pwd);
		JDBCTemplate.close(con);
		return member;
	}
	public int UpdateMember(MemberVo member) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().updatepassMember(con, member);
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}
	public MemberVo selectPhone(String phone) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo member = new MemberDao().SelectPhone(con, phone);
		JDBCTemplate.close(con);
		return member;
	}


}

