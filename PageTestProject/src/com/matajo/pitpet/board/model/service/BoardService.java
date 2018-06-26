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
	
	public int insertBoard(BoardVo board) {
		Connection con = JDBCTemplate.getConnection();
		int result = new BoardDao().insertBoard(con, board);
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		return result;
	}

	public BoardVo selectBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardVo board = new BoardDao().selectBoard(con, boardNo);
		//조회 수 조회수 1증가
		if(null != board){
			int result = new BoardDao().updateBoardCount(con, boardNo);
			if(0 < result){
				JDBCTemplate.commit(con);
			}else{
				JDBCTemplate.rollback(con);
			}
		}
		JDBCTemplate.close(con);
		return board;
	}

	public BoardVo selectBoardForm(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardVo board = new BoardDao().selectBoard(con, boardNo);
		JDBCTemplate.close(con);
		return board;
	}

	public int updateBoard(BoardVo board) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new BoardDao().updateBoard(con, board);
		
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
	}

	public int selectBoardTotalCount() {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new BoardDao().selectBoardTotalCount(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<BoardVo> selectBoardListPage(int currentPage, int limit) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<BoardVo> list 
				= new BoardDao().selectBoardListPage(con, currentPage, limit);
		JDBCTemplate.close(con);
		return list;
	}

	public int selectBoardTotalCountSearch(int condition, String keyword) {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new BoardDao().selectBoardTotalCountSearch(con, condition, keyword);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<BoardVo> selectBoardListPageSearch(int currentPage, int limit, int condition, String keyword) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<BoardVo> list 
				= new BoardDao().selectBoardListPageSearch(con, currentPage, limit, condition, keyword);
		JDBCTemplate.close(con);
		return list;
	}

	public int deleteBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new BoardDao().deleteBoard(con, boardNo);
		
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
		
	}
}
	
	
	
	

