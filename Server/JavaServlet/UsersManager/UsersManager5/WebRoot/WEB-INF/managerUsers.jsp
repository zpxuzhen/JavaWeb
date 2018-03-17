<%@ page language="java" import="java.util.*,com.xz.domain.*,com.xz.service.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<title>My JSP 'managerUsers.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
			<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
				<meta http-equiv="description" content="This is my page">
					<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type='text/javascript' language='javascript'>
	function gotopageNow(pageCount) {
		var pageNow = document.getElementById('pageNow').value;
		if (pageNow >= 1 && pageNow <= pageCount) 
			window.open('/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=' + pageNow, '_self');
		}
	function confirmDel() {
		return window.confirm('真的要删除该用户吗?');
	}
	</script>
</head>

<body>
		<h1>欢迎来到用户管理界面</h1>
		<table border=1 width=500px>
		<tr><th>ID</th><th>USERNAME</th><th>EMAIL</th><th>GRADE</th><th>刪除用戶</th><th>修改用戶</th></tr>
	<%
		int pageNow = (Integer)request.getAttribute("pageNow");
		int pageSize = (Integer)request.getAttribute("pageSize");
		int rowCount = (Integer)request.getAttribute("rowCount");
		int pageCount = (Integer)request.getAttribute("pageCount");
		ArrayList<User> getPage = (ArrayList<User>)request.getAttribute("getPage");
		for (User user : getPage) {
	%>
		<tr><td><%=user.getUser_id() %></td>
		<td><%=user.getUser_name() %></td>
		<td><%=user.getUser_email()%></td>
		<td><%=user.getUser_grade() %></td>
		<td><a onClick='return confirmDel();' href='/UsersManager5/servlet/UserClServlet?type=del&userId=<%=user.getUser_id() %>'>刪除用戶</a></td>
		<td><a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoUpdateView&userId=<%=user.getUser_id() %>'>修改用戶</a></td></tr>
	<%
		}
	%>
	</table><br>
	<% 
	if (pageNow > 1){
	%>
		<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=<%=(pageNow-1) %>'><上一页></a>
	<% 
	}
	if (pageNow > 10){
	%>
	&nbsp;<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=<%=(pageNow-10) %>'><<</a>&nbsp;
	<%
	}
		for (int i = (pageNow - 1) / 10 * 10 + 1; i <= pageCount && i <= (pageNow - 1) / 10 * 10 + 10; i++) {
	%>
			<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=<%=i %>'><<%=i %>></a>
	<%
		}
		if (((pageNow - 1) / 10) < ((pageCount - 1) / 10)){
	%>
		&nbsp;<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=<%=(pageNow+10) %>'>>></a>&nbsp;
	<%
		}
		if (pageNow < pageCount){
	%>
			<a href='/UsersManager5/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=<%=(pageNow+1) %>'><下一页></a>
	<% 
		}
	%>
		&nbsp;<当前第<%=pageNow %>页><总共<%=pageCount %>页>&nbsp;
		&nbsp;&nbsp;<跳转到第<input id='pageNow' style='width:30px' type='text' name='pageNow' />页>
		<input type='button' value='Go' onClick='gotopageNow(<%=pageCount %>)'>
</body>
</html>
