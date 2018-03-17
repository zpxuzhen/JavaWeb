package com.hsp.HashMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyBookCl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//接收用户要购买书的名字
		String id=request.getParameter("id");
		HttpSession httpSession=request.getSession();
		
		LinkedHashMap<String,Book> myBooks=(LinkedHashMap<String,Book>) httpSession.getAttribute("myBooks");
		if(myBooks==null)	{
		//第一次购物
			myBooks=new LinkedHashMap<String,Book>();	
			Book book=DB.getBookById(id);
			book.setNum(1);
			myBooks.put(id,book);
		}else{
			//判断myBooks中是否有该书
			if(myBooks.containsKey(id)){
				//购买过
				Book book=myBooks.get(id);
				int num=book.getNum();
				book.setNum(num+1);
			}else{
				//没有购买过
				Book book=DB.getBookById(id);
				book.setNum(1);
				myBooks.put(id,book);
			}
		}
		httpSession.setAttribute("myBooks", myBooks);

		//跳转到显示购物车的页面
		request.getRequestDispatcher("/servlet/ShowMyCart").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
