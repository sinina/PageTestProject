package com.matajo.pitpet.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			query = "P.PETS_P_NO, P.PETS_P_TYPE, P.PETS_P_TITLE, M.M_ADDRES, M.M_USERNAME, "
						+"P.PETS_P_INFO, P.PETS_P_PRICE, P.PETS_P_INTERV, P.PETS_P_IMAGE,"
				    	+"P.PETS_P_ANIMAL"
						+ "FROM PETS_POST P , MEMBER M "
						+ "WHERE M.USERID = P.PETS_P_MEMBER_NO "
						+ "ORDER BY P.NO DESC ";
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("post_no"));
				temp.setType(rs.getString("post_type"));
				temp.setTitle(rs.getString("title"));
				temp.setPlace(rs.getString("m_address"));
				temp.setSitterName(rs.getString("username"));
				temp.setInfo(rs.getString("pet_info"));
				temp.setPrice(rs.getInt("price"));
				temp.setInterv(rs.getString("interv"));
				temp.setImage(rs.getString("image"));
				temp.setAnimal(rs.getString("animal"));
				
				
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
	
	
	
	//
	
	
	
	
	
	
	
	public int insertBoard(Connection con, BoardVo board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO BOARD "
					+ "VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, DEFAULT, "
					+ " ?, DEFAULT, DEFAULT)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정
			pstmt.setString(1, board.getTitle());
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 리턴
		return result;
	}

	public BoardVo selectBoard(Connection con, int boardNo) {
		BoardVo board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM BOARD B, MEMBER M "
					+ "WHERE B.BWRITER = M.USERID "
					+ " AND BNO = ?";
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				board = new BoardVo();
				board.setTitle(rs.getString("BTITLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 값 return
		return board;
	}

	public int updateBoard(Connection con, BoardVo board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET BTITLE = ?, BCONTENT = ?, BOARDFILE = ? "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(4, board.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateBoardCount(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET BCOUNT = BCOUNT + 1 "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectBoardTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM BOARD "
						+ "WHERE DELFLAG != 'Y' ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<BoardVo> selectBoardListPage(Connection con, int currentPage, int limit) {
		ArrayList<BoardVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+						"   FROM BOARD B, MEMBER M "
					+						"   WHERE B.BWRITER = M.USERID "
					+						"   	AND B.DELFLAG = 'N' "
					+ 						"   ORDER BY BNO DESC) P) "
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int selectBoardTotalCountSearch(Connection con, int condition, String keyword) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM BOARD "
						+ "WHERE DELFLAG != 'Y' "
						+ " AND BTITLE LIKE '%" + keyword + "%'";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<BoardVo> selectBoardListPageSearch(Connection con, int currentPage, int limit, int condition,
			String keyword) {
		ArrayList<BoardVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+						"   FROM BOARD B, MEMBER M "
					+						"   WHERE B.BWRITER = M.USERID "
					+						"		AND B.BTITLE LIKE '%' || ? || '%' "	
					+ 						"   ORDER BY BNO DESC) P) "
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int deleteBoard(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET DELFLAG = 'Y' "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	public ArrayList<BoardVo> selectBoardList(Connection con, int postN) {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";

		try {
			query = "SELECT P.PETS_P_TITLE, P.PETS_P_NO, M.M_USERNAME "
					+"FROM PETS_POST P JOIN MEMBER M ON(P.PETS_P_MEMBER_NO=M.M_MEMBER_NO) "
					+"WHERE PETS_P_TYPE=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, postN);
			rs= pstmt.executeQuery();
			
			BoardVo temp =null;
			while(rs.next()){
				temp= new BoardVo();
				temp.setNo(rs.getInt("PETS_P_NO"));
				temp.setTitle(rs.getString("PETS_P_TITLE"));
				temp.setSitterName(rs.getString("M_USERNAME"));
				/*int no = rs.getInt("PETS_P_NO");
				String title = rs.getString("PETS_P_TITLE");
				String sitterName =rs.getString("M_USERNAME");*/
				
				list.add(temp);
			}
			System.out.println(temp);
			System.out.println(list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	
}
	


