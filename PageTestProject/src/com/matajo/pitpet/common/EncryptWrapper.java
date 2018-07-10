package com.matajo.pitpet.common;

import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name){
		String result = null;
		if(name != null && "userPwd".equals(name)){
			result = getSha512(super.getParameter(name));
		}else{
			result = super.getParameter(name);
		}
		return result;
	}
	private String getSha512(String pwd){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes("UTF-8");
			md.update(bytes);
			return Base64.getEncoder().encodeToString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}








