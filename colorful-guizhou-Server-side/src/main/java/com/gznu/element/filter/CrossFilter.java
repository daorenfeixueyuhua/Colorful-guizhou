package com.gznu.element.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import com.mysql.fabric.Response;


public class CrossFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletResponse  httpServletResponse = (HttpServletResponse) response;
		 HttpServletRequest   httpServletRequest =(HttpServletRequest) request;
		 httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		 httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept,content-type,accessToken"); 
		 httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
		 response.setContentType("application/json;charset=utf-8");
		 response.setCharacterEncoding("UTF-8");
		 StringBuffer requestUrl=httpServletRequest.getRequestURL();
		 String url="http://" + request.getServerName() + ":" + request.getServerPort() + httpServletRequest.getContextPath()+"/ ";
		 int i=0;
		 if(!HttpMethod.OPTIONS.name().equals(httpServletRequest.getMethod()))
		 {   
			 for(i=0;i<requestUrl.length();i++)
			 {
				 if(requestUrl.charAt(i)!=url.charAt(i))
					 break;
			 }
			 if(i!=requestUrl.length())
			 chain.doFilter(request, httpServletResponse);
		 }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
