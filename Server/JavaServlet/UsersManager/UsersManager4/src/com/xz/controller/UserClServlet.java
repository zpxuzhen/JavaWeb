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
		//ɾ���û�
			int id=Integer.parseInt(request.getParameter("userId"));
			if(usersService.delUser(id)){
				request.setAttribute("info", "ɾ���ɹ�!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "ɾ��ʧ��!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}else if("gotoUpdateView".equals(type)){
		//Ҫȥ�޸��û��Ľ���
			int id=Integer.parseInt(request.getParameter("userId"));
			User user=usersService.getUserById(id);
			//Ϊ������һ��Servletʹ�����ǵ�user�������ǿ��԰Ѹ�user�������request��
			request.setAttribute("userinfo", user);
			request.getRequestDispatcher("/servlet/UpdateUserView").forward(request, response);
		}else if("update".equals(type)){
		//�޸��û�[����û��ύ�����ݸ�ʽ���ԣ�����һ����֤]
			int id=Integer.parseInt(request.getParameter("id"));
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			int grade=Integer.parseInt(request.getParameter("grade"));
			String password=request.getParameter("password");
			User user=new User(id,username,email,grade,password);
			if(usersService.updateUser(user)){
				request.setAttribute("info", "�޸ĳɹ�!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "�޸�ʧ��!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}else if("add".equals(type)){
		//����û�[����û��ύ�����ݸ�ʽ���ԣ�����һ����֤]
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
				request.setAttribute("info", "��ӳɹ�!");
				request.getRequestDispatcher("/servlet/Ok").forward(request, response);
			}else{
				request.setAttribute("info", "���ʧ��!");
				request.getRequestDispatcher("/servlet/Error").forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
