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
	  /*
		//0) 	这里就是一个Cat类
			function Cat(){
			
			}
			//这时cat1就是一个对象
			var cat1=new Cat();
			cat1.name="小白";
			cat1.age=3;
			cat1.color="白色";
			//从上面的代码我们可以看出
			//1.JS中的对象的属性可以动态的添加
			//2.属性没有限制
			window.alert(cat1.name);
		
		
		//1）	JS中一切都是对象
			function Person(){}
			window.alert(Person.constructor);
			var a=new Person();
			window.alert(a.constructor);//对象实例的构造函数
			window.alert(typeof a);//a的类型是什么
			var b=123;
			window.alert(b.constructor);
		
		//2)	如何判断一个对象实例是不是某个类型
		//方法1：
		if(a instanceof Person){
		window.alert("a是Person");
		}
		//方法2：
		if(a.constructor==Person){
		window.alert("a是Person");
		}
		
		//3)	补充说明：带var和不带var的区别
		var abc=89;//全局变量
		function test(){
		//在函数里，如果不带var表示使用全局变量abc，如果带上var则表示，在函数里定义了一个新的abc变量
		abc=900;
		//var abc=900;
		}
		test();
		//输出900。如果改为var abc=900，则输出89
		window.alert(abc);   
		
		
		*/
		
	</script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
