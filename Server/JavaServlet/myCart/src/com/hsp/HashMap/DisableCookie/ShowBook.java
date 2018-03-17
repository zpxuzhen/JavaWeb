package com.hsp.HashMap.DisableCookie;

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

//http://localhost:8080/myCart/servlet/ShowBook

public class ShowBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//����һ��session
		HttpSession httpSession=request.getSession();
		
		out.println("<h1>��ӭ����</h1>");
		//ȡ��DB
		HashMap<String,Book> books=DB.getDB();
		Iterator iterator=books.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Book book=books.get(key);
			String id=book.getId();
			String name=book.getName();
			float price=book.getPrice();
			//��ϣ��href�γ������ĸ�ʽ: /myCart/servlet/BuyBookCl;jsessionid=BE713B90F06572FF9BB5048E5D912DDF?id=1
//			String url=response.encodeURL("/myCart/servlet/BuyBookCl?id="+id);
			//response.encodeURL��ʱ��̫��,�����ֶ�ƴ��jsessionid
			String url="/myCart/servlet/BuyBookCl;jsessionid="+httpSession.getId()+"?id="+id;
			out.println("����:"+name+"<br>�۸�:"+price+"Ԫ&nbsp;&nbsp;<a href='"+url+"'>�������</a><br><br>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
