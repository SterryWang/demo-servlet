package com.demo.filter.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 添加一个全局filter,把所有请求体和返回体的编码格式都设置成
 * UTF-8模式或者其他模式（也可以通过web.xml设置成其他的编码格式）
 * Servlet Filter implementation class CharacterFilter
 */
//@WebFilter(urlPatterns= {"/*"},initParams= {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterFilter implements Filter {
	private String encoding;

    /**
     * Default constructor. 
     */
    public CharacterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if(encoding!=null) {
			System.out.println("执行请求信息的拦截过滤");
			System.out.println("捕获http请求的编码格式为："+request.getCharacterEncoding());
			System.out.println("捕获http请求的contenttype为："+request.getContentType());
			System.out.println("捕获http请求中服务端和请求端的端口信息"+request.getLocalPort()+";"+request.getRemotePort());
	
			//System.out.println("捕获http请求，获取toString内容为"+request.toString());
			System.out.println("捕获http请求，请求的类.class为"+request.getClass());
			request.setCharacterEncoding(encoding);
			
			response.setContentType("text/html;charset="+encoding);
		}

		// pass the request along the filter chain
		System.out.println("请求拦截过滤完毕，交给后续的filter或者servlet继续处理请求");
		chain.doFilter(request, response);
		//拦截返回体，再执行一次过滤操作
		System.out.println("已执行了返回信息的拦截"+response.getCharacterEncoding());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * 先读取web.xml中的关于此filter的初始化配置
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding=fConfig.getInitParameter("encoding");
		System.out.println("初始化http报文编码格式为："+encoding);
	}

}
