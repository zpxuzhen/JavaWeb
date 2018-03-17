<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'window1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" language="javascript">
	//1)
		function test(){
			var res=window.confirm("你要删除");
			if(res){
				window.alert("删除成功");
			}
			else{
				window.alert("删除失败");
			}
		}
		
	//2)		
		//每隔一秒弹出一个hello,world
		//function sayHello(){
		//	window.alert("hello,world");
		//}
		//setInterval("sayHello()",1000);
		//在网页上显示时间
		//function showTime(){
		//在元素间的文本就是通过 对象.innerText
		//	document.getElementById("mytime").innerText=new Date();
		//}
		//setInterval("showTime()",1000);
		
	//3)
		//10秒时，时钟停止
		//var count=0;
		//function showTime(){
		//	count++;
		//	if(count==10){
		//		clearInterval(time);
		//	}
		//	//在元素间的文本就是通过 对象.innerText
		//	document.getElementById("mytime").innerText=new Date();
		//}
		//var time=setInterval("showTime()",1000);
		
	//4)
		//在打开页面后，5秒钟后弹出hello，world（但是只调用一次）
		//function sayHello(){
		//	window.alert("hello,world");
		//}
		//setTimeout("sayHello()",5000);
	//5)
		//取消Timeout
		function sayHello(){
			window.alert("hello,world");
		}
		var time=setTimeout("sayHello()",5000);
		clearTimeout(time);//取消Timeout
		
	//6)
		//moveTo()   moveBy()
		function test2(){
			//这个是相对于屏幕左上角0，0坐标
			window.moveTo(100,100);
			//这个是相对当前窗口的左上角0，0坐标
			//window.moveBy(100,100);
		}
	//7)
		//resizeBy() 和resizeTo()
		function test3(){
			//把窗口的大小调整到指定的宽度100和高度100。
			//window.resizeTo(100,100); 
			//把窗口再增加100，100
 			window.resizeBy(100,100);
		}
		
	//8)
		//open()开一个新窗口
		//window.open("event1.html","_blank");
	
	//9)
		//父窗口和子窗口通信(opener相当于父窗口）
		 var newWindow;
		  function test4(){
		  	//newWindow其实就是指向新窗口的引用
		  	newWindow=open("newWindow.html","_blank");
		  }
		  function test5(){
		      newWindow.$("myspan2").innerText=$("info2").value; 
		  }
		  function $(id){
		  	return document.getElementById(id);
		  }
		
		
	
		
		
	</script>

  </head>
  
  <body>
    <input type="button" value="delete" onclick="test()">
    <input type="button" value="移动" onclick="test2()">
    <input type="button" value="改变窗口大小" onclick="test3()">
    <span id="mytime"></span>
    <br/><br/>
         我是父窗口
	<input type="button" value="打开新窗口" onclick="test4()"/>
	<input type="text" value="" id="info2"/>
	<input type="button" value="发送给子窗口" onclick="test5()"/><br/><br/>
	<span>接收的信息是：</span>
	<span id="myspan">信息</span>
	<br/><br/>
	

  </body>
</html>
