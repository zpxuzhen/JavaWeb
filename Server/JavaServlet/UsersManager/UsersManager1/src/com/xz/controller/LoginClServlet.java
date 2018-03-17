package com.xz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//接收用户提交的用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("用户名 : "+username+"密码 : "+password);
		
		if(username.equals("xiaoming") && password.equals("123")){
			//方法2:使用session()来传递数据给下个页面
			request.getSession().setAttribute("loginUser",username); 
			//方法3:session()可以传递对象
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("userObj",user); 
			
			//方法1:跳转到下一个页面  
			response.sendRedirect("/UsersManager1/servlet/MainFrame?uname="+username+"&pwd="+password);
			
			
		}else{
			//跳回上一个页面
			//servlet提供了两种方法跳转
			//sendRedirect转向   、    forward转发
			//sendRedirect的url应该这样写    /web应用名/Servlet的url
			response.sendRedirect("/UsersManager1/servlet/LoginServlet");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
