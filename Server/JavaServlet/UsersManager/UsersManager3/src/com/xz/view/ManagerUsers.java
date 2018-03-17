package com.xz.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		out.println("<script type='text/javascript' language='javascript'>");
		//_self在本页面打开
		out.println("function gotopageNow(pageCount){"
				+ "var pageNow=document.getElementById('pageNow').value;"
				+"if(pageNow>=1 && pageNow <=pageCount)"
				+ "window.open('/UsersManager3/servlet/ManagerUsers?pageNow='+pageNow,'_self');"
				+ "}");
		out.println("</script>");

		//管理用户
		out.println("<h1>欢迎来到用户管理界面</h1>"); 
		
		//定义分页需要的变量
		int pageNow=1;   //表示第几页,该变量是由用户来决定,因此变化
		//接收用户的pageNow
		String sPageNow=request.getParameter("pageNow");
		if(sPageNow != null) 	pageNow=Integer.parseInt(sPageNow);
		int pageSize=2;	 //每页显示几条记录,由程序指定,也可以由用户定制
		int rowCount=1;   //共有多少条记录,该变量是查询数据库得到
		int pageCount=(rowCount-1)/pageSize+1;   //表示共有多少页
		
		//数据库
		SQLHelper sqlHelper=(SQLHelper) request.getSession().getAttribute("sqlHelper");;
		
		//查询总共有多少页
		try {
			Connection ct=sqlHelper.getConnection();
			PreparedStatement ps=ct.prepareStatement("select count(*) from users");;
			ResultSet rs=ps.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
			pageCount=(rowCount-1)/pageSize+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlHelper.close();
		}
		
		//从数据库中取出用户数据并显示
		String sql="select * from (select t.*,  rownum rn from (select * from users order by id) t where rownum<="+(pageSize*pageNow)+") where rn>="+(pageSize*(pageNow-1)+1);
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
			out.println("</table><br>"); 
			//显示分页
			if(pageNow>1)
				out.println("<a href='/UsersManager3/servlet/ManagerUsers?pageNow="+(pageNow-1)+"'><上一页></a>"); 
			if(pageNow>10)
				out.println("&nbsp;<a href='/UsersManager3/servlet/ManagerUsers?pageNow="+(pageNow-10)+"'><<</a>&nbsp;"); 
			for(int i=(pageNow-1)/10*10+1;i<=pageCount && i<=(pageNow-1)/10*10+10;i++){
				out.println("<a href='/UsersManager3/servlet/ManagerUsers?pageNow="+i+"'><"+i+"></a>"); 
			}
			if(((pageNow-1)/10)<((pageCount-1)/10))
				out.println("&nbsp;<a href='/UsersManager3/servlet/ManagerUsers?pageNow="+(pageNow+10)+"'>>></a>&nbsp;"); 
			if(pageNow<pageCount)
				out.println("<a href='/UsersManager3/servlet/ManagerUsers?pageNow="+(pageNow+1)+"'><下一页></a>"); 
			out.println("&nbsp;<当前第"+pageNow+"页><总共"+pageCount+"页>&nbsp;"); 
			out.println("&nbsp;&nbsp;<跳转到第<input id='pageNow' style='width:30px' type='text' name='pageNow'>页></a>"); 
			out.println("<input type='button' value='Go' onClick='gotopageNow("+pageCount+")'>"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
			//抛出运行时异常
			throw new RuntimeException(e.getMessage());
		}finally{
			sqlHelper.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
