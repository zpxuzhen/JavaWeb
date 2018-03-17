<%@ page language="java"
	import="java.util.*,com.xz.domain.*,com.xz.service.*"
	pageEncoding="UTF-8"%>

<!-- 引入jstl标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
					window.open('/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=' + pageNow, '_self');
				}
			function confirmDel() {
					return window.confirm('真的要删除该用户吗?');
				}
	</script>
</head>

<body>
	<h1>欢迎来到用户管理界面</h1>
	<table border=1 width=500px>
		<tr>
			<th>ID</th>
			<th>USERNAME</th>
			<th>EMAIL</th>
			<th>GRADE</th>
			<th>刪除用戶</th>
			<th>修改用戶</th>
		</tr>
		<c:forEach items="${getPage}" var="user" >
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>${user.user_email}</td>
				<td>${user.user_grade}</td>
				<td><a onClick='return confirmDel();' href='/UsersManager6/servlet/UserClServlet?type=del&userId=${user.user_id}'>刪除用戶</a></td>
				<td><a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoUpdateView&userId=${user.user_id}'>修改用戶</a></td>
			</tr>
		</c:forEach>
	</table><br> 
	<c:if test="${pageNow>1}">
		<a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=${pageNow-1}'><上一页></a>
	</c:if> 
	<c:if test="${pageNow>10}">
		&nbsp;<a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=${pageNow-10}'><<</a>&nbsp;
	</c:if> 
	<c:forEach var="i" begin="${pageNow-(pageNow%10)+1}" end="${pageNow-(pageNow%10)+10}" >
		<c:if test="${i <= pageCount}">
		<a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=${i}'><${i}></a>
		</c:if>
	</c:forEach>
	<c:if test="${pageNow+9 < pageCount}">
		&nbsp;<a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=${pageNow+10}'>>></a>&nbsp;
	</c:if> 
	<c:if test="${pageNow<pageCount}">
		<a href='/UsersManager6/servlet/GotoViewClServlet?type=gotoManagerUsersView&pageNow=${pageNow+1}'><下一页></a>
	</c:if> 
	&nbsp;<当前第 ${pageNow} 页><总共 ${pageCount} 页>&nbsp; &nbsp;&nbsp;
	<跳转到第<input id='pageNow' style='width:30px' type='text' name='pageNow' />页> 
	<input type='button' value='Go' onClick='gotopageNow(${pageCount})'>
</body>
</html>
