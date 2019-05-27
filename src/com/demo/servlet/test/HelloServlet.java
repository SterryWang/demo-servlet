package com.demo.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // ʹ�� GBK ��������������ʾ
		//response.setContentType("text/html");
       // response.setCharacterEncoding("GBK");
        System.out.println("处理get请求，并封装返回信息");
        PrintWriter out =response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>servlet菜鸟实例222333333</TITLE></HEAD>");
        out.println("<BODY>  servlet details</BODY>");
        out.println("</HTML>");
       
        out.flush();
        out.close();
     // response.getWriter().write("����̳̣�http://www.runoob.com");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
