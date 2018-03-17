package com.hsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet4 extends HttpServlet {
	//读取文件，和获取文件全路径
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//首先读取到文件
		//*如果文件放在WebRoot目录下
		InputStream inputStream=this.getServletContext().getResourceAsStream("dbinfo.properties");
//		//*如果文件放在src目录下;则使用类加载器
//		InputStream is=Servlet4.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		//创建Properties
		Properties pp=new Properties();
		pp.load(inputStream);
		out.println("username:"+pp.getProperty("username"));
		//如何读取到一个文件的全路径---主目录是 WebRoot
		String path=this.getServletContext().getRealPath("dbinfo.properties");
		out.println("path:"+path);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
