package com.viettel.qlan.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.viettel.base.common.BusinessException;
import com.viettel.base.common.ResponseMessage;
import com.viettel.qlan.rest.AbstractRsService;

@Provider
@Component
public class BusinessExceptionMapper extends AbstractRsService implements ExceptionMapper<Exception> {

	private Logger LOGGER =Logger.getLogger("LogLoi");;
	@Override
	public Response toResponse(Exception exception) {
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
		ResponseMessage rm;
		LOGGER.error(exception.getMessage(),exception);
		if (exception instanceof BusinessException){
			httpStatus = Response.Status.BAD_REQUEST;	
			rm=new ResponseMessage((BusinessException)exception);
		}else{
			rm = new ResponseMessage(httpStatus);
		}
		return Response.status(httpStatus)
                .entity(rm)
                .type(MediaType.APPLICATION_JSON).build();
	}

}
