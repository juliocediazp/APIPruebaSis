package com.cmc.rh.pruebas;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cmc.rh.jwt.Autentication;

@Component
public class TransactionFilter implements Filter{
	
	@Autowired
	Autentication autentication;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		      HttpServletRequest req = (HttpServletRequest) request;
		      HttpServletResponse resp = (HttpServletResponse) response;
		      String url=req.getRequestURI();
		      if(url.contains("paginaPrincipal")) {
		           String token=getHeadersInfo(req);
		           if(token != null) {
		              if(token.equals("PRIMERA")) {
		            	  HttpServletResponse res = (HttpServletResponse)  response;
		            	    res.setHeader("Access-Control-Allow-Origin", "*");
		        	        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		        	        res.setHeader("Access-Control-Max-Age", "3600");
		        	        res.setHeader("Access-Control-Allow-Headers", "*");
		        		  chain.doFilter(request, res);
		              }else {
		            	  boolean isAutenticate=  autentication.desCript(token);
			        	  if(isAutenticate) {
			        		  chain.doFilter(request, response);
			        	  }else {
			        		 resp.setStatus(403);
			        		 response = new HttpServletResponseWrapper(resp).getResponse();
			        		 return;
			        	  }
		              }
		   
		           }else {
		        	   resp.setStatus(403);
		        		 response = new HttpServletResponseWrapper(resp).getResponse();
		        		 return;
		           }
		      }else {
		    	  chain.doFilter(request, response); 
		      }
		
	}
	
	  private String getHeadersInfo(HttpServletRequest request) {
	       String resp= null;
	        Enumeration headerNames = request.getHeaderNames();
	        
	        while (headerNames.hasMoreElements()) {
	        	 String key = (String) headerNames.nextElement();
	        	if(key.equalsIgnoreCase("Authorization")) {
	        		
	        		  resp = request.getHeader(key);
	        	}
	        	
	        	if(key.equalsIgnoreCase("access-control-request-headers")) {
	        		resp = "PRIMERA"; 
	        	}
	        }
	        return resp;
	    }
}
