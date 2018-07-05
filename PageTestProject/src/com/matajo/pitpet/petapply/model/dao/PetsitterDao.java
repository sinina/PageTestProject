package com.matajo.pitpet.petapply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo;


public class PetsitterDao {

	public int insertPetsitterInfo(Connection con, PetsitterApplyVo petSitterInfo,ArrayList<String> list) {
		int result=0;
		String query="";
		PreparedStatement pstmt=null;
		
		try {
			query="INSERT INTO PETS_APPLY VALUES(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,DEFAULT,?,?,?,?,?, ?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,petSitterInfo.getNo());
			pstmt.setInt(2, petSitterInfo.getType());
			pstmt.setInt(3, petSitterInfo.getOpenarea());
			pstmt.setInt(4, petSitterInfo.getJobstyle());
			pstmt.setString(5, petSitterInfo.getAdComment());
			pstmt.setString(6, petSitterInfo.getOpportunity());
			pstmt.setString(7, petSitterInfo.getActivityHistory());
			pstmt.setInt(8,petSitterInfo.getLong_term());
			pstmt.setInt(9, petSitterInfo.getPickup());
			pstmt.setInt(10, petSitterInfo.getSitterCareer());
			
			pstmt.setString(11, petSitterInfo.getPetSize());
			pstmt.setString(12, petSitterInfo.getPetAge());
			pstmt.setInt(13, petSitterInfo.getAnimalCheck());
			pstmt.setInt(14, petSitterInfo.getAnimalCount());
			pstmt.setInt(15, petSitterInfo.getChild());
			pstmt.setInt(16, petSitterInfo.getCamera());
			pstmt.setInt(17, petSitterInfo.getDistance());
			pstmt.setString(18, petSitterInfo.getHospital());
			pstmt.setString(19, petSitterInfo.getHospitalPhoneNumber());
			pstmt.setInt(20, petSitterInfo.getOneDayCount());
			
			pstmt.setString(21, petSitterInfo.getBank());
			pstmt.setString(22, petSitterInfo.getBankName());
			pstmt.setString(23, petSitterInfo.getBankNumber());
			pstmt.setString(24, petSitterInfo.getPrContext());
			pstmt.setString(25, petSitterInfo.getLicense1());
			pstmt.setString(26, petSitterInfo.getLicense2());
			pstmt.setString(27, petSitterInfo.getLicense3());
			pstmt.setString(28, petSitterInfo.getLicense4());
			pstmt.setString(29, petSitterInfo.getPhoto1());
			pstmt.setString(30, petSitterInfo.getPhoto2());
			pstmt.setString(31, petSitterInfo.getPhoto3());
			pstmt.setString(32, petSitterInfo.getPhoto4());
			

			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
				
		return result;
	}

	
	//관리자페이지에서 펫시터신청자 리스트 불러올때 
	public ArrayList<PetsitterApplyVo> selectApplyList(Connection con, int okayN) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PetsitterApplyVo> list = null;
		String query="";
		
		try {
			query="SELECT P.P_NO, M.M_USERNAME, P.P_TYPE, P.P_ADCOMMENT FROM PETS_APPLY P JOIN MEMBER M ON(P.P_NO=M.M_MEMBER_NO) WHERE P.P_OKAY=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, okayN);
			rs=pstmt.executeQuery();
			
			list= new ArrayList<PetsitterApplyVo>();
			PetsitterApplyVo temp = null;
			while(rs.next()){
				temp =new PetsitterApplyVo();
				temp.setName(rs.getString("m_username"));
				temp.setType(rs.getInt("p_type"));
				temp.setAdComment(rs.getString("p_adcomment"));
				temp.setNo(rs.getInt("p_no"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}


	
	public int updateOkayN(Connection con, int memberNo,int selectNo) {
		int result=0;
		String query="";
		PreparedStatement pstmt=null;
		
		try {
			if(selectNo==1){
				query="UPDATE PETS_APPLY SET P_OKAY=1 WHERE P_NO=?";
			}else if(selectNo==2 ||selectNo==4){
				query="UPDATE PETS_APPLY SET P_OKAY=0 WHERE P_NO=?";
			}else{
				query="UPDATE PETS_APPLY SET P_OKAY=2 WHERE P_NO=?";
			}
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,memberNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
				
		return result;
	}


	public PetsitterApplyVo selectApplyDetail(Connection con, int memberNo) {
		PetsitterApplyVo apply = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = "SELECT P.* "
					+ "FROM PETS_APPLY P, MEMBER M "
					+ "WHERE P.P_NO = M.M_MEMBER_NO "
					+ " AND P_NO = ?";
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, memberNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				apply = new PetsitterApplyVo();
				apply.setNo(memberNo);
				apply.setType(rs.getInt("p_type"));
				apply.setOpenarea(rs.getInt("p_openarea"));
				apply.setJobstyle(rs.getInt("p_jobstyle"));
				apply.setAdComment(rs.getString("p_adcomment"));
				apply.setOpportunity(rs.getString("p_opportunity"));
				apply.setActivityHistory(rs.getString("p_activityhisotry"));
				apply.setLong_term(rs.getInt("p_long_term"));
				apply.setPickup(rs.getInt("p_pickup"));
				apply.setSitterCareer(rs.getInt("p_sittercareer"));
				apply.setPetSize(rs.getString("p_petsize"));
				apply.setPetAge(rs.getString("p_petage"));
				apply.setAnimalCheck(rs.getInt("p_animalcheck"));
				apply.setAnimalCount(rs.getInt("p_animalcount"));
				apply.setChild(rs.getInt("p_child"));
				apply.setCamera(rs.getInt("p_camera"));
				apply.setDistance(rs.getInt("p_distance"));
				apply.setHospital(rs.getString("p_hospital_name"));
				apply.setHospitalPhoneNumber(rs.getString("p_hospital_num"));
				apply.setOneDayCount(rs.getInt("p_onedaycount"));
				apply.setBank(rs.getString("p_bank"));
				apply.setBankNumber(rs.getString("p_banknumber"));
				apply.setBankName(rs.getString("p_bankname"));
				apply.setPrContext(rs.getString("p_prcontext"));
				apply.setLicense1(rs.getString("p_license1"));
				apply.setLicense2(rs.getString("p_license2"));
				apply.setLicense3(rs.getString("p_license3"));
				apply.setLicense4(rs.getString("p_license4"));
				apply.setPhoto1(rs.getString("p_photo1"));
				apply.setPhoto2(rs.getString("p_photo2"));
				apply.setPhoto3(rs.getString("p_photo3"));
				apply.setPhoto4(rs.getString("p_photo4"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 값 return
		return apply;
	}

}
