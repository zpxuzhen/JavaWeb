package com.hsp.myCheckCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//浏览器默认编码
		response.setContentType("text/html;charset=utf-8");
//		浏览器字符编码
//		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//返回一个界面(html技术)
		out.println("<h1>用户登录</h1>");
		//action应该这样写    /web应用名/Servlet的url
		out.println("<form action='/Session/servlet/LoginCl' method='post'>");
		out.println("用户ID:");
		out.println("<input type=\"text\" name=\"id\"></br>");
		out.println("密&nbsp;码:");
		out.println("<input type=\"password\" name=\"password\"></br>");
		out.println("验证码:");
		out.println("<input type=\"text\" name=\"checkcode\"></br><img src='/Session/servlet/CreateCheckCode'/></br>");
		out.println("<input type=\"submit\" value=\"登陆\">");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
