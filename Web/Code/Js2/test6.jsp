<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test6.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="test6.css">

	
	  <script language="javascript">
		function test3(e){
			//取连接的第一个css文件的内容用0
			var ocssRules=document.styleSheets[0].rules;
			//从ocssRules取出你希望的样式
			var style=ocssRules[0];//这里面的0表示test6.css文件中第一个规则
			if(e.value=="黑色"){
				style.style.backgroundColor="black";
			}
			else if(e.value=="红色"){
				style.style.backgroundColor="red";
			}
		}
		
		function test1(e){
			window.alert(e.value);
		}
		


	  
	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
   	<div class="style"></div>
	<input type="button" onclick="test3(this),test1(this)" value="红色">
	<input type="button" onclick="test3(this),test1(this)" value="黑色">

    
  </body>
</html>
