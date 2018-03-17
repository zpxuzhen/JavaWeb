package com.hsp.LoginTime;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//�Ȼ�ȡcookie
		Cookie []cookies=request.getCookies();
		//�������Ǳ����ϴε�¼ʱ���cookie    "2017-03-18 23:08:30"
		String lasttime="";
		//��֤��cookie��ȥ����
		if(cookies!=null){
			for(Cookie cookie:cookies){
				String name=cookie.getName();
				if("lasttime".equals(name)){
					lasttime=cookie.getValue();
					break;
				}
			}
		}
		if("".equals(lasttime)){
			out.println("��ӭ����һ�ε�¼");
		}else{
			out.println("���ϴε�¼��ʱ����"+lasttime);
		}
		
		//�ѵ�ǰ���ڱ��浽Cookie
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=simpleDateFormat.format(new java.util.Date());

		Cookie cookie=new Cookie("lasttime", nowTime);
		//����cookie����������,����һ��
		cookie.setMaxAge(3600*24*7);
		//��cookie��Ϣ��д�������
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
