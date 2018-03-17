package com.xz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;
import com.xz.service.UsersService;

public class GotoViewClServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String type=request.getParameter("type");
		UsersService usersService=new UsersService();
		
		if("gotoManagerUsersView".equals(type)){
			//要去管理用户的界面
			int pageNow = 1; //当前页
			String sPageNow = request.getParameter("pageNow");
			if (sPageNow != null) pageNow = Integer.parseInt(sPageNow);
			int pageSize= 5; // 每页显示几条记录,由程序指定,也可以由用户定制 
			int rowCount = usersService.getUsersCount(); // 共有多少条记录,该变量是查询数据库得到
			int pageCount = (rowCount - 1) / pageSize + 1; // 表示共有多少页
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("rowCount", rowCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("getPage", usersService.getUsersByPage(pageNow, pageSize));
			request.getRequestDispatcher("/WEB-INF/managerUsers.jsp").forward(request, response);
		}else if("gotoUpdateView".equals(type)){
			//要去修改用户的界面
			int id=Integer.parseInt(request.getParameter("userId"));
			User user=usersService.getUserById(id);
			//为了让下一个Servlet使用我们的user对象，我们可以把该user对象放入request中
			request.setAttribute("userinfo", user);
			request.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(request, response);
		}else if("gotoAddUserView".equals(type)){
			//要去添加用户的界面
			request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
		}else if("gotoMainFrameView".equals(type)){
			//要去主界面
			request.getRequestDispatcher("/WEB-INF/mainFrame.jsp").forward(request, response);
		}else if("gotoLogin".equals(type)){
			//要去登录界面
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
	
}
