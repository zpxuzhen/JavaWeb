package com.hsp.requestForward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//接收用户名
		String u=request.getParameter("username");
		
		//把u放入request域对象
		request.setAttribute("username", u);
		
		//转发:把request和response对象转发给下一个Servlet
		//资源地址：不需要项目名。因为它只是在WEB服务器内部转发。
		request.getRequestDispatcher("/Servlet2").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
