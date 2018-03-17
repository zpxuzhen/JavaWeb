package com.xz.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.xz.domain.User;
import com.xz.tools.SQLHelper;

public class LoginClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		//�����û��ύ���û���������
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		System.out.println("�û�ID : "+id+"���� : "+password);
		if(id.equals("") || password.equals("") ){
			request.getSession().setAttribute("error","�û�ID�������벻��Ϊ��"); 
			request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
		}else{
			//�����ݿ���ȥ��֤
			String path=this.getClass().getResource("/").getPath()+"com/xz/tools/dbinfo.properties";
			SQLHelper sqlHelper=new SQLHelper(path);
			String sql="select * from users where id=? and passwd=?";
			String[] parameters={id,password};
			try {
				ResultSet rs=sqlHelper.executeQuery(sql, parameters);
				if(rs.next()){
					//session()���Դ��ݶ������һ��ҳ��
					User user=new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(password);
					request.getSession().setAttribute("userObj",user); 
					request.getSession().setAttribute("sqlHelper",sqlHelper); 
					request.getSession().setAttribute("error","");
					request.getRequestDispatcher("/servlet/MainFrame").forward(request, response);
				}else{
					request.getSession().setAttribute("error","�û�ID�����������"); 
					request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
				}	
			} catch (SQLException e) {
				request.getSession().setAttribute("error","�û�IDֻ��������"); 
				request.getRequestDispatcher("/servlet/LoginServlet").forward(request, response);
			}finally{
				sqlHelper.close();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
