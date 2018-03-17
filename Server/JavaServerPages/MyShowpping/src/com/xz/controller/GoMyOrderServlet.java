package com.xz.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

public class GoMyOrderServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//�����û��鿴����������
		//�õ����ﳵ
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		//�����¸�ҳ��Ҫ��ʾ�����ݣ�׼����ʾ
		request.setAttribute("books", myCart.showMyCart());
		request.setAttribute("totalPrice", myCart.getTotalPrice());
		//��ת����ʾ�ҵĶ�����ҳ��
		request.getRequestDispatcher("/WEB-INF/showMyOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
