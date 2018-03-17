package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ��¼��(����1)
		String username=request.getParameter("uname");
		//��ȡ��¼��(����2)
		String username2=(String) request.getSession().getAttribute("loginUser");
		//��ȡ��¼��(����3)
		User user=(User) request.getSession().getAttribute("userObj");
		
		out.println("<h1>��ӭ����������</h1>"+username+" "+username2+" "+user.getUsername());
		out.println("<a href=\"/UsersManager1/servlet/LoginServlet\">�������µ�¼</a>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
