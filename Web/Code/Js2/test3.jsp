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
		function Master(){
			this.feed=function(animal,food){
				window.alert("主人给"+animal.name+"喂"+food.name);
			}
		}	
		function Food(name){
			this.name=name;
		}
		function Fish(name){
			this.fish=Food;
			this.fish(name);
		}
		function Bone(name){
			this.bone=Food;
			this.bone(name);
		}
		function Animal(name){
			this.name=name;
		}
		function Cat(name){
			this.cat=Animal;
			this.cat(name);
		}
		function Dog(name){
			this.dog=Animal;
			this.dog(name);
		}
		var master = new Master();
		var cat=new Cat("小猫");
		var fish=new Fish("鱼");
		master.feed(cat,fish);
				
	  </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
