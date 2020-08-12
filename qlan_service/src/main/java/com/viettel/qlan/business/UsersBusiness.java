package com.viettel.qlan.business;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;

import com.viettel.qlan.dto.LoginDTO;
import com.viettel.qlan.dto.ResultDTO;
import com.viettel.qlan.dto.UsersDTO;

public interface UsersBusiness {

	UsersDTO getUsersInfo(String userName);
	
	ResultDTO login(String userName, String password,HttpServletRequest request) throws Exception;

	ResultDTO changePassword(LoginDTO loginDTO) throws Exception;
}
