package com.hsp.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//��ȡ����cookie��Ϣ����ѡ��Ҫ��cookie
		Cookie []cookies=request.getCookies();
		
		//����cookie
		for(int i=0;i<cookies.length;i++){
			Cookie cookie=cookies[i];
			out.println("cookie����Ϣ  ����="+cookie.getName()+"  ����="+cookie.getValue());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
