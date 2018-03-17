<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<link rel="stylesheet" type="text/css" href="css/comm.css">
<link rel="stylesheet" type="text/css" href="css/index.css">


</head>

<body>
	<%-- 顶部 --%>
	<div class="top">
		<img alt="" src="images/banner.gif">
	</div>
	<%-- 中间的左部 --%>
	<div class="user_mid_left">
		<%-- 广告信息头 --%>
		<div class="ad_info_title">
			<span> <img alt="" src="images/landian.gif" /> <font
				class="font_style1">推荐企业广告</font>
			</span>
		</div>
		<%-- 广告信息列表 --%>
		<div class="ad_info_list">
			<ul>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
				<li><a href="#">· 重启明天会更好.......</a></li>
			</ul>
		</div>
		<%-- 快速信息检索头 --%>
		<div class="ad_info_search">
			<span> <img alt="" src="images/landian.gif" /> <font
				class="font_style1">信息快速检索</font>
			</span>
		</div>
		<%-- 信息检索表单 --%>
		<div class="info_search">
			<form action="??" method="post">
				<table>
					<tr>
						<td>关键字</td>
						<td><input type="text" name="keyword" /></td>
					</tr>
					<tr>
						<td>条&nbsp;件</td>
						<td><select name="infoType">
								<option value="qiuzhi">求职信息</option>
								<option value="zhaopin">招聘信息</option>
								<option value="jiajiao">家教信息</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="image" src="images/btn1.gif" /></td>
					</tr>
				</table>
			</form>
		</div>
		<%-- 联系我们头 --%>
		<div class="ad_info_search">
			<span> <img alt="" src="images/landian.gif" /> <font
				class="font_style1">联系我们</font>
			</span>
		</div>
		<%-- 联系我们具体信息 --%>
		<div class="contact_info">
			<span> <font class="font_style2">及时雨供求信息网<br></font> <img
				alt="" src="images/tiao.gif"><br> 联系地址：山东省邹平县<br>
				联系电话：78565887<br> 邮政编码：121423<br>
			</span>
		</div>
	</div>
	<%-- 中间的右部 --%>
	<div class="user_mid_right">
		<%-- 付费专区 --%>
		<div class="pay_title"></div>
		<div class="pay_info_con">
			<table>
				<tr>
					<td><font class="font_style2">『求职信息』</font><font
						style="margin-left: 10px;" class="font_style3">我是一个求职人</font><font
						style="margin-left: 10px;" class="font_style4">2017-03-23
							17:00:00.0</font></td>
				</tr>
				<tr>
					<td style="text-indent: 2em;"><font class="font_style5">hellohellohellohellohellohellohellohello<br>hellohellohellohellohellohellohellohello<br></font></td>
				</tr>
				<tr>
					<td><font style="margin-left: 10px;" class="font_style3">联系人:111
							联系电话:32323</font></td>
				</tr>
				<tr>
					<td><hr /></td>
				</tr>
			</table>

		</div>
		<%-- 放入首页的广告 --%>
		<div class="ad_con">
			<img alt="" src="images/guanggao.gif" />
		</div>
		<%-- 免费专区 --%>
		<div class="free_title"></div>
		<div class="free_info_con">
			<table>
				<tr>
					<td><font class="font_style2">『求职信息』</font><font
						style="margin-left: 10px;" class="font_style3">我是一个求职人</font><font
						style="margin-left: 10px;" class="font_style4">2017-03-23
							17:00:00.0</font></td>
				</tr>
				<tr>
					<td style="text-indent: 2em;"><font class="font_style5">hellohellohellohellohellohellohellohello<br>hellohellohellohellohellohellohellohello<br></font></td>
				</tr>
				<tr>
					<td><font style="margin-left: 10px;" class="font_style3">联系人:111
							联系电话:32323</font></td>
				</tr>
				<tr>
					<td><hr /></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><font class="font_style2">『求职信息』</font><font
						style="margin-left: 10px;" class="font_style3">我是一个求职人</font><font
						style="margin-left: 10px;" class="font_style4">2017-03-23
							17:00:00.0</font></td>
				</tr>
				<tr>
					<td style="text-indent: 2em;"><font class="font_style5">hellohellohellohellohellohellohellohello<br>hellohellohellohellohellohellohellohello<br></font></td>
				</tr>
				<tr>
					<td><font style="margin-left: 10px;" class="font_style3">联系人:111
							联系电话:32323</font></td>
				</tr>
				<tr>
					<td><hr /></td>
				</tr>
			</table>
			<table>
				<tr>
					<td><font class="font_style2">『求职信息』</font><font
						style="margin-left: 10px;" class="font_style3">我是一个求职人</font><font
						style="margin-left: 10px;" class="font_style4">2017-03-23
							17:00:00.0</font></td>
				</tr>
				<tr>
					<td style="text-indent: 2em;"><font class="font_style5">hellohellohellohellohellohellohellohello<br>hellohellohellohellohellohellohellohello<br></font></td>
				</tr>
				<tr>
					<td><font style="margin-left: 10px;" class="font_style3">联系人:111
							联系电话:32323</font></td>
				</tr>
				<tr>
					<td><hr /></td>
				</tr>
			</table>

			<span class="pagenavi">共有 4 条 每页显示 4 条 第 1 页/共 1 页</span>
		</div>
	</div>
	<%-- 首页面的尾部 --%>
	<div class="user_bottom">
		<span><font class="font_style6">及时雨供求信息网 www.xxxxx.com
				版权所有 联系电话：0232453453</font></span>
	</div>
</body>
</html>
