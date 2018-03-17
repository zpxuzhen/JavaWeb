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
	 	var weights=[3,5,1,3.4,2,50];
		var allweights=0;
		//数组的遍历
		for(var i=0;i<weights.length;i++){
		allweights+=weights[i];
		}
		document.writeln("总体重是"+allweights);
		var avgweight=allweights/weights.length;
		//如果你想知道数据类型是什么
		//window.alert(avgweight.constructor);
		//window.alert( typeof avgweight);
		document.writeln("平均体重是"+avgweight.toFixed(2));//保留两位小数
	 
	 </script>

  </head>
  
  <body>
  </body>
</html>
