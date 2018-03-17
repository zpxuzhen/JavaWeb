package com.xz.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

public class GoHallUI extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//�õ��ӵ�¼ҳ�洫�ݵ��û�ID������
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		//����һ��user����
		Users loginUser=new Users(Integer.parseInt(user_id),user_pwd);
		//ʹ��ҵ���߼��������֤
		UsersService usersService=new UsersService();
		if(usersService.checkUser(loginUser)){
			//˵���ǺϷ��û�,��ת���������
			//��Ϊ�û���Ϣ�����ںܶ�ҳ��ʹ�ã���� ����session
			request.getSession().setAttribute("loginUser", loginUser);
			//����һ��ҳ��hall.jsp׼����Ҫ��ʾ������(��������һ��������Ч)
			request.setAttribute("books", new BooksService().getAllBooks());
			//�����ﳵ����session(��������һֱ�������û��ر������)
			request.getSession().setAttribute("myCart", new MyCart());
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			//˵�����ǺϷ��û�,����ԭҳ��
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
