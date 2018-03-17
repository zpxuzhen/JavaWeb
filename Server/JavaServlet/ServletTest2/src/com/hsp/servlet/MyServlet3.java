package com.hsp.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//这个需要注释掉，getWriter()和getOutputStream()这两个流不能同时使用
//		PrintWriter out = response.getWriter();
		
		//演示下载文件
		response.setHeader("Content-Disposition", "attachment; filename=Winter.jpg");
		//打开文件.说明一下web 站点下载文件的原理
		//1.获取到要下载文件的全路径
		String path=this.getServletContext().getRealPath("/images/Winter.jpg");
		//System.out.println("path="+path);
		//2创建文件输入流
		FileInputStream fis=new FileInputStream(path);
		//做一个缓冲字节数组
		byte buff[]=new byte[1024];
		int len=0;//表示实际每次读取了多个个字节
		OutputStream os=response.getOutputStream();
		while((len=fis.read(buff))>0){	
			os.write(buff, 0, len);
		}
		//缺点: 没有进度条./图标/
		//关闭
		os.close();
		fis.close();

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}



}
