package com.matajo.pitpet.notify.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.matajo.pitpet.board.model.vo.BoardVo;
import com.matajo.pitpet.common.JDBCTemplate;

public class BoardDao {
	
	public ArrayList<BoardVo> selectBoardList(Connection con){
		ArrayList<BoardVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			//2. 쿼리 작성
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
						+ "FROM BOARD B, MEMBER M "
						+ "WHERE B.BWRITER = M.USERID "
						+ "ORDER BY BNO DESC ";
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				temp.setPlace(rs.getString("bcontent"));
				temp.setSitterName(rs.getString("bwriter"));
				temp.setInfo(rs.getString("username"));
				temp.setPrice(rs.getInt("bcount"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setImage(rs.getString("boardfile"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		//6. 결과 리턴
		return list;
	}
	

}
