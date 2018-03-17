package com.xz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xz.domain.Users;
import com.xz.service.BooksService;
import com.xz.service.MyCart;
import com.xz.service.UsersService;

public class GoShowMyCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 放入下个页面要显示的数据，准备显示
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		request.setAttribute("books", myCart.showMyCart());
		request.setAttribute("totalPrice", myCart.getTotalPrice());
		// 跳转到显示我的购物车
		request.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
