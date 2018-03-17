<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test1.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	  <script language="javascript">
	  
		function Person(name,age,sal){
			this.name=name;//公开的属性
			var age=age;//私有的属性
			var sal=sal;//私有的属性
			//在类中如何定义公开方法（特权方法），私有方法（内部方法）
			//如果我们希望操作私有的属性则可用公开方法去实现
			this.show=function(){
				window.alert(age+" "+sal );
			}
			//私有方法,可以访问对象的属性
			function show2(){
				window.alert(age+sal);
			}
		}
		var p1=new Person("sp",30,4000);
		p1.show();//这个可以成功//不能在类的外部去访问私有的方法
		p1.show2();//不能在类的外部去访问私有的方法
		
		
	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
