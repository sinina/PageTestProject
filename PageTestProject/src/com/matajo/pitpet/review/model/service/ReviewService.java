package com.matajo.pitpet.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.matajo.pitpet.board.model.dao.BoardDao;
import com.matajo.pitpet.board.model.vo.BoardVo;
import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.review.model.dao.ReviewDao;
import com.matajo.pitpet.review.model.vo.ReviewVo;

public class ReviewService {

	public ArrayList<ReviewVo> selectReviewList() {
		// 1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		// 2. dao 메소드 호출
		ArrayList<ReviewVo> list = new ReviewDao().selectReviewList(con);
		// 3. 자원 반납(close)
		JDBCTemplate.close(con);
		// 4. 해당 결과 리턴
		return list;
	}

	//관리자가 후기글 불러올때
	public List<ReviewVo> getReviewList(int postN) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReviewVo> list = new ReviewDao().selectReviewList(con,postN);
		JDBCTemplate.close(con);
		return list;
	}

}
