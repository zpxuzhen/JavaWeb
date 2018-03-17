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
		
		//�����û�Ҫ�����������
		String id=request.getParameter("id");
		HttpSession httpSession=request.getSession();
		
		LinkedHashMap<String,Book> myBooks=(LinkedHashMap<String,Book>) httpSession.getAttribute("myBooks");
		if(myBooks==null)	{
		//��һ�ι���
			myBooks=new LinkedHashMap<String,Book>();	
			Book book=DB.getBookById(id);
			book.setNum(1);
			myBooks.put(id,book);
		}else{
			//�ж�myBooks���Ƿ��и���
			if(myBooks.containsKey(id)){
				//�����
				Book book=myBooks.get(id);
				int num=book.getNum();
				book.setNum(num+1);
			}else{
				//û�й����
				Book book=DB.getBookById(id);
				book.setNum(1);
				myBooks.put(id,book);
			}
		}
		httpSession.setAttribute("myBooks", myBooks);

		//��ת����ʾ���ﳵ��ҳ��
		request.getRequestDispatcher("/servlet/ShowMyCart").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
