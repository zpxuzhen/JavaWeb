package com.hsp.HashMap.DisableCookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

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
		LinkedHashMap<String,Book> myBooks=(LinkedHashMap<String,Book>) httpSession.getAttribute("myBooks");
		
		out.println("<h1>�ҵĹ��ﳵ</h1>");
		//����hashMap
		Iterator iterator=myBooks.keySet().iterator();
		float totalBook=0;
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Book book=myBooks.get(key);
			String name=book.getName();
			int num=book.getNum();
			float price=book.getPrice();
			float total=price*num;
			totalBook+=total;
			out.println("����:"+name+"<br>����:"+num+"&nbsp;&nbsp;����:"+price+"Ԫ&nbsp;&nbsp;�ܼ�:"+total+"Ԫ<br><br>");
		}
		out.println("<br>���ܹ���Ҫ֧��:"+totalBook +"Ԫ<br>");
		//��ϣ��href�γ������ĸ�ʽ: /myCart/servlet/ShowBook;jsessionid=BE713B90F06572FF9BB5048E5D912DDF
//		String url=response.encodeURL("/myCart/servlet/ShowBook");
		//response.encodeURL��ʱ��̫��,�����ֶ�ƴ��jsessionid
		String url="/myCart/servlet/ShowBook;jsessionid="+httpSession.getId();
		out.println("<br><a href='"+url+"'>���ؼ�������</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
