package com.demo.session.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 在这个servlet中，将验证SessionServlet1中设定给session的数据能否获取到，
 * 从而间接验证session可以在不同的servlet中共享
 * @author Administrator
 *
 */

@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		HttpSession session = request.getSession();
		Date date = new Date(session.getCreationTime());
		String createTime  =sd.format(date);
		// System.out.println("session的所有属性名称为：" + session.getAttributeNames());
		System.out.println("session的id为" + session.getId());
		System.out.println("session的创建时间为:" + createTime);
		if (session.getAttribute("TAG") == null) {
			System.out.println("客户端浏览器首次访问，未持有TAG,将为其打TAG");
			session.setAttribute("TAG", "DEMO-SERVLETSESSION2");
			System.out.println("设置session有效期为60s");
			session.setMaxInactiveInterval(60);
		} else {
			System.out.println("客户端浏览器非首次访问，已经持有TAG。其TAG值和Session有效期以及session创建时间分别为：" + session.getAttribute("TAG") + ";"
					+ session.getMaxInactiveInterval() + "s"+";"+createTime);
			
		}
		response.getWriter().write("sessionservlet2响应完成");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

		doGet(request, response);

	}

}
