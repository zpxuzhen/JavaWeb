<%@ page language="java" import="java.util.*" import="com.xz.service.*"
	import="com.xz.domain.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showMyOrder.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<%-- <link rel="stylesheet" type="text/css" href="css/comm.css"> --%>

	<script type="text/javascript" language="javascript">
		function goSubmitOrder(){
			window.location.href="/MyShowpping/SubmitOrderServlet";
		}
	</script>

</head>

<body>
	<%
		//得到登录用户信息
		Users loginUser = (Users) request.getSession().getAttribute("loginUser");
		//得到商品总价
		float totalPrice = (Float) request.getAttribute("totalPrice");
		//得到书的信息
		ArrayList<Books> books = (ArrayList<Books>) request.getAttribute("books");
	%>
	<h1>我的订单</h1>
	<a href="/MyShowpping/ShowppingClServlet?type=goHall">返回购物大厅</a>
	<form action="??" method="post">
		<table border="1">
			<tr>
				<td colspan="2">用户个人信息</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><%=loginUser.getUser_name()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=loginUser.getUser_email()%></td>
			</tr>
			<tr>
				<td>电话号码</td>
				<td><%=loginUser.getUser_tel()%></td>
			</tr>
			<tr>
				<td>用户级别</td>
				<td><%=loginUser.getUser_grade()%></td>
			</tr>
		</table>
		<br>
		<br>
		<table border="1">
			<tr>
				<td>BookId</td>
				<td>书名</td>
				<td>价格</td>
				<td>出版社</td>
				<td>数量</td>
			</tr>
			<%
				for (Books book : books) {
			%>
			<tr>
				<td><%=book.getBook_id()%></td>
				<td><%=book.getBook_name()%></td>
				<td><%=book.getBook_price()%>元</td>
				<td><%=book.getBook_press()%></td>
				<td><%=book.getShowppingNums()%></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="5">书的总价格是${totalPrice}元</td>
			</tr>
		</table>
	</form>
	<input type="button" onclick="goSubmitOrder()" value="确认订单" />
	<a href="/MyShowpping/ShowppingClServlet?type=goHall">返回</a>
</body>
</html>
