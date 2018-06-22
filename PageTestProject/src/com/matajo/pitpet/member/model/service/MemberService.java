package com.matajo.pitpet.member.model.service;

import java.sql.Connection;

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

}
