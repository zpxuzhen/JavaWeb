package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取用户浏览器Referer
		String referer=request.getHeader("Referer");
		//本网站来访问此页面可以
		if(referer==null||!referer.startsWith("http://localhost:8080/ServletTest2")){
			response.sendRedirect("/ServletTest2/servlet/Error");
			return;
		}
		
		//通过request对象来获取http请求信息
		//取出Host
		String host=request.getHeader("Host");
		out.println("host= "+host);
		
		out.println("这是我们非常重要的信息...1234567   123");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}


}
