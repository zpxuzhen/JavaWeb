package com.hsp.Counter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitServlet extends HttpServlet {

	public void destroy() {
		System.out.println("init servlet destory()������..");
		FileWriter filewriter=null;
		BufferedWriter bufferedWriter=null;
		//��ServletContextֵ���±��浽�ļ�.
		//��record.txt�ļ��У���ȡ�����
		//1.���ȵõ����ļ���ʵ·��
		String filePath=this.getServletContext().getRealPath("record.text");
		//2.���ļ�
		try {
			filewriter=new FileWriter(filePath);
			//Ϊ�˶�ȡ����תΪBufferedReader
			bufferedWriter=new BufferedWriter(filewriter);
			//��ServletContext��ȡ������
			String nums=(String) this.getServletContext().getAttribute("nums");
			//����д���ļ�
			bufferedWriter.write(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//һ��Ҫ�ر���
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
		//��record.txt�ļ��У���ȡ�����
		//1.���ȵõ����ļ���ʵ·��
		String filePath=this.getServletContext().getRealPath("record.text");
		//2.���ļ�
		try {
			fileReader=new FileReader(filePath);
			//Ϊ�˶�ȡ����תΪBufferedReader
			bufferedReader=new BufferedReader(fileReader);
			String nums=bufferedReader.readLine();
			//��nums��ӵ�Servletcontext
			this.getServletContext().setAttribute("nums", nums);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//һ��Ҫ�ر���
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
