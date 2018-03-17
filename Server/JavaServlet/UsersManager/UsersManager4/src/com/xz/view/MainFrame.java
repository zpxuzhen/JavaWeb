package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xz.domain.User;

public class MainFrame extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//ÿ���ط���Ҫ������������Է�װ�ɺ���������ʹ�ù�����
		//ȡ��session��login�����ܽ��뵽���ҳ��
		User user=(User) request.getSession().getAttribute("login");
		if(user==null){
			//���ص���¼����
			request.setAttribute("err", "�������û��������¼"); 
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
			return;
		}

		//��ȡ��¼�û���Ϣ
		out.println("<h1>��ӭ����������</h1>"); 
		out.println("��ǰ��¼���û���:"+user.getId()+"<br>"); 
		out.println("<h3>��ѡ����Ҫ���еĲ���</h3>"); 
		out.println("<a href='/UsersManager4/servlet/ManagerUsers'>�����û�</a><br>");
		out.println("<a href='/UsersManager4/servlet/AddUserView'>����û�</a><br>");
		out.println("<a href='#'>�����û�</a><br>");
		out.println("<a href='/UsersManager4/servlet/LoginServlet'>�˳�ϵͳ</a><br>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
