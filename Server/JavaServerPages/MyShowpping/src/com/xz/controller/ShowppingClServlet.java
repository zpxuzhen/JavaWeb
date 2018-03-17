package com.xz.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.xz.domain.*;
import com.xz.service.*;

//该控制器响应用户购买商品的请求
public class ShowppingClServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//什么时候创建购物车?用户登录成功的时候,现在取出购物车
		MyCart myCart=(MyCart)request.getSession().getAttribute("myCart");
		//接收用户的操作
		String type=request.getParameter("type");
		if("add".equals(type)){
			//接收用户要购买的商品id
			String book_id=request.getParameter("book_id");
			myCart.addBook(book_id);
		}else if("del".equals(type)){
			//接收用户要删除的商品id
			String book_id=request.getParameter("book_id");
			myCart.delBook(book_id);
		}else if("update".equals(type)){
			//用户希望更新
			//得到希望更新的书号
			String []bookIds=request.getParameterValues("book_id");
			//得到希望更新的书的数量
			String []bookNums=request.getParameterValues("book_number");
			for(int i=0;i<bookIds.length;i++){
				//更新购物车
				myCart.updBook(bookIds[i], bookNums[i]);
			}
		}else if("goHall".equals(type)){
			//返回购物大厅
			request.setAttribute("books", new BooksService().getAllBooks());
			request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
			return;
		}else if("look".equals(type)){
			//查看购物车
		}else if("clear".equals(type)){
			//清空购物车
			myCart.clearBook();
		}
		//为了防止页面刷新造成的重复提交,我们可以sendRedirect到1个中间Servlet,准备好数据之后，再去显示
		response.sendRedirect("/MyShowpping/GoShowMyCart");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
