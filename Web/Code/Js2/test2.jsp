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
		function Stu(name,age){
			this.name=name;
			this.age=age;
			this.show=function(){
				window.alert(this.name+" "+this.age);
			}
		}
		function MidStu(name,age){
			this.stu=Stu;
			this.stu(name,age);
			//JS中实际上是通过对象冒充来实现继承，这句话不可少，因为JS是动态语言，如果不执行，则不能实现继承效果
			
		}
		function Pupil(name,age){
			this.stu=Stu;
			this.stu(name,age);
			//Pupil可以覆盖Stu父类的show方法
			this.show=function(){
				window.alert("hello");
			}
		}
		var midStu=new MidStu("顺平",32);
		midStu.show();
		var pupil=new Pupil("顺平",32);
		pupil.show();
		
		//1.哪个对象实例调用this所在的函数,那么this就代表哪个对象实例
		//2.给类添加方法 用 prototype  但是这种方式不能去访问类的私有变量和方法
	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
