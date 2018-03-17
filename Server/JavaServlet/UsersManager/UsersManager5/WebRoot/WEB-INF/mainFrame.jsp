<%@ page language="java" import="java.util.*,com.xz.domain.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
 
    <title>My JSP 'mainFrame.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
		//取出session的login，才能进入到这个页面
		User loginUser=(User) session.getAttribute("loginUser");
		/****此处添加过滤器****/
	%>
		<h1>欢迎来到主界面</h1> 
		当前登录的用户是:<%=loginUser.getUser_name() %><br>
		<h3>请选择您要进行的操作</h3>
		<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView'>管理用户</a><br>
		<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoAddUserView'>添加用户</a><br>
		<a href='#'>查找用户</a><br>
		<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoLogin'>退出系统</a><br>
  </body>
</html>
