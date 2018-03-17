<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test4.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<!-- 调用其他文件中的函数 -->
	 <script language="javascript" src="myFunction.js"></script>
	 <script type="text/javascript" language="javascript">
	 	var num1=window.prompt("请输入一个数");
		var num2=window.prompt("请再输入一个数");
		num1=parseFloat(num1);
		num2=parseFloat(num2);
		var operator=window.prompt("请输入一个运算符");
		var res=jiSuan(num1,num2,operator);
		document.write("结果是"+res);
		var res=abc2(num1,num2);
		document.write("num1+num2是"+res);
	 </script>

  </head>
  
  <body>
  </body>
</html>
