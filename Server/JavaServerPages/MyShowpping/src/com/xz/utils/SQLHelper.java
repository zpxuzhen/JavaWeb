package com.xz.utils;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Callable;

public class SQLHelper {
	// 定义变量(当并发量很大的时候，这些变量不能设为静态的)
	private Connection ct = null;
	private PreparedStatement ps = null;
	private CallableStatement cs = null;
	private ResultSet rs = null;

	// 先写一个update / delete / insert 操作
	public void executeUpdate(String sql, String[] parameters) {
		try {
			ct = DBUtil.getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null && !parameters[0].equals("")) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			// 执行
			ps.executeUpdate();

		} catch (Exception e) {
			// 开发阶段异常
			e.printStackTrace();
			// 抛出运行时异常,好处：可以给调用者一个选择（可以处理[弹出提示框]，可以不处理）
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
	}

	// 如果有多个update / delete / insert 操作，做为一个事务来处理
	public void executeUpdate2(String[] sql, String[][] parameters) {
		try {
			ct = DBUtil.getCon();
			ct.setAutoCommit(false);// 设置成不自动提交
			// 循环对sql数组进行创建。
			if (parameters != null && !parameters[0][0].equals("")) {
				for (int i = 0; i < sql.length; i++) {
					ps = ct.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++) {
						ps.setString(j + 1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			} else {
				for (int i = 0; i < sql.length; i++) {
					ps = ct.prepareStatement(sql[i]);
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (Exception e) {
			// 开发阶段异常
			e.printStackTrace();
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				// 抛出运行时异常
				throw new RuntimeException(e1.getMessage());
			}
			// 抛出运行时异常
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
	}

	// 写一个方法，完成查询任务
	// 统一的select
	public ResultSet executeQuery(String sql, String[] parameters) {
		try {
			// 得到连接
			ct = DBUtil.getCon();
			// 创建ps对象，得到sql语句对象
			ps = ct.prepareStatement(sql);
			// 如果parameters不为null，才赋值
			if (parameters != null && !parameters[0].equals("")) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			// 开发阶段异常
			e.printStackTrace();
			// 抛出运行时异常,好处：可以给调用者一个选择（可以处理[弹出提示框]，可以不处理）
			throw new RuntimeException(e.getMessage());
		} finally {
			// 暂时不关闭,需要手动关闭
			// close();
		}
		return rs;
	}

	// 改进executeQuery使其可以在本类中close资源
	public ArrayList executeReader(String sql, String[] parameters) {
		ArrayList arrayList = null;
		try {
			ct = DBUtil.getCon();
			ps = ct.prepareStatement(sql);
			if (parameters != null && !parameters[0].equals("")) {
				for (int i = 0; i < parameters.length; i++) {
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
			arrayList = new ArrayList();
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			int column = resultSetMetaData.getColumnCount();
			while (rs.next()) {
				Object[] object = new Object[column];
				for (int i = 0; i < column; i++) {
					object[i] = rs.getObject(i + 1);
				}
				arrayList.add(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
		return arrayList;
	}

	// 分页问题
	public int executeRowCount(String sql) {
		int rowCount = -1;
		try {
			ct = DBUtil.getCon();
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			rowCount = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
		return rowCount;
	}

	// 无返回值的存储过程
	public void executeProcedure(String sql, String[] parameters) {
		try {
			ct = DBUtil.getCon();
			cs = ct.prepareCall(sql);
			if (parameters != null && !parameters[0].equals("")) {
				for (int i = 0; i < parameters.length; i++) {
					cs.setObject(i + 1, parameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close();
		}
	}

	// 有返回值的存储过程
	public CallableStatement executeProcedure2(String sql, String[] inParameters, Integer[] outParameters) {
		try {
			ct = DBUtil.getCon();
			cs = ct.prepareCall(sql);
			if (inParameters != null && !inParameters[0].equals("")) {
				for (int i = 0; i < inParameters.length; i++) {
					cs.setObject(i + 1, inParameters[i]);
				}
			}
			if (outParameters != null) {
				for (int i = 0; i < outParameters.length; i++) {
					cs.registerOutParameter(inParameters.length + 1 + i, outParameters[i]);
				}
			}
			cs.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			// 暂时不关闭,需要手动关闭
			// close();
		}
		return cs;
	}

	// 把关闭资源写成函数
	public void close() {
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
