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
		User user=new User();
		user.setId(id);
		user.setPassword(password);
		UsersService usersService=new UsersService();
		boolean res=usersService.checkUser(user);
		if(res){
			//登录成功之后，把user对象保存到session中
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
