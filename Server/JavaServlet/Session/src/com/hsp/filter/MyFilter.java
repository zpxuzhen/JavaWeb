package com.hsp.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*未测试，这段没有视频讲解*/

public class MyFilter extends HttpServlet  implements Filter {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.print("myfilter1...");
		//获取session
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		//看看请求的资源是什么
		String uri=httpServletRequest.getRequestURI();
		if(uri.startsWith("/UsersManager3/imgs")||uri.startsWith("/UsersManager3/Login")){
			//直接放行.
			chain.doFilter(request, response);
		}else{
			HttpSession session=httpServletRequest.getSession();
			User user=(User) session.getAttribute("loginuser");
			if(user!=null){
				//该用户合法,放行
				chain.doFilter(request, response);	
			}else{
				request.setAttribute("err", "请好好登陆");
				httpServletRequest.getRequestDispatcher("/LoginServlet")
				.forward(request, response);
			}
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
