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
		//接收用户提交的用户名和密码
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		System.out.println("用户ID : "+id+"密码 : "+password);
		User loginUser=new User(id,password);
		if(new UsersService().checkUser(loginUser)){
			//登录成功之后，把loginUser对象保存到session中
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
