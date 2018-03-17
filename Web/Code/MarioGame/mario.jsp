<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="mario.css">
	
	<script type="text/javascript" language="javascript">
	//设计Mario类
	function Mario(){
		this.x=0;
		this.y=0;
		//这里为了改变image图片的left和top的值，我们需要先得到img元素
		var mymario=document.getElementById("mymario");
		var left=parseInt(mymario.style.left.substr(0,mymario.style.left.length-2));
		var top=parseInt(mymario.style.top.substr(0,mymario.style.top.length-2));
		var width=parseInt(mymario.style.width.substr(0,mymario.style.width.length-2));
		
		//移动 0上   1右   2下   3左
		this.move=function(direct){
			switch(direct){
			case 0:
				top-=10;
				break;
			case 1:
				left+=10;
				break;
			case 2:
				top+=10;
				break;
			case 3:
				left-=10;
				break;
			}
			//判断边缘
			if(top<0)top=0;
			if(left<0)left=0;
			if(top>400-width)top=400-width;
			if(left>500-width)left=500-width;
			//设置坐标
			mymario.style.left=left+"px";
			mymario.style.top=top+"px";;
		}
	}
	
	//全局函数
	function marioMove(direct){
		new Mario().move(direct);
	}
	
	</script>
	
  </head>
  
  <body>
    <div class="gamediv">
    <img id="mymario" style="width:50px; position:relative; left:100px; top:50px;" src="images/mario.jpg">
    </div>
    <table class="controlcenter">
    <tr><td colspan="3">***游 戏 键 盘***</td></tr>
    <tr><td>*****</td><td><input type="button" value="↑↑↑↑" onclick="marioMove(0)"/></td><td>*****</td></tr>
    <tr><td><input type="button" value="←←" onclick="marioMove(3)"/></td><td>*****</td><td><input type="button" value="→→"  onclick="marioMove(1)"/></td></tr>
    <tr><td>*****</td><td><input type="button" value="↓↓↓↓" onclick="marioMove(2)"/></td><td>*****</td></tr>
    </table>
  </body>
</html>
