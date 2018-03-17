<%@ page language="java" import="java.util.*" import="com.xz.domain.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'hall.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%-- <link rel="stylesheet" type="text/css" href="css/comm.css"> --%>


</head>

<body>
	<h1>欢迎访问购物大厅</h1>
	<form action="/MyShowpping/ShowppingClServlet?type=look" method="post">
		<table border="1px">
			<tr>
				<td>书名</td>
				<td>价格</td>
				<td>出版社</td>
				<td>点击购买</td>
			</tr>
			<%
				ArrayList<Books> books = (ArrayList<Books>) request.getAttribute("books");
				for (Books book : books) {
			%>
			<tr>
				<td><%=book.getBook_name()%></td>
				<td><%=book.getBook_price()%>元</td>
				<td><%=book.getBook_press()%></td>
				<td><a href="/MyShowpping/ShowppingClServlet?type=add&book_id=<%=book.getBook_id() %>">点击购买</a></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="4"><input type="submit" name="look" value="查看购物车" /></td>
			</tr>
		</table>
		<a href="/MyShowpping">返回重新登录</a>
	</form>
</body>
</html>
