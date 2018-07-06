package com.matajo.pitpet.visitCounter.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.visitCounter.model.vo.VisitCountVo;

public class VisitCountDao {
	
	public int setTotalCount(Connection con) {
		//총방문자수 증가시키는 메소드
		int result = 0;
		Statement stmt = null;
		String query = "";
				
			try {
				//1. 쿼리 전송 객체 생성
				stmt= con.createStatement();
				//2. 쿼리 작성
				query= "INSERT INTO VISITCOUNT (VISITDATE) VALUES (SYSDATE)";
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
			query="SELECT COUNT(*) AS TOTALCNT FROM VISITCOUNT";
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
			query="SELECT COUNT(*) AS TODAYCNT FROM VISITCOUNT WHERE TO_DATE(VISITDATE, 'YYYY-MM-DD') = TO_DATE(SYSDATE, 'YYYY-MM-DD')";
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

	public ArrayList<VisitCountVo> selectMonthCount(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<VisitCountVo> list = null;
		String query="";
		
		try {
			query="SELECT TO_CHAR(VISITDATE,'MM') AS \"MONTH\", COUNT(*) AS \"COUNT\" FROM VISITCOUNT "
					+ "WHERE TO_CHAR(VISITDATE, 'YYYY') = TO_CHAR(SYSDATE, 'YYYY') "
					+ "GROUP BY TO_CHAR(VISITDATE,'MM')";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			list= new ArrayList<VisitCountVo>();
			VisitCountVo temp = new VisitCountVo();
			while(rs.next()){
				if(Integer.parseInt(rs.getString("month"))==1){
					temp.setJan(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==2){
					temp.setFeb(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==3){
					temp.setMar(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==4){
					temp.setApr(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==5){
					temp.setMay(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==6){
					temp.setJun(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==7){
					temp.setJul(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==8){
					temp.setAug(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==9){
					temp.setSep(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==10){
					temp.setOut(rs.getInt("count"));
				}else if(Integer.parseInt(rs.getString("month"))==11){
					temp.setNov(rs.getInt("count"));
				}else{
					temp.setDec(rs.getInt("count"));
				}
			}
			list.add(temp);
			System.out.println(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	
	
	


	
	
}
