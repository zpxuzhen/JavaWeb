package com.xz.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xz.domain.User;
import com.xz.tools.SQLHelper;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//接收用户提交的用户名和密码
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		System.out.println("用户ID : "+id+"密码 : "+password);
		if(id.equals("") || password.equals("") ){
			request.getSession().setAttribute("error","用户ID或者密码不能为空"); 
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
		}else{
			//到数据库中去验证
			String path=this.getClass().getResource("/").getPath()+"com/xz/tools/dbinfo.properties";
			SQLHelper sqlHelper=new SQLHelper(path);
			String sql="select * from users where id=? and passwd=?";
			String[] parameters={id,password};
			try {
				ResultSet rs=sqlHelper.executeQuery(sql, parameters);
				if(rs.next()){
					//session()可以传递对象给下一个页面
					User user=new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(password);
					request.getSession().setAttribute("userObj",user); 
					request.getSession().setAttribute("sqlHelper",sqlHelper); 
					request.getSession().setAttribute("error","");
					request.getRequestDispatcher("/servlet/MainFrame").forward(request, response);
				}else{
					request.getSession().setAttribute("error","用户ID或者密码错误"); 
					request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
				}	
			} catch (SQLException e) {
				request.getSession().setAttribute("error","用户ID只能是数字"); 
				request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
			}finally{
				sqlHelper.close();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
