package com.example.lab9.Task5;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(filterName = "FilterAuthorization")
public class FilterAuthorization implements Filter {
	private FilterConfig filterConfigObj = null;
	public void init(FilterConfig config) throws ServletException {
		this.filterConfigObj = config;
	}
	
	public void destroy() {
		System.out.println("Filter destroyed");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		String remoteAddress =  request.getRemoteAddr();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String protocol = request.getProtocol();
		
		chain.doFilter(request, response);
		
		System.out.println("=====================================================================");
		System.out.println("User Logged! User IP: " + remoteAddress +
				" Resource File: " + uri + " Protocol: " + protocol);
	}
}
