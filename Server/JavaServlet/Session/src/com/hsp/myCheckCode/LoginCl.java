package com.hsp.myCheckCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�����Ĭ�ϱ���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��ȡ�û���id/password/�������֤��
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		//�ȿ���֤�룬�������ݿ�ѹ��
		String checkcode2=(String) request.getSession().getAttribute("checkcode");
		if(checkcode.equals(checkcode2)){
			//��֤��OK
			out.println("��֤��OK");
			//�ɹ�֮����ȥ��֤id��password
		}else{
			//��֤��ERROR
			out.println("��֤��ERROR");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
