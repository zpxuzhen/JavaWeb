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
		//�����û��ύ���û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("�û��� : "+username+"���� : "+password);
		
		if(username.equals("xiaoming") && password.equals("123")){
			//����2:ʹ��session()���������ݸ��¸�ҳ��
			request.getSession().setAttribute("loginUser",username); 
			//����3:session()���Դ��ݶ���
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("userObj",user); 
			
			//����1:��ת����һ��ҳ��  
			response.sendRedirect("/UsersManager1/servlet/MainFrame?uname="+username+"&pwd="+password);
			
			
		}else{
			//������һ��ҳ��
			//servlet�ṩ�����ַ�����ת
			//sendRedirectת��   ��    forwardת��
			//sendRedirect��urlӦ������д    /webӦ����/Servlet��url
			response.sendRedirect("/UsersManager1/servlet/LoginServlet");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
