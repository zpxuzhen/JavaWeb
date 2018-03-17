<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test7.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	  <script language="javascript">
	  
		var dog={name:"hello"};
		function test(){
			window.alert(this.name);
		}
		test.call(dog);//==dog.test;  输出：hello
		
		
		var dog={
			name:"小明",
			fun1:function(){window.alert("hello");}
		};
		//循环列出 dog对象的所有属性和方法 对象名["属性名"]
		for(var key in dog){
			window.alert(key+":"+dog[key]);   // key属性 dog[key]属性值
		}
		//遍历window对象的所有属性
		for(var key in window){
			document.write(key+":"+window[key]+"</br>");
		}

	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
