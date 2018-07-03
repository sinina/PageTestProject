package com.matajo.pitpet.reservation.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

public class ReservationDao {

	public ArrayList<ReservationVo> selectReservation(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReservationVo> list = null;
		String query="";
		
		try {
			query="SELECT TO_CHAR(R.RES_START_TIME,'YYYY-MM-DD HH24:MI:SS') AS \"START\", "
					+ "TO_CHAR(R.RES_END_TIME,'YYYY-MM-DD HH24:MI:SS') AS \"END\", M.M_USERNAME"
					+" FROM RESERVATION R, MEMBER M WHERE RES_ACC_DNY=1 AND M.M_MEMBER_NO=R.RES_PETO_NO";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			list= new ArrayList<ReservationVo>();
			ReservationVo temp=null;
			
			while(rs.next()){
				temp= new ReservationVo();
				temp.setTitle(rs.getString("M_USERNAME"));
				temp.setStart(rs.getString("START"));
				temp.setEnd(rs.getString("END"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
