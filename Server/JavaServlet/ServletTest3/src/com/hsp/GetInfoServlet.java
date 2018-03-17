package com.hsp;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//�õ�URL
		String url=request.getRequestURL().toString();
		System.out.println("url="+url);
		//�õ�URI
		String uri=request.getRequestURI().toString();
		System.out.println("uri="+uri);
		//�õ�  �������еĲ�������
		String queryString=request.getQueryString();
		System.out.println("QueryString="+queryString);
		//�õ�  ����Ŀͻ�����IP��ַ
		String remoteAddr=request.getRemoteAddr();
		System.out.println("RemoteAddr="+remoteAddr);
		//�õ�  ����Ŀͻ���������������
		String remoteHost=request.getRemoteHost();
		System.out.println("RemoteHost="+remoteHost);
		//�õ�  �ͻ�����ʹ�õ�����˿ں�
		int remotePort=request.getRemotePort();
		System.out.println("RemotePort="+remotePort);
		//�õ�  WEB��������IP��ַ
		String localAddr=request.getLocalAddr().toString();
		System.out.println("LocalAddr="+localAddr);
		//�õ�  WEB��������������
		String localName=request.getLocalName().toString();
		System.out.println("LocalName="+localName);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
