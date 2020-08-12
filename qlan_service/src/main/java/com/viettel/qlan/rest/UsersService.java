package com.viettel.qlan.rest;


import com.viettel.qlan.dto.AreaDTO;
import com.viettel.qlan.dto.LoginDTO;
import com.viettel.qlan.dto.UsersDTO;
import com.viettel.qlan.dto.ResultDTO;
import com.viettel.qlan.dto.UsersDTO;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface UsersService   {

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response login(LoginDTO loginDTO) throws Exception;

	
	@GET
	@Path("/logout")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void logout();

	@POST
	@Path("/changePassword")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response changePassword(LoginDTO loginDTO) throws Exception;
	
	
	@POST
    @Path("/users/doSearch")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response doSearch(UsersDTO obj);
    
    @POST
    @Path("/users/remove")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response remove(UsersDTO obj) throws Exception;
    
    @POST
    @Path("/users/add")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response add(UsersDTO obj) throws Exception;
    
    
    @POST
    @Path("/users/update")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response update(UsersDTO obj) throws Exception;
    
    
    @POST
    @Path("/users/lock")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void lock(List<UsersDTO> listUsers) throws Exception;
    
    @POST
    @Path("/users/unlock")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void unlock(List<UsersDTO> listUsers) throws Exception;
    
    
    @POST
    @Path("/users/resetPass")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response resetPass(UsersDTO obj) throws Exception;
    
}
