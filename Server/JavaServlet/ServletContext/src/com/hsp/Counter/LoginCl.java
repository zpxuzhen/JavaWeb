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

		//�����Ĭ�ϱ���
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//��ȡServletContext ��������,���ַ�ʽ�����Ի�ȡ
		ServletContext servletContext=this.getServletContext();//��ʽ1  
		//��ȡ�û���id/password/�������֤��
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		//�Ϸ���½�ɹ�
		if("123".equals(password)){
			Integer nums =Integer.parseInt((String) servletContext.getAttribute("nums"));
			//��ServletContext���������
			servletContext.setAttribute("nums",++nums+"");
			//��ת������ҳ��
//			request.getRequestDispatcher("/servlet/Manager").forward(request, response);
			//�ô˷������Է�ֹ�û�����¼��һֱˢ��ҳ��,��ɵļٷ���
			response.sendRedirect("/ServletContext/servlet/Manager");
		}else{
			request.getRequestDispatcher("/servlet/Login").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
