package com.matajo.pitpet.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.admin.model.vo.MatchingVo;
import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.visitCounter.model.vo.VisitCountVo;

public class MatchingDao {

	public ArrayList<MatchingVo> selectMatchingCount(Connection con) {
		ArrayList<MatchingVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query="";
		
		//최근 한달간 예약 요청/승인/거절 카운트 
		query="SELECT COUNT(MES_CODE), MES_CODE FROM MESSAGE "
				+ "WHERE MES_ENROLLDATE>=(SELECT TO_CHAR(ADD_MONTHS(SYSDATE,-1),'YYYY-MM-DD')FROM DUAL) "
				+ "GROUP BY MES_CODE";
		try {
			pstmt= con.prepareStatement(query);
			rs= pstmt.executeQuery();
			
			list = new ArrayList<MatchingVo>();
			MatchingVo temp = new MatchingVo();
			
			while(rs.next()){
				temp.setDate1("최근 한달");
				if(rs.getInt("mes_code")==0){
					temp.setRes(rs.getInt("count(mes_code)"));
				}else if(rs.getInt("mes_code")==1){
					temp.setResC(rs.getInt("count(mes_code)"));
				}else if(rs.getInt("mes_code")==2){
					temp.setResR(rs.getInt("count(mes_code)"));
				}else{
					temp.setPay(rs.getInt("count(mes_code)"));
				}
				
			}
			list.add(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

}
