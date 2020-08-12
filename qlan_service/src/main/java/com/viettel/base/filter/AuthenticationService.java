/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.base.filter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.viettel.qlan.business.UsersBusinessImpl;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.utils.DataUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;



/**
 *
 * @author hunglq9
 */
@Component
public class AuthenticationService {
	@Autowired
	UsersBusinessImpl usersBusinessImpl;
	
	public boolean veryfiToken(String jwt,UsersDTO obj){
		if (jwt != null) {
			try {
				UsersDTO usersDTO=getUserByUserName(jwt);
				if(null==usersDTO || null==usersDTO.getUserId()){
					return false;
				} 
				
				if(null!=obj && !obj.getPassword().equals(usersDTO.getPassword())){
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
		return true;
		
	}
	
	
	public  UsersDTO getUserByUserName(String jwt){
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary("QLAN"))
			       .parseClaimsJws(jwt).getBody();
		 if(null==claims){
			 return null;
		 }
		 String username = claims.getSubject();
		
		 
		 Date expirationTime = claims.getExpiration();
         if (expirationTime.compareTo(new Date()) < 0) {
             return null;
         }
		 
		if(StringUtils.isEmpty(username)){
			return null;
		}
	 UsersDTO	usersDTO =usersBusinessImpl.checkUserNameExit(username);
	 return usersDTO;
	}
	
	public  UsersDTO getUser(String jwt){
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary("QLAN"))
			       .parseClaimsJws(jwt).getBody();
		 if(null==claims){
			 return null;
		 }
		 String username = claims.getSubject();
		
		 
		 Date expirationTime = claims.getExpiration();
         if (expirationTime.compareTo(new Date()) < 0) {
             return null;
         }
		 
		if(StringUtils.isEmpty(username)){
			return null;
		}
		
	 UsersDTO	usersDTO =usersBusinessImpl.getUsersInfo(username);
	 return usersDTO;
	}
	
	
	

}
