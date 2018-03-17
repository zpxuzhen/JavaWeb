package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xz.domain.User;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//每个地方都要加入这个，可以封装成函数。或者使用过滤器
		//取出session的login，才能进入到这个页面
		User user=(User) request.getSession().getAttribute("login");
		if(user==null){
			//跳回到登录界面
			request.setAttribute("err", "请输入用户名密码登录"); 
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
			return;
		}

		//获取登录用户信息
		out.println("<h1>欢迎来到主界面</h1>"); 
		out.println("当前登录的用户是:"+user.getId()+"<br>"); 
		out.println("<h3>请选择您要进行的操作</h3>"); 
		out.println("<a href='/UsersManager4/servlet/ManagerUsers'>管理用户</a><br>");
		out.println("<a href='/UsersManager4/servlet/AddUserView'>添加用户</a><br>");
		out.println("<a href='#'>查找用户</a><br>");
		out.println("<a href='/UsersManager4/servlet/LoginServlet'>退出系统</a><br>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
