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
		
		out.println("<h1>我的购物车</h1>");
		//遍历hashMap
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
			out.println("书名:"+name+"<br>数量:"+num+"&nbsp;&nbsp;单价:"+price+"元&nbsp;&nbsp;总价:"+total+"元<br><br>");
		}
		out.println("<br>您总共需要支付:"+totalBook +"元<br>");
		//我希望href形成这样的格式: /myCart/servlet/ShowBook;jsessionid=BE713B90F06572FF9BB5048E5D912DDF
//		String url=response.encodeURL("/myCart/servlet/ShowBook");
		//response.encodeURL有时候不太行,不如手动拼接jsessionid
		String url="/myCart/servlet/ShowBook;jsessionid="+httpSession.getId();
		out.println("<br><a href='"+url+"'>返回继续购物</a><br>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
