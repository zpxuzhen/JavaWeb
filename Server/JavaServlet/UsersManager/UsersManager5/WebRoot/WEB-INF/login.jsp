<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>My JSP 'login.jsp' starting page</title>

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
	<h1>用户登录</h1>
	<form action='/UsersManager5/servlet/LoginClServlet' method='post'>
		用户ID:<input type='text' name='id' /></br> 
		密&nbsp;码:<input type='password' name='password' /></br> 
		<input type='submit' value='登陆' />
	</form>
</body>
</html>
