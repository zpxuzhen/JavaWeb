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
			//Ҫȥ�����û��Ľ���
			int pageNow = 1; //��ǰҳ
			String sPageNow = request.getParameter("pageNow");
			if (sPageNow != null) pageNow = Integer.parseInt(sPageNow);
			int pageSize= 5; // ÿҳ��ʾ������¼,�ɳ���ָ��,Ҳ�������û����� 
			int rowCount = usersService.getUsersCount(); // ���ж�������¼,�ñ����ǲ�ѯ���ݿ�õ�
			int pageCount = (rowCount - 1) / pageSize + 1; // ��ʾ���ж���ҳ
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("rowCount", rowCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("getPage", usersService.getUsersByPage(pageNow, pageSize));
			request.getRequestDispatcher("/WEB-INF/managerUsers.jsp").forward(request, response);
		}else if("gotoUpdateView".equals(type)){
			//Ҫȥ�޸��û��Ľ���
			int id=Integer.parseInt(request.getParameter("userId"));
			User user=usersService.getUserById(id);
			//Ϊ������һ��Servletʹ�����ǵ�user�������ǿ��԰Ѹ�user�������request��
			request.setAttribute("userinfo", user);
			request.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(request, response);
		}else if("gotoAddUserView".equals(type)){
			//Ҫȥ����û��Ľ���
			request.getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
		}else if("gotoMainFrameView".equals(type)){
			//Ҫȥ������
			request.getRequestDispatcher("/WEB-INF/mainFrame.jsp").forward(request, response);
		}else if("gotoLogin".equals(type)){
			//Ҫȥ��¼����
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
	
}
