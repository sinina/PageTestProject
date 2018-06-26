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

	public List<MemberVo> getMemberList(int selectNo) {
		//커넥션을 맺는 역할 -> 서비스 
				//	-> 트랜젝션 관리를 해야 하기 때문에
				Connection con = JDBCTemplate.getConnection();
				ArrayList<MemberVo> list = new MemberDao().selectMemberList(con,selectNo);
				JDBCTemplate.close(con);
				return list;
	}

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


}
