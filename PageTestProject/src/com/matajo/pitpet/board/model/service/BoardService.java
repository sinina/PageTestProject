package com.matajo.pitpet.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.matajo.pitpet.board.model.dao.BoardDao;
import com.matajo.pitpet.board.model.vo.BoardVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class BoardService {

	public ArrayList<BoardVo> selectBoardList(){
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		ArrayList<BoardVo> list = new BoardDao().selectBoardList(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return list;
	}
	
	
	
	
}
