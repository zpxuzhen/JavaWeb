package com.hsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsp.utils.MyTools;

public class GetInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//(���1)��form��post����������
		request.setCharacterEncoding("utf-8");
		
		String u=request.getParameter("username");
		//(���2)��form��get����������(ͬ�������ڳ�����)
		String u1=new String(u.getBytes("iso-8859-1"),"utf-8");
		//������ת�����̷�װ�ɹ�����,������������
		String u2=MyTools.getNewString(u);
				
		System.out.println("u1="+u1+" u2="+u2);
		
		//(���3)�ѽ��յ����ݴ��͸���һ��ҳ��(��ʱ���ݽ�ȥ��uҲҪ��ISO8859-1���룬utf-8�����޷�����)
		response.sendRedirect("/Encoding/Wel?yy1="+u);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
