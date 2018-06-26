package com.matajo.pitpet.message.model.service;

import java.sql.Connection;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.message.model.dao.MessageDao;
import com.matajo.pitpet.message.model.vo.MessageVo;

public class MessageService {
	public int writeMsg(MessageVo message) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MessageDao().insertMessage(con, message);
		if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public int updateMsg(int msgNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MessageDao().updateMessage(con, msgNo);
		if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}
}
