package com.xz.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

public class GoHallUI extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//得到从登录页面传递的用户ID和密码
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		//创建一个user对象
		Users loginUser=new Users(Integer.parseInt(user_id),user_pwd);
		//使用业务逻辑类完成验证
		UsersService usersService=new UsersService();
		if(usersService.checkUser(loginUser)){
			//说明是合法用户,跳转到购物大厅
			//因为用户信息可能在很多页面使用，因此 放入session
			request.getSession().setAttribute("loginUser", loginUser);
			//给下一个页面hall.jsp准备好要显示的数据(生命周期一次请求有效)
			request.setAttribute("books", new BooksService().getAllBooks());
			//将购物车放入session(生命周期一直持续到用户关闭浏览器)
			request.getSession().setAttribute("myCart", new MyCart());
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		}else{
			//说明不是合法用户,返回原页面
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
