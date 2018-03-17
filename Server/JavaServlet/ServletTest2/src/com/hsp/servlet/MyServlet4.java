package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet4 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//指定该页面不缓存 Ie
		response.setDateHeader("Expires", -1);//【针对IE浏览器设置不缓存】
		//为了保证兼容性.
		response.setHeader("Cache-Control", "no-cache");//【针对火狐浏览器等】
		response.setHeader("Pragma", "no-cache");//【其他浏览器】
//		//有些网站要求网页缓存一定时间,比如缓存一个小时
//		//后面一个参数表示设置的缓存保持时间，-1表示永远缓存
//		response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24);

		
		out.println("hello,world! "+new java.util.Date());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}



}
