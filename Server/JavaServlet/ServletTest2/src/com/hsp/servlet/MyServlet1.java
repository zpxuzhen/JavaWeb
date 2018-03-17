package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		response.setStatus(302);
//		response.setHeader("Location", "/ServletTest2/servlet/MyServlet2");
		response.setHeader("Refresh", "5;url=/ServletTest2/servlet/MyServlet2");
		// 上面两句话等价	response.sendRedirect("/ServletTest2/servlet/MyServlet2");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}


}
