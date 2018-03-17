<%@ page language="java" import="java.util.*" import="com.xz.service.*" import="com.xz.domain.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<%-- <link rel="stylesheet" type="text/css" href="css/comm.css"> --%>

  </head>
  
  <body>
    <h1>我的购物车</h1>
    <a href="/MyShowpping/ShowppingClServlet?type=goHall">返回购物大厅</a>
    <form action="/MyShowpping/ShowppingClServlet?type=update" method="post">
		<table border="1" >
			<tr><td>BookId</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td><td>是否删除</td></tr>
			<%
				float totalPrice=(Float)request.getAttribute("totalPrice");
				ArrayList<Books> books=(ArrayList<Books>) request.getAttribute("books");
				for (Books book : books) {
			%>
			<tr>
			<%-- 隐藏表单 从而得到book_id--%>
				<td><%=book.getBook_id()%><input type="hidden" name="book_id" value="<%=book.getBook_id() %>" /></td>
				<td><%=book.getBook_name()%></td>
				<td><%=book.getBook_price()%>元</td>
				<td><%=book.getBook_press()%></td>
				<td><input type="text" name="book_number" value="<%=book.getShowppingNums() %>"></td>
				<td><a href="/MyShowpping/ShowppingClServlet?type=del&book_id=<%=book.getBook_id() %>">删除</a></td>
			</tr>
			<%
				}
			%>
			<tr><td colspan="6"><input type="submit" name="update" value="update" /></td></tr>
			<tr><td colspan="6">书的总价格是${totalPrice}元</td></tr>
		</table>
	</form>
		<a href="/MyShowpping/ShowppingClServlet?type=clear">清空购物车</a>
		<a href="/MyShowpping/GoMyOrderServlet">提交订单</a>
  </body>
</html>
