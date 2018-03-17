package com.xz.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

//�ÿ�������Ӧ�û�������Ʒ������
public class ShowppingClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//ʲôʱ�򴴽����ﳵ?�û���¼�ɹ���ʱ��,����ȡ�����ﳵ
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		//�����û��Ĳ���
		String type=request.getParameter("type");
		if("add".equals(type)){
			//�����û�Ҫ�������Ʒid
			String book_id=request.getParameter("book_id");
			myCart.addBook(book_id);
		}else if("del".equals(type)){
			//�����û�Ҫɾ������Ʒid
			String book_id=request.getParameter("book_id");
			myCart.delBook(book_id);
		}else if("update".equals(type)){
			//�û�ϣ������
			//�õ�ϣ�����µ����
			String []bookIds=request.getParameterValues("book_id");
			//�õ�ϣ�����µ��������
			String []bookNums=request.getParameterValues("book_number");
			for(int i=0;i<bookIds.length;i++){
				//���¹��ﳵ
				myCart.updBook(bookIds[i], bookNums[i]);
			}
		}else if("goHall".equals(type)){
			//���ع������
			request.setAttribute("books", new BooksService().getAllBooks());
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}else if("look".equals(type)){
			//�鿴���ﳵ
		}else if("clear".equals(type)){
			//��չ��ﳵ
			myCart.clearBook();
		}
		//Ϊ�˷�ֹҳ��ˢ����ɵ��ظ��ύ,���ǿ���sendRedirect��1���м�Servlet,׼��������֮����ȥ��ʾ
		response.sendRedirect("/MyShowpping/GoShowMyCart");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
