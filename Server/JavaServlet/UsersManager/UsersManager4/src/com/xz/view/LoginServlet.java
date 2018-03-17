package com.xz.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//浏览器默认编码
		response.setContentType("text/html;charset=utf-8");
//		浏览器字符编码
//		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回一个界面(html技术)
		out.println("<h1>用户登录</h1>");
		//action应该这样写    /web应用名/Servlet的url
		out.println("<form action='/UsersManager4/servlet/LoginClServlet' method='post'>");
		out.println("用户ID:");
		out.println("<input type=\"text\" name=\"id\"></br>");
		out.println("密&nbsp;码:");
		out.println("<input type=\"password\" name=\"password\"></br>");
		out.println("<input type=\"submit\" value=\"登陆\">");
		out.println("</form>");
		String err=(String) request.getAttribute("err");
		if(err!=null)	out.println(err);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
