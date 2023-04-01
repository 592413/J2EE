package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestFilter implements Filter{
	
	private FilterConfig filterConfig=null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig=null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest= (HttpServletRequest)request;
		
		HttpServletResponse httpResponse= (HttpServletResponse)response;
		
		//Get The Servlet Context
		ServletContext sc = filterConfig.getServletContext();
		
		String filterName = filterConfig.getFilterName();
		String servletPath= httpRequest.getServletPath();
		
		sc.log(filterName + " | " +servletPath + " | before Request");
		
		//Go to NextFilter in the Filter Chain
		chain.doFilter(httpRequest, httpResponse);
		
		sc.log(filterName + " | " +servletPath + " | after Request");
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.filterConfig=config;
		
	}

}
