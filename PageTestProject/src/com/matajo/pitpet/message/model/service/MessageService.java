package com.matajo.pitpet.message.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

	public int updateMsg(int messageNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MessageDao().updateMessage(con, messageNo);
		if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public List<MessageVo> getMessageList(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<MessageVo> list = new MessageDao().selectMessageList(con,memberNo);
		JDBCTemplate.close(con);
		return list;
	}

	public MessageVo getMessageFlag(int memberNo) {
		Connection con = JDBCTemplate.getConnection();
		MessageVo count = new MessageDao().selectMessageFlag(con, memberNo);
		if(count!=null){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return count;
	}

	public int deleteMsg(int messageNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new MessageDao().deleteMessage(con, messageNo);
		if (0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}
}
