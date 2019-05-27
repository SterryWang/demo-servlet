package com.demo.filter.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

/**
 * 访问次数计数的过滤器，支持注解或者web.xml两种注册方式
 * Servlet Filter implementation class CountFilter
 */
//@WebFilter(urlPatterns= {"/CountServlet"},initParams= {@WebInitParam(name="count",value="1000")})
public class CountFilter implements Filter {
	
    private  int count;
    private FilterConfig  fc;

    /**
     * Default constructor. 
     */
    public CountFilter() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * ÿ�����ص���������󣬶�������count��1
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
    //ͨ��web���������ģ��������"count"�ĵ�ǰֵ,ʵ�ֺ�CountServlet֮������ݹ���
		ServletContext sc  =fc.getServletContext();
		sc.setAttribute("count", ++count);
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		count=Integer.valueOf(fConfig.getInitParameter("count"));
		this.fc=fConfig;
	}

}
