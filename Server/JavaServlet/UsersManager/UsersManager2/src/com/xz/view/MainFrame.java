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

		//获取登录用户信息
		User user=(User) request.getSession().getAttribute("userObj");
		out.println("<h1>欢迎来到主界面</h1>"); 
		out.println("当前登录的用户是:"+user.getUsername()); 
		out.println("<h3>请选择您要进行的操作</h3>"); 
		out.println("<a href='/UsersManager2/servlet/ManagerUsers'>管理用户</a><br>");
		out.println("<a href='#'>添加用户</a><br>");
		out.println("<a href='#'>查找用户</a><br>");
		out.println("<a href='/UsersManager2/servlet/LoginServlet'>退出系统</a><br>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
