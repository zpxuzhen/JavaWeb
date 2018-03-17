<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/comm.css">

</head>

<body>
	<h1>登录界面</h1>
	<form action="/MyShowpping/GoHallUI" method="post">
		<table border="1px">
			<tr>
				<td>用户ID:</td>
				<td><input type="text" name="user_id" /></td>
			</tr>
			<tr>
				<td>密&nbsp;码:</td>
				<td><input type="password" name="user_pwd" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="login" value="登录系统" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"
					name="clean" value="清空重输" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
