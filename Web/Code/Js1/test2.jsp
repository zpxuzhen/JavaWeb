<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  	 <!----js代码是放在head标签间,但实际上也可以放在别的位置--> 
	 <script language="javascript">
		 //js中变量的定义（js中变量用var表示，无论什么类型）
		 var num1=1;
		 var num2=60;
		 var result=num1+num2;
		 window.alert("结果是"+result);          //alert函数    window.alert表示弹出一个对话框
	 </script>

  </head>
  
  <body>
  </body>
</html>
