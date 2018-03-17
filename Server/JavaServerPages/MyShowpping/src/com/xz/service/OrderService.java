package com.xz.service;

import java.sql.*;
import java.util.*;
import com.xz.domain.*;
import com.xz.utils.*;

//处理与订单相关的业务逻辑
public class OrderService {
	// 定义变量
	private Connection ct = null;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;
	private ResultSet rs = null;

	// 下订单涉及到两张表
	public boolean submitOrder(MyCart myCart, Users user) {
		boolean res=true;
		//如果购物车是空的,直接返回false
		if(!myCart.NonEmpty()) return false;
		
		// 因为添加订单复杂!所以这种操作很特别，于是我们就不使用SQLHelper工具类了
		// 专门针对下订单写对数据库的操作
		try {
			ct = DBUtil.getCon();
			// 设置成不自动提交
			ct.setAutoCommit(false);
			// 为了保证我的订单号是稳定的，所以将其事务隔离级别升级(可串行化)
			ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			// 添加orders表
			String sql = "insert into orders values(orders_seq.nextval,?,?,sysdate)";
			ps = ct.prepareStatement(sql);
			ps.setInt(1, user.getUser_id());
			ps.setFloat(2, myCart.getTotalPrice());
			ps.executeUpdate();

			// 查询order_id号
			sql = "select orders_seq.currval from orders";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			int order_id = 0;
			if (rs.next()) {
				// 取出刚刚生成的订单号
				order_id = rs.getInt(1);
			}

			// 添加ordersItem表
			sql = "insert into ordersItem values(ordersItem_seq.nextval,?,?,?)";
			ArrayList<Books> books = myCart.showMyCart();
			for (Books book : books) {
				ps = ct.prepareStatement(sql);
				ps.setInt(1, order_id);
				ps.setInt(2, book.getBook_id());
				ps.setInt(3, book.getShowppingNums());
				ps.executeUpdate();
			}

			// 提交所有操作
			ct.commit();

		} catch (Exception e) {
			res=false;
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1.getMessage());
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
		return res;
	}

	// 把关闭资源写成函数
	private void close() {
		// 关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// 抛出运行异常
				throw new RuntimeException(e.getMessage());
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// 抛出运行异常
				throw new RuntimeException(e.getMessage());
			}
			ps = null;
		}
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// 抛出运行异常
				throw new RuntimeException(e.getMessage());
			}
			cs = null;
		}
		if (ct != null) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// 抛出运行异常
				throw new RuntimeException(e.getMessage());
			}
			ct = null;
		}
	}

}
