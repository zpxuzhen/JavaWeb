package com.hsp.requestForward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//����һ������(html����)
		out.println("<h1>�û���¼</h1>");
		//actionӦ������д    /webӦ����/Servlet��url
		out.println("<form action='/ServletTest3/Servlet1' method='post'>");
		out.println("�û���:");
		out.println("<input type=\"text\" name=\"username\"></br>");
		out.println("��&nbsp;��:");
		out.println("<input type=\"password\" name=\"password\"></br>");
		out.println("<input type=\"submit\" value=\"��½\">");
		out.println("</form>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
