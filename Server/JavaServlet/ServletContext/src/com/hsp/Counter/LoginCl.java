package com.hsp.Counter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//浏览器默认编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//获取ServletContext 对象引用,两种方式都可以获取
		ServletContext servletContext=this.getServletContext();//方式1  
		//获取用户的id/password/输入的验证码
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		//合法登陆成功
		if("123".equals(password)){
			Integer nums =Integer.parseInt((String) servletContext.getAttribute("nums"));
			//向ServletContext中添加属性
			servletContext.setAttribute("nums",++nums+"");
			//跳转到管理页面
//			request.getRequestDispatcher("/servlet/Manager").forward(request, response);
			//用此方法可以防止用户不登录而一直刷新页面,造成的假访问
			response.sendRedirect("/ServletContext/servlet/Manager");
		}else{
			request.getRequestDispatcher("/servlet/Login").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
