package com.matajo.pitpet.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection(){
		Connection con = null;
		try {
			//properties로 설정 정보를 분리
			String filePath 
					= JDBCTemplate.class.getResource("/oracleDriver.properties").getPath();
			Properties prop = new Properties();
			prop.load(new FileReader(filePath));
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	} 
	
	public static void close(Connection con){
		try {
			//커넥션이 null일 경우 close 호출 시 nullpointexception이 발생
			//이미 close 상태에서 close 요청 할 경우 sqlexception이 발생
			if(con != null && !con.isClosed()){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			if(stmt != null && !stmt.isClosed()){
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt){
			try {
				if(pstmt != null && !pstmt.isClosed()){
				pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs){
		try {
			if(rs != null && !rs.isClosed()){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con){
		try {
			if(con != null && !con.isClosed()){
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con){
		try {
			if(con != null && !con.isClosed()){
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}










