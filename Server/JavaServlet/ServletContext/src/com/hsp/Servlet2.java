package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡServletContext ��������,���ַ�ʽ�����Ի�ȡ
		ServletContext servletContext2=this.getServletConfig().getServletContext();//��ʽ2
		//ȡ������
		String username =(String) servletContext2.getAttribute("username");
		
		out.println("username="+username);
		
		//ɾ��
		//servletContext2.removeAttribute("������");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
