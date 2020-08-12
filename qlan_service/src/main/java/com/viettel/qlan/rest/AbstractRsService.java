package com.viettel.qlan.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import com.viettel.base.common.BusinessException;
import com.viettel.qlan.filter.session.UserSession;

public abstract class AbstractRsService {
	@Context HttpServletRequest request;
	protected static final String USER_SESSION_KEY="USER_SESSION_KEY";
	protected static final String VSA_USER_TOKEN_KEY="VSA_USER_TOKEN_KEY";
	public UserSession getUserSession(){
		UserSession s=(UserSession)request.getSession().getAttribute(USER_SESSION_KEY);
		if(s==null){
			throw new BusinessException("user is not authen");
		}
		return s;
		
	}
	
}
