package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.User;
import com.xz.tools.SQLHelper;

public class ManagerUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		//�����û�
		out.println("<h1>��ӭ�����û��������</h1>"); 
		//�����ݿ���ȡ���û����ݲ���ʾ
		SQLHelper sqlHelper=(SQLHelper) request.getSession().getAttribute("sqlHelper");;
		String sql="select * from users";
		try {
			ResultSet rs=sqlHelper.executeQuery(sql, null);
			out.println("<table border=1 width=500px>"); 
			out.println("<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th></tr>"); 
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+
						"</td><td>"+rs.getString(2)+
						"</td><td>"+rs.getString(3)+
						"</td><td>"+rs.getString(4)+
						"</td></tr>"); 
			}
			out.println("</table>"); 
		} catch (SQLException e) {
			e.printStackTrace();
			//�׳�����ʱ�쳣
			throw new RuntimeException(e.getMessage());
		}finally{
			sqlHelper.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
