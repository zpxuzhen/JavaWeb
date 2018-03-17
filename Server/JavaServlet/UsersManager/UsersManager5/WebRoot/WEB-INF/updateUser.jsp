<%@ page language="java" import="java.util.*,com.xz.domain.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
 
    <title>My JSP 'updateUser.jsp' starting page</title>
    
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
    	// 获取从控制器传递的User对象
		User user = (User) request.getAttribute("userinfo");
    %>
		<h1>修改用户信息</h1>
		<form action='/UsersManager5/servlet/UserClServlet?type=update' method='post'>
		<table border=1px width=500px>
		<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>PASSWORD</th></tr>
		<tr><td><input type='text' style='text-align:center' name='id' readonly value='<%=user.getUser_id() %>'></td>
		<td><input type='text' style='text-align:center' name='username' value='<%=user.getUser_name() %>'></td>
		<td><input type='text' style='text-align:center' name='email' value='<%=user.getUser_email() %>'></td>
		<td><input type='text' style='text-align:center' name='grade' value='<%=user.getUser_grade() %>'></td>
		<td><input type='text' style='text-align:center' name='password' value='<%=user.getUser_pwd() %>'></td></tr>
		</table><br>
		<input type='submit' style='font-size:20px' value='修改用户'/>
		<input type='reset' style='font-size:20px' value='重新填写'/>
		</form>
		
  </body>
</html>
