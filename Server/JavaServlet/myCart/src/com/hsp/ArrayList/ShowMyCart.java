package com.hsp.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowMyCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession httpSession=request.getSession();
		ArrayList<Book> myBooks=(ArrayList<Book>) httpSession.getAttribute("myBooks");
		
		out.println("<h1>我的购物车</h1>");
		for(Book book : myBooks){
			out.println("书名:"+book.getName()+"数量:"+book.getNum()+"<br>");
		}
		out.println("<br><a href='/myCart/servlet/ShowBook'>返回继续购物</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
