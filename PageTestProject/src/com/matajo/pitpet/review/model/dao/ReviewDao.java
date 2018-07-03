package com.matajo.pitpet.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.matajo.pitpet.board.model.vo.BoardVo;
import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.review.model.vo.ReviewVo;

public class ReviewDao {

		public ArrayList<ReviewVo> selectReviewList(Connection con) {
			ArrayList<ReviewVo> list = null;
			Statement stmt = null;
			ResultSet rs = null;
			String query = "";
			try {
				//1. 쿼리 전송 객체 생성
				stmt = con.createStatement();
				//2. 리뷰 게시글 찾는 쿼리 작성
				query = "SELECT REV_NO, INFO, MEMBERNO, NCOUNT, NDATE, USERNAME " + "FROM REVPOSTS "
						+ "JOIN MEMBER ON (MEMBERNO = MEMBERNO) " + "WHERE POST_TYPE='2'";
				//3. 쿼리 실행
				rs = stmt.executeQuery(query);
				//4. 결과 처리(resultSet-list parsing)
				list = new ArrayList<ReviewVo>();
				ReviewVo temp = null;
				while(rs.next()){
				/*	temp = new ReviewVo();
					temp.setReviewNo(rs.getInt("rev_no"));
					temp.setName(rs.getString("userName"));
					temp.setInfo(rs.getString("info"));
					temp.setGrdnum(rs.getInt("grdnum"));*/
					
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

		public ArrayList<ReviewVo> selectReviewList(Connection con, int postN) {
			ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String query = "";

			try {
				query = "SELECT R.R_POST_NO, M.M_USERNAME, R.R_POST_ENROLLDATE "
						+"FROM REV_POST R JOIN MEMBER M ON(R.R_POST_MEMBER_NO=M.M_MEMBER_NO) "
						+"WHERE R_POST_TYPE=?";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, postN);
				rs= pstmt.executeQuery();
				
				ReviewVo temp =null;
				while(rs.next()){
					temp= new ReviewVo();
					temp.setNo(rs.getInt("R_POST_NO"));
					temp.setMemberName(rs.getString("M_USERNAME"));
					temp.setEnrollDate(rs.getDate("R_POST_ENROLLDATE"));
					
					list.add(temp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JDBCTemplate.close(rs);
				JDBCTemplate.close(pstmt);
			}
			
			return list;
		}

}
