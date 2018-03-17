package com.xz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;
import com.xz.service.UsersService;

public class UserClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String type=request.getParameter("type");
		UsersService usersService=new UsersService();
		
		if("del".equals(type)){
		//删除用户
			int id=Integer.parseInt(request.getParameter("userId"));
			if(usersService.delUser(id)){
				request.setAttribute("info", "删除成功!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "删除失败!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}else if("gotoUpdateView".equals(type)){
		//要去修改用户的界面
			int id=Integer.parseInt(request.getParameter("userId"));
			User user=usersService.getUserById(id);
			//为了让下一个Servlet使用我们的user对象，我们可以把该user对象放入request中
			request.setAttribute("userinfo", user);
			request.getRequestDispatcher("/servlet/UpdateUserView").forward(request, response);
		}else if("update".equals(type)){
		//修改用户[如果用户提交的数据格式不对？？有一个验证]
			int id=Integer.parseInt(request.getParameter("id"));
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			int grade=Integer.parseInt(request.getParameter("grade"));
			String password=request.getParameter("password");
			User user=new User(id,username,email,grade,password);
			if(usersService.updateUser(user)){
				request.setAttribute("info", "修改成功!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "修改失败!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}else if("add".equals(type)){
		//添加用户[如果用户提交的数据格式不对？？有一个验证]
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			int grade=Integer.parseInt(request.getParameter("grade"));
			String password=request.getParameter("password");
			User user=new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setGrade(grade);
			user.setPassword(password);
			if(usersService.addUser(user)){
				request.setAttribute("info", "添加成功!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "添加失败!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
