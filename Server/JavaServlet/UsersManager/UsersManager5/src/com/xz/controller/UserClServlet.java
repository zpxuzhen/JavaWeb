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
				request.getRequestDispatcher("/WEB-INF/ok.jsp").forward(request, response);
			}else{
				request.setAttribute("info", "删除失败!");
				request.getRequestDispatcher("/WEB-INF/err.jsp").forward(request, response);
			}
		}else if("update".equals(type)){
		//修改用户[如果用户提交的数据格式不对？？有一个验证]
			int id=Integer.parseInt(request.getParameter("id"));
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			int grade=Integer.parseInt(request.getParameter("grade"));
			String password=request.getParameter("password");
			User user=new User();
			user.setUser_id(id);
			user.setUser_name(username);
			user.setUser_pwd(password);
			user.setUser_email(email);
//			user.setUser_tel("1231231");
			user.setUser_grade(grade);
			if(usersService.updateUser(user)){
				request.setAttribute("info", "修改成功!");
				request.getRequestDispatcher("/WEB-INF/ok.jsp").forward(request, response);
			}else{
				request.setAttribute("info", "修改失败!");
				request.getRequestDispatcher("/WEB-INF/err.jsp").forward(request, response);
			}
		}else if("add".equals(type)){
		//添加用户[如果用户提交的数据格式不对？？有一个验证]
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			int grade=Integer.parseInt(request.getParameter("grade"));
			String password=request.getParameter("password");
			User user=new User();
			user.setUser_name(username);
			user.setUser_pwd(password);
			user.setUser_email(email);
			user.setUser_tel("1231231");
			user.setUser_grade(grade);
			if(usersService.addUser(user)){
				request.setAttribute("info", "添加成功!");
				request.getRequestDispatcher("/WEB-INF/ok.jsp").forward(request, response);
			}else{
				request.setAttribute("info", "添加失败!");
				request.getRequestDispatcher("/WEB-INF/err.jsp").forward(request, response);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
