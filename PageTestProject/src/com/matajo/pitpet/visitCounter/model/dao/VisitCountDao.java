package com.matajo.pitpet.visitCounter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.matajo.pitpet.common.JDBCTemplate;

public class VisitCountDao {
	
private static VisitCountDao instance;
	
	/*// 싱글톤 패턴
	private VisitCountDao(){}
	
	public static VisitCountDao getInstance(){
		if(instance==null)
			instance=new VisitCountDao();
		return instance;
	}*/
	
	public int setTotalCount(Connection con) {
		//총방문자수 증가시키는 메소드
		int result = 0;
		Statement stmt = null;
		String query = "";
				
			try {
				//1. 쿼리 전송 객체 생성
				stmt= con.createStatement();
				//2. 쿼리 작성
				query= "insert into visitCount (visitDate) values (sysdate)";
				//3. 쿼리 실행
				result = stmt.executeUpdate(query);
				//4. 결과 처리
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//5. 자원반납
				JDBCTemplate.close(stmt);
			}
		//6. 결과 리턴
		return result;
	}
	
	public int getTotalCount(Connection con){
		//총방문자수 가져오는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int result =0;
		String query ="";
		try {
			stmt= con.createStatement();
			query="SELECT COUNT(*) AS TotalCnt FROM VISIT";
			rs= stmt.executeQuery(query);
			
			if(rs.next()){
				result = rs.getInt("TotalCnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
		
		
	}
	
	public int getTodayCount(Connection con){
		//오늘 방문자수 가져오는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		int result =0;
		String query ="";
		try {
			stmt= con.createStatement();
			query="SELECT COUNT(*) AS TodayCnt FROM VISIT WHERE TO_DATE(visitDate, 'YYYY-MM-DD') = TO_DATE(sysdate, 'YYYY-MM-DD')";
			rs= stmt.executeQuery(query);
			
			if(rs.next()){
				result = rs.getInt("TodayCnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
		
	}
	
	
	
	
	
	/*
	public int getCount1(){
		//1월 방문자수 가져오는 메소드 쿼리문에 조건 1월
	}
	*/


	
	
}
