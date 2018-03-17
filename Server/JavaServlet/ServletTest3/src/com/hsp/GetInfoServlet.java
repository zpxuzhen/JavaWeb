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
		//得到URL
		String url=request.getRequestURL().toString();
		System.out.println("url="+url);
		//得到URI
		String uri=request.getRequestURI().toString();
		System.out.println("uri="+uri);
		//得到  请求行中的参数部分
		String queryString=request.getQueryString();
		System.out.println("QueryString="+queryString);
		//得到  请求的客户机的IP地址
		String remoteAddr=request.getRemoteAddr();
		System.out.println("RemoteAddr="+remoteAddr);
		//得到  请求的客户机的完整主机名
		String remoteHost=request.getRemoteHost();
		System.out.println("RemoteHost="+remoteHost);
		//得到  客户机所使用的网络端口号
		int remotePort=request.getRemotePort();
		System.out.println("RemotePort="+remotePort);
		//得到  WEB服务器的IP地址
		String localAddr=request.getLocalAddr().toString();
		System.out.println("LocalAddr="+localAddr);
		//得到  WEB服务器的主机名
		String localName=request.getLocalName().toString();
		System.out.println("LocalName="+localName);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
