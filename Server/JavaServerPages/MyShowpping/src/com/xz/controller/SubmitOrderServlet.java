package com.xz.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

public class SubmitOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		MyCart myCart=(MyCart) request.getSession().getAttribute("myCart");
		Users loginUser=(Users) request.getSession().getAttribute("loginUser");
		OrderService orderService=new OrderService();;
		//�����¶���������
		if(orderService.submitOrder(myCart, loginUser)){
			//����Email,��֪�û�
			
			//�����ύ�ɹ�����չ��ﳵ
			myCart.clearBook();
			request.getRequestDispatcher("/WEB-INF/orderOk.jsp").forward(request, response);
		}else{
			
			request.getRequestDispatcher("/WEB-INF/errorInfo.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
