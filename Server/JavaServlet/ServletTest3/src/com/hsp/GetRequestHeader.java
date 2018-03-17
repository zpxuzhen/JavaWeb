package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestHeader extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//getHeader ͨ����Ϣͷ����ȡ��Ϣ
		String host=request.getHeader("Host");
		System.out.println("Host="+host);
		
		//getHeaderNames   ����:������http�������Ϣȫ����ӡ����
		Enumeration<String> headerNames=request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			//ȡ����Ϣͷ������
			String headerName=headerNames.nextElement();
			System.out.println(headerName+":"+request.getHeader(headerName));
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
