<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
 
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
    <h1>添加用户信息</h1>
		<form action='/UsersManager6/servlet/UserClServlet?type=add' method='post'>
		<table border=1px width=500px>
		<tr><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>PASSWORD</th></tr>
		<tr>
				<td><input type='text' style='text-align:center' name='username'></td>
				<td><input type='text' style='text-align:center' name='email'></td>
				<td><input type='text' style='text-align:center' name='grade'></td>
				<td><input type='text' style='text-align:center' name='password'></td>
				</tr>
		</table><br>
		<input type='submit' style='font-size:20px' value='添加用户'/>
				<input type='reset' style='font-size:20px' value='重新填写'/>
		</form>
  </body>
</html>
