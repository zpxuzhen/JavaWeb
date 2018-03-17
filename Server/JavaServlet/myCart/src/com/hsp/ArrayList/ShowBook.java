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
		
		out.println("<h1>»¶Ó­¹ºÂò</h1>");
		out.println("java Êé&nbsp;&nbsp;&nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=1&bookName=java'>µã»÷¹ºÂò</a><br>");
		out.println("oracle Êé&nbsp;&nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=2&bookName=oracle'>µã»÷¹ºÂò</a><br>");
		out.println("android Êé &nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id=3&bookName=android'>µã»÷¹ºÂò</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
