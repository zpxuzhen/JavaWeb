<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test5.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	  <script language="javascript">
		  function test3(e){
			var pic=document.getElementById("pic");
			if(e.value=="红色"){
				pic.style.backgroundColor="red";
			}
			else if(e.value=="黑色"){
				pic.style.backgroundColor="black";
			}
		  }
	  
	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
    <div id="pic" style="border:1;background-color:red;width:300px;height:300px"></div>
	<input type="button" onclick="test3(this)" value="红色">
	<input type="button" onclick="test3(this)" value="黑色">
    
  </body>
</html>
