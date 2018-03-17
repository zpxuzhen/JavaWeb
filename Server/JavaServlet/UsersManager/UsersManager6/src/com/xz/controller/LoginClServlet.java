package com.xz.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xz.domain.User;
import com.xz.service.UsersService;
import com.xz.tools.SQLHelper;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//�����û��ύ���û���������
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		System.out.println("�û�ID : "+id+"���� : "+password);
		User loginUser=new User(id,password);
		if(new UsersService().checkUser(loginUser)){
			//��¼�ɹ�֮�󣬰�loginUser���󱣴浽session��
			request.getSession().setAttribute("loginUser", loginUser);
			request.getRequestDispatcher("/WEB-INF/mainFrame.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
