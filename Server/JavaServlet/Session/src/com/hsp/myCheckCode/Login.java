package com.hsp.myCheckCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�����Ĭ�ϱ���
		response.setContentType("text/html;charset=utf-8");
//		������ַ�����
//		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//����һ������(html����)
		out.println("<h1>�û���¼</h1>");
		//actionӦ������д    /webӦ����/Servlet��url
		out.println("<form action='/Session/servlet/LoginCl' method='post'>");
		out.println("�û�ID:");
		out.println("<input type=\"text\" name=\"id\"></br>");
		out.println("��&nbsp;��:");
		out.println("<input type=\"password\" name=\"password\"></br>");
		out.println("��֤��:");
		out.println("<input type=\"text\" name=\"checkcode\"></br><img src='/Session/servlet/CreateCheckCode'/></br>");
		out.println("<input type=\"submit\" value=\"��½\">");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
