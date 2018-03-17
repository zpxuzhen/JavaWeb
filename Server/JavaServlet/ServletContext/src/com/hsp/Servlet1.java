package com.hsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡServletContext ��������,���ַ�ʽ�����Ի�ȡ
		ServletContext servletContext1=this.getServletContext();//��ʽ1  
		ServletContext servletContext2=this.getServletConfig().getServletContext();//��ʽ2
		//�������:
		servletContext1.setAttribute("username","��˳ƽ");
		//ɾ��
		//servletContext1.removeAttribute("������");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
