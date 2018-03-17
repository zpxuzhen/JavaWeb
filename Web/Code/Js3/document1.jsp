<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'document1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" language="javascript">
	
	//1.如何动态的创建html元素
	
	function test(){
		//创建元素
		//写希望创建的元素的标签名字
		var myElement=document.createElement("a");
		var myElement2=document.createElement("input");
		//给新的元素添加必要的信息
		myElement.href="http://www.baidu.com";
		myElement.innerText="连接到百度";
		myElement.id="id1";
		myElement2.type="button";
		myElement2.value="我是按钮";
		//可以指定位置
		/*myElement.style.left="200px";
		myElement.style.top="300px";
		myElement.style.position="absolute";
		//将元素添加到document.body上去
		document.body.appendChild(myElement);*/
		//将元素添加到div上去
		document.getElementById("div").appendChild(myElement);
		document.getElementById("div").appendChild(myElement2);
	}
		
	//2.动态的删除document文档中的元素
		function test2(){
			 //删除一个元素(删除一个元素的是有前提的：必须获得父元素)
			 //这是第一种方法(不灵活)
			 //document.getElementById("div").removeChild(document.getElementById("id1"));
			 //第二种方法比较灵活（推荐）这种方法不知道父元素id也能获得父元素
			 //window.alert(document.getElementById("id1").parentNode.id);//测试可以返回父元素id
			 document.getElementById("id1").parentNode.removeChild(document.getElementById("id1"));  
		}
	
	
	</script>

  </head>
  
  <body>
    <input type="button" onclick="test()" value="动态的创建一个超链接">
    <input type="button" value="删除一个元素id为id1的" onclick="test2()"/>
	<div id="div" style="width:100px;height:300px;border=1px solid red"></div>

  </body>
</html>
