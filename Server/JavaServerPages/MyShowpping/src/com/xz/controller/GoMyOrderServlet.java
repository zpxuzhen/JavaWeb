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
		
		//处理用户查看订单的请求
		//得到购物车
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		//放入下个页面要显示的数据，准备显示
		request.setAttribute("books", myCart.showMyCart());
		request.setAttribute("totalPrice", myCart.getTotalPrice());
		//跳转到显示我的订单的页面
		request.getRequestDispatcher("/WEB-INF/showMyOrder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}
}
