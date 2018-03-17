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
		
		//先获取cookie
		Cookie []cookies=request.getCookies();
		//假设我们保存上次登录时间的cookie    "2017-03-18 23:08:30"
		String lasttime="";
		//保证有cookie才去遍历
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
			out.println("欢迎您第一次登录");
		}else{
			out.println("你上次登录的时间是"+lasttime);
		}
		
		//把当前日期保存到Cookie
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=simpleDateFormat.format(new java.util.Date());

		Cookie cookie=new Cookie("lasttime", nowTime);
		//设置cookie的生命周期,保存一周
		cookie.setMaxAge(3600*24*7);
		//把cookie信息回写给浏览器
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
