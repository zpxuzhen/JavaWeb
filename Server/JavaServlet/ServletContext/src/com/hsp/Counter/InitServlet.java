package com.hsp.Counter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitServlet extends HttpServlet {

	public void destroy() {
		System.out.println("init servlet destory()被调用..");
		FileWriter filewriter=null;
		BufferedWriter bufferedWriter=null;
		//把ServletContext值重新保存到文件.
		//从record.txt文件中，读取浏览量
		//1.首先得到该文件真实路径
		String filePath=this.getServletContext().getRealPath("record.text");
		//2.打开文件
		try {
			filewriter=new FileWriter(filePath);
			//为了读取我们转为BufferedReader
			bufferedWriter=new BufferedWriter(filewriter);
			//从ServletContext读取访问量
			String nums=(String) this.getServletContext().getAttribute("nums");
			//重新写会文件
			bufferedWriter.write(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//一定要关闭流
			try {
				bufferedWriter.close();
				filewriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			filewriter=null;
			bufferedWriter=null;
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		//从record.txt文件中，读取浏览量
		//1.首先得到该文件真实路径
		String filePath=this.getServletContext().getRealPath("record.text");
		//2.打开文件
		try {
			fileReader=new FileReader(filePath);
			//为了读取我们转为BufferedReader
			bufferedReader=new BufferedReader(fileReader);
			String nums=bufferedReader.readLine();
			//把nums添加到Servletcontext
			this.getServletContext().setAttribute("nums", nums);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//一定要关闭流
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileReader=null;
			bufferedReader=null;
		}
	}

}
