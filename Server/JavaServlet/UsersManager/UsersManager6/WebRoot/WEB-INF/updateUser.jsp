<%@ page language="java" import="java.util.*,com.xz.domain.*" pageEncoding="UTF-8"%>

<!-- 引入jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<h1>修改用户信息</h1>
		<form action='/UsersManager6/servlet/UserClServlet?type=update' method='post'>
		<table border=1px width=500px>
		<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>PASSWORD</th></tr>
		<tr><td><input type='text' style='text-align:center' name='id' readonly value='${userinfo.user_id}'></td>
		<td><input type='text' style='text-align:center' name='username' value='${userinfo.user_name}'></td>
		<td><input type='text' style='text-align:center' name='email' value='${userinfo.user_email}'></td>
		<td><input type='text' style='text-align:center' name='grade' value='${userinfo.user_grade}'></td>
		<td><input type='text' style='text-align:center' name='password' value='${userinfo.user_pwd}'></td></tr>
		</table><br>
		<input type='submit' style='font-size:20px' value='修改用户'/>
		<input type='reset' style='font-size:20px' value='重新填写'/>
		</form>
  </body>
</html>
