package com.xz.utils;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBUtil {

	// 连接数据库的用户名，密码，url，驱动
	// 说明：在实际开发中，我们往往把这些变量写到一个外部文件中
	// 当程序启动时，我们读入这些配置信息。java.util.Properites
	private static String username;
	private static String password;
	private static String driver;
	private static String url;

	// 使用静态块加载驱动(驱动只需要加载一次)
	static {
		// 使用Properties类，来读取配置文件
		Properties pp = new Properties();
		InputStream fis = null;
		try {
			// 当我们使用java web的时候，读取文件要用类加载器(因为类加载器读取资源的默认主路径就是src)
			fis = DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			// 获取dbinfo.properties文件内信息
			username = (String) pp.getProperty("username");
			password = (String) pp.getProperty("password");
			driver = (String) pp.getProperty("driver");
			url = (String) pp.getProperty("url");

			// 获得驱动
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			fis = null;
		}
	}

	// 写一个返回连接的方法
	public static Connection getCon() {
		Connection ct = null;
		try {
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

}
