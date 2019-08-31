package com.capgemini.payment.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	@Override
	public void afterPropertiesSet() throws Exception {
		   setRealmName("PAYMENT_SECURITY");
	        super.afterPropertiesSet();
	    }
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
			response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName()); 
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.getWriter().write("HTTP Status 401 - " + authException.getMessage());
	}

}
