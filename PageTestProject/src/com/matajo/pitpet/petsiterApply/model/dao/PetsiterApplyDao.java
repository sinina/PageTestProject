package com.matajo.pitpet.petsiterApply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo;

public class PetsiterApplyDao {

	public int insertApply(Connection con, PetsiterApplyVo apply) {
		PreparedStatement pstmt  = null;
		int result = 0;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO PETS_APPLY VALUES(SEQ_PETS_APPLY.NEXTVAL,?,?,?,?)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정 - ?의 갯수만큼
			pstmt.setString(1, apply.getJob());
			pstmt.setInt(2, apply.getMemberNo());
			pstmt.setString(3, apply.getInfo());
			pstmt.setString(4, apply.getLicense());
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 리턴
		return result;
	}

	public ArrayList<PetsiterApplyVo> selectMemberList(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PetsiterApplyVo> list = null;
		String query="";
		try {
			//쿼리 전송 객체 생성
			stmt = con.createStatement();
				query = "SELECT P.PETS_A_JOB, M.M_MEMBER_NO, P.PETS_A_INFO, P.PETS_A_LICENSE, M.M_USERID, M.M_USERNAME, M.M_PHONE "+"FROM PETS_APPLY P "
						+"JOIN MEMBER M ON(P.PETS_A_MEMBER_NO= M.M_MEMBER_NO) WHERE M.M_MEMBER_CODE NOT IN 2";
			//쿼리 실행
			rs = stmt.executeQuery(query);
			
			//결과 처리(resultset)
			//rs를 list로 파싱
			list= new ArrayList<PetsiterApplyVo>();
			PetsiterApplyVo temp=null;
			
			while(rs.next()){
				temp=new PetsiterApplyVo();
				
				temp.setMemberNo(rs.getInt("m_member_no"));
				temp.setMemberId(rs.getString("m_userid"));
				temp.setMemberName(rs.getString("m_username"));
				temp.setPhone(rs.getString("m_phone"));
				temp.setJob(rs.getString("pets_a_job"));;
				temp.setLicense(rs.getString("pets_a_license"));
				temp.setInfo(rs.getString("pets_a_info"));
				
				list.add(temp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
			
			System.out.println(query);
		}
		return list;
	}

}
