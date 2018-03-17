package com.hsp.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//Ӧ��:�ص�IE���ٿ�IE���ϴι������Ʒ���ڡ�
		HttpSession session=request.getSession();
		session.setAttribute("username", "�ν�");
		//�Ѹ�session��id���浽cookie��,���ֱ�����Jsessionid
		Cookie cookie=new Cookie("Jsessionid", session.getId());
		cookie.setMaxAge(60*30);
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
