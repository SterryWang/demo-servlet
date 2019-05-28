package com.demo.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookInfoManageServlet
 */
@WebServlet("/BookManage")
public class BookInfoManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookInfoManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 测试web容器内部的重定向
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext sc = getServletContext();
		
		RequestDispatcher rd = sc.getRequestDispatcher("/index.html");
		response.setCharacterEncoding("UTF-8");
		//response.resetBuffer();
		
		
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  out=  response.getWriter();
		out.print("<h2>图书信息添加成功<h2><br>");
		out.print("图书编号："+request.getParameter("id")+"<br>");
		out.print("图书名称："+request.getParameter("name")+"<br>");
		out.print("图书作者："+request.getParameter("author")+"<br>");
		out.print("价格："+request.getParameter("price")+"<br>");
		out.print("邮箱："+request.getParameter("email")+"<br>");
		out.print("网址："+request.getParameter("url")+"<br>");
		out.flush();
		out.close();
		//doGet(request, response);
	}

}
