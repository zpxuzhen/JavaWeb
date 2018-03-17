package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;
import com.xz.service.UsersService;

public class UpdateUserView extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�ӿ��������ݵ�User����
		User user = (User) request.getAttribute("userinfo");
		// ��ʾ
		out.println("<h1>�޸��û���Ϣ</h1>");
		out.println("<form action='/UsersManager4/servlet/UserClServlet?type=update' method='post'>");
		out.println("<table border=1px width=500px>");
		out.println("<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>PASSWORD</th></tr>");
		out.println("<tr><td><input type='text' style='text-align:center' name='id' readonly value='" + user.getId() 
				+ "'></td><td><input type='text' style='text-align:center' name='username' value='" + user.getUsername() 
				+ "'></td><td><input type='text' style='text-align:center' name='email' value='" + user.getEmail()
				+ "'></td><td><input type='text' style='text-align:center' name='grade' value='" + user.getGrade() 
				+ "'></td><td><input type='text' style='text-align:center' name='password' value='" + user.getPassword() 
				+ "'></td></tr>");
		out.println("</table><br>");
		out.println("<input type='submit' style='font-size:20px' value='�޸��û�'>"
				+ "<input type='reset' style='font-size:20px' value='������д'>");
		out.println("</form>");
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
