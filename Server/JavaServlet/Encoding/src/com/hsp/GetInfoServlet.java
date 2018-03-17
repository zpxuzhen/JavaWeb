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
		
		//(情况1)表单form的post乱码解决方法
		request.setCharacterEncoding("utf-8");
		
		String u=request.getParameter("username");
		//(情况2)表单form的get乱码解决方法(同样适用于超链接)
		String u1=new String(u.getBytes("iso-8859-1"),"utf-8");
		//将上面转换过程封装成工具类,用起来更方便
		String u2=MyTools.getNewString(u);
				
		System.out.println("u1="+u1+" u2="+u2);
		
		//(情况3)把接收的数据传送给下一个页面(此时传递进去的u也要是ISO8859-1编码，utf-8编码无法传递)
		response.sendRedirect("/Encoding/Wel?yy1="+u);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
