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
		
		out.println("<h1>�ҵĹ��ﳵ</h1>");
		for(Book book : myBooks){
			out.println("����:"+book.getName()+"����:"+book.getNum()+"<br>");
		}
		out.println("<br><a href='/myCart/servlet/ShowBook'>���ؼ�������</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
