package com.matajo.pitpet.member.model.service;

import java.sql.Connection;
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
	public MemberVo searchMember(String name) {
		Connection con = JDBCTemplate.getConnection();
		MemberVo member = new MemberDao().selectSearchMember(con,name);
		JDBCTemplate.close(con);
		return member;
	}
	
	public int insertMember(MemberVo member) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(con, member);
		System.out.println(result);
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


}
