package com.hsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet4 extends HttpServlet {
	//��ȡ�ļ����ͻ�ȡ�ļ�ȫ·��
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//���ȶ�ȡ���ļ�
		//*����ļ�����WebRootĿ¼��
		InputStream inputStream=this.getServletContext().getResourceAsStream("dbinfo.properties");
//		//*����ļ�����srcĿ¼��;��ʹ���������
//		InputStream is=Servlet4.class.getClassLoader().getResourceAsStream("dbinfo.properties");
		//����Properties
		Properties pp=new Properties();
		pp.load(inputStream);
		out.println("username:"+pp.getProperty("username"));
		//��ζ�ȡ��һ���ļ���ȫ·��---��Ŀ¼�� WebRoot
		String path=this.getServletContext().getRealPath("dbinfo.properties");
		out.println("path:"+path);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
