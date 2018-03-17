package com.hsp.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//�����Ҫע�͵���getWriter()��getOutputStream()������������ͬʱʹ��
//		PrintWriter out = response.getWriter();
		
		//��ʾ�����ļ�
		response.setHeader("Content-Disposition", "attachment; filename=Winter.jpg");
		//���ļ�.˵��һ��web վ�������ļ���ԭ��
		//1.��ȡ��Ҫ�����ļ���ȫ·��
		String path=this.getServletContext().getRealPath("/images/Winter.jpg");
		//System.out.println("path="+path);
		//2�����ļ�������
		FileInputStream fis=new FileInputStream(path);
		//��һ�������ֽ�����
		byte buff[]=new byte[1024];
		int len=0;//��ʾʵ��ÿ�ζ�ȡ�˶�����ֽ�
		OutputStream os=response.getOutputStream();
		while((len=fis.read(buff))>0){	
			os.write(buff, 0, len);
		}
		//ȱ��: û�н�����./ͼ��/
		//�ر�
		os.close();
		fis.close();

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}



}
