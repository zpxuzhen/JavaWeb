<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	 <script language="javascript">
		var num1=123;
		var num2="abcd";
		window.alert("num1是"+typeof num1);                                  
		window.alert("num2是"+typeof num2);
		var num1=false;                                  //体现js是动态语言：即数据类型可以任意变化
		window.alert("num1是"+typeof num1);    			 //体现js是动态语言
	 </script>

  </head>
  
  <body>
  </body>
</html>
