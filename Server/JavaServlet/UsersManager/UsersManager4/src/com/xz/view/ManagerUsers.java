package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;
import com.xz.service.UsersService;
import com.xz.tools.SQLHelper;

public class ManagerUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript' language='javascript'>");
		// _self�ڱ�ҳ���
		out.println("function gotopageNow(pageCount){" + "var pageNow=document.getElementById('pageNow').value;"
				+ "if(pageNow>=1 && pageNow <=pageCount)"
				+ "window.open('/UsersManager4/servlet/ManagerUsers?pageNow='+pageNow,'_self');" + "}");
		out.println("function confirmDel(){return window.confirm('���Ҫɾ�����û���?');}");
		out.println("</script>");

		// �����û�
		out.println("<h1>��ӭ�����û��������</h1>");

		// �����ҳ��Ҫ�ı���
		int pageNow = 1; // ��ʾ�ڼ�ҳ,�ñ��������û�������,��˱仯
		// �����û���pageNow
		String sPageNow = request.getParameter("pageNow");
		if (sPageNow != null)
			pageNow = Integer.parseInt(sPageNow);
		int pageSize = 5; // ÿҳ��ʾ������¼,�ɳ���ָ��,Ҳ�������û�����
		int rowCount = 1; // ���ж�������¼,�ñ����ǲ�ѯ���ݿ�õ�
		int pageCount = (rowCount - 1) / pageSize + 1; // ��ʾ���ж���ҳ

		UsersService usersService = new UsersService();
		rowCount = usersService.getUsersCount();
		pageCount = (rowCount - 1) / pageSize + 1;
		ArrayList<User> arrayList = usersService.getUsersByPage(pageNow, pageSize);

		// ��ʾ�û�����
		out.println("<table border=1 width=500px>");
		out.println("<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>�h���Ñ�</th><th>�޸��Ñ�</th></tr>");
		for (User user : arrayList) {
			out.println("<tr><td>" + user.getId() + "</td><td>" + user.getUsername() 
					+ "</td><td>" + user.getEmail()+ "</td><td>" + user.getGrade() + "</td>"
					+ "<td><a onClick='return confirmDel();' href='/UsersManager4/servlet/UserClServlet?type=del&userId="+ user.getId() + "'>�h���Ñ�</a></td>"
					+ "<td><a href='/UsersManager4/servlet/UserClServlet?type=gotoUpdateView&userId="+ user.getId() + "'>�޸��Ñ�</a></td></tr>");
		}
		out.println("</table><br>");
		// ��ʾ��ҳ
		if (pageNow > 1)
			out.println("<a href='/UsersManager4/servlet/ManagerUsers?pageNow=" + (pageNow - 1) + "'><��һҳ></a>");
		if (pageNow > 10)
			out.println(
					"&nbsp;<a href='/UsersManager4/servlet/ManagerUsers?pageNow=" + (pageNow - 10) + "'><<</a>&nbsp;");
		for (int i = (pageNow - 1) / 10 * 10 + 1; i <= pageCount && i <= (pageNow - 1) / 10 * 10 + 10; i++) {
			out.println("<a href='/UsersManager4/servlet/ManagerUsers?pageNow=" + i + "'><" + i + "></a>");
		}
		if (((pageNow - 1) / 10) < ((pageCount - 1) / 10))
			out.println(
					"&nbsp;<a href='/UsersManager4/servlet/ManagerUsers?pageNow=" + (pageNow + 10) + "'>>></a>&nbsp;");
		if (pageNow < pageCount)
			out.println("<a href='/UsersManager4/servlet/ManagerUsers?pageNow=" + (pageNow + 1) + "'><��һҳ></a>");
		out.println("&nbsp;<��ǰ��" + pageNow + "ҳ><�ܹ�" + pageCount + "ҳ>&nbsp;");
		out.println("&nbsp;&nbsp;<��ת����<input id='pageNow' style='width:30px' type='text' name='pageNow'>ҳ></a>");
		out.println("<input type='button' value='Go' onClick='gotopageNow(" + pageCount + ")'>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
