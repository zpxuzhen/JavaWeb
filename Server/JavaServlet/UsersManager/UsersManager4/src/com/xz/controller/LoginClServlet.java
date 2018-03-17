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
		User user=new User();
		user.setId(id);
		user.setPassword(password);
		UsersService usersService=new UsersService();
		boolean res=usersService.checkUser(user);
		if(res){
			//��¼�ɹ�֮�󣬰�user���󱣴浽session��
			HttpSession session=request.getSession();
			session.setAttribute("login", user);
			request.getRequestDispatcher("/servlet/MainFrame").forward(request, response);
		}else{
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
