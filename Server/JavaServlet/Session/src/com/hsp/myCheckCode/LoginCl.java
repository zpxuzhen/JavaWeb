package com.hsp.myCheckCode;

import java.io.IOException;
import java.io.PrintWriter;

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
		//获取用户的id/password/输入的验证码
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		//先看验证码，减轻数据库压力
		String checkcode2=(String) request.getSession().getAttribute("checkcode");
		if(checkcode.equals(checkcode2)){
			//验证码OK
			out.println("验证码OK");
			//成功之后再去验证id和password
		}else{
			//验证码ERROR
			out.println("验证码ERROR");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
