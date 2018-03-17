package com.hsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet4 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//ָ����ҳ�治���� Ie
		response.setDateHeader("Expires", -1);//�����IE��������ò����桿
		//Ϊ�˱�֤������.
		response.setHeader("Cache-Control", "no-cache");//����Ի��������ȡ�
		response.setHeader("Pragma", "no-cache");//�������������
//		//��Щ��վҪ����ҳ����һ��ʱ��,���绺��һ��Сʱ
//		//����һ��������ʾ���õĻ��汣��ʱ�䣬-1��ʾ��Զ����
//		response.setDateHeader("Expires", System.currentTimeMillis()+3600*1000*24);

		
		out.println("hello,world! "+new java.util.Date());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}



}
