package com.hsp.Counter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Manager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�����Ĭ�ϱ���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��ȡServletContext ��������,���ַ�ʽ�����Ի�ȡ
		ServletContext servletContext=this.getServletContext();
		//ȡ������
		String nums =(String) servletContext.getAttribute("nums");
				
		out.println("<h1>����ҳ��</h1>");		
		out.println("��ҳ�汻������"+nums+"��");		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
