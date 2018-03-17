package com.hsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//获取ServletContext 对象引用,两种方式都可以获取
		ServletContext servletContext1=this.getServletContext();//方式1  
		ServletContext servletContext2=this.getServletConfig().getServletContext();//方式2
		//添加属性:
		servletContext1.setAttribute("username","韩顺平");
		//删除
		//servletContext1.removeAttribute("属性名");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
