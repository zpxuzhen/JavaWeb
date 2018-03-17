package com.hsp.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>��ӭ����</h1>");
		out.println("java ��&nbsp;&nbsp;&nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=1&bookName=java'>�������</a><br>");
		out.println("oracle ��&nbsp;&nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=2&bookName=oracle'>�������</a><br>");
		out.println("android �� &nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=3&bookName=android'>�������</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
