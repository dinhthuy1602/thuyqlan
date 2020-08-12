/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.base.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.mail.Session;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;
import com.viettel.qlan.dto.UsersDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 *
 * @author hunglq9
 */
public class AuthenticationFilter implements javax.servlet.Filter {
	public static final String ALLOW_ALL_IP = "*";
	public static final String WHITE_LIST = "/usersService/login,/usersService/logout,/usersService/changePassword";
	@Autowired
	AuthenticationService authenticationService;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = null;
	        HttpServletResponse res = null;
	        if ((request instanceof HttpServletRequest)) {
	            req = (HttpServletRequest) request;
	        }
	        if ((response instanceof HttpServletResponse)) {
	            res = (HttpServletResponse) response;
	            System.out.println("");
	        }
	       
	        if(null!=req){
			String path = req.getPathInfo();
			HttpSession session=req.getSession();
				 if(authenticationService==null){
			            ServletContext servletContext = request.getServletContext();
			            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			            authenticationService = webApplicationContext.getBean(AuthenticationService.class);
			        }
					
					if(!WHITE_LIST.contains(path)){
						String jwt = (String) session.getAttribute("USER_TOKEN");
						UsersDTO usersDTO=(UsersDTO) req.getSession().getAttribute("userInfo");
						boolean veryfiStatus = authenticationService.veryfiToken(jwt,usersDTO);
						if (veryfiStatus) {
							
							
							if(null==usersDTO){
							 usersDTO =authenticationService.getUser(jwt);
							}
							req.getSession().setAttribute("userInfo", usersDTO);
							req.getSession().setAttribute("isValid", "1");
							req.setAttribute("isValid", "1");
							
							String jwtRefresh=createJWT(jwt, 360000l);
							req.getSession().setAttribute("USER_TOKEN", jwtRefresh);
							
							if(path.equals("/usersService/keepalive")){
								 if(null!=res){
								usersDTO =authenticationService.getUser(jwt);
								req.getSession().setAttribute("userInfo", usersDTO);
								res.setStatus(200);
								res.setContentType("application/json;charset=utf-8");
								PrintWriter out = res.getWriter();
								Gson gson= new Gson();
								String result=gson.toJson(usersDTO);
								out.println(result);
								out.flush();
								  }
							} else {
								filter.doFilter(req, res);
							}
							
							
						} else  {
							 if(null!=res){
							res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
							PrintWriter out = res.getWriter();
							out.print("Access denied!");
							 }
						}
					 } else {
							filter.doFilter(req, res);
					 }
			}
		}
	}

	@Override
	public void destroy() {
	}

	private String createJWT(String jwt, long ttlMillis) {
		 //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		   long nowMillis = System.currentTimeMillis();
		Claims claims = Jwts.parser()         
			       .setSigningKey(DatatypeConverter.parseBase64Binary("QLAN"))
			       .parseClaimsJws(jwt).getBody();
		 Date now = new Date(nowMillis);
		 
		    //We will sign our JWT with our ApiKey secret
		    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("QLAN");
		    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		 
		    //Let's set the JWT Claims
		    JwtBuilder builder = Jwts.builder().setId(claims.getId())
		                                .setIssuedAt(now)
		                                .setSubject(claims.getSubject())
		                                .setIssuer(null)
		                                .signWith(signatureAlgorithm, signingKey);
		    //if it has been specified, let's add the expiration
		    if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		        Date exp = new Date(expMillis);
		        builder.setExpiration(exp);
		    }
		 
		    //Builds the JWT and serializes it to a compact, URL-safe string
		    return builder.compact();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
