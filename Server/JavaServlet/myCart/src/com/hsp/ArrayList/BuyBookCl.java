package com.hsp.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
		String bookName=request.getParameter("bookName");
		String id=request.getParameter("id");
		HttpSession httpSession=request.getSession();
		
		ArrayList<Book> myBooks=(ArrayList<Book>) httpSession.getAttribute("myBooks");
		if(myBooks==null)	myBooks=new ArrayList<Book>();	//��һ�ι���
		boolean found=false;
		for(Book book:myBooks){
			if(book.getId().equals(id)){
				int num=book.getNum();
				book.setNum(num+1);
				found=true;
			}
		}
		if(found==false){
			Book book=new Book();
			book.setId(id);
			book.setNum(1);
			book.setName(bookName);
			myBooks.add(book);
		}
		httpSession.setAttribute("myBooks", myBooks);

		//��ת����ʾ���ﳵ��ҳ��
		request.getRequestDispatcher("/servlet/ShowMyCart").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
