package com.hsp.HashMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
		
		out.println("<h1>欢迎购买</h1>");
		//取出DB
		HashMap<String,Book> books=DB.getDB();
		Iterator iterator=books.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Book book=books.get(key);
			String id=book.getId();
			String name=book.getName();
			float price=book.getPrice();
			out.println("书名:"+name+"<br>价格:"+price+"元&nbsp;&nbsp;<a href='/myCart/servlet/BuyBookCl?id="+id+"'>点击购买</a><br><br>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
