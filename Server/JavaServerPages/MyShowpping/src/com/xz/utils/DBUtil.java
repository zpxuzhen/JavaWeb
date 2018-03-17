package com.xz.utils;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBUtil {

	// �������ݿ���û��������룬url������
	// ˵������ʵ�ʿ����У�������������Щ����д��һ���ⲿ�ļ���
	// ����������ʱ�����Ƕ�����Щ������Ϣ��java.util.Properites
	private static String username;
	private static String password;
	private static String driver;
	private static String url;

	// ʹ�þ�̬���������(����ֻ��Ҫ����һ��)
	static {
		// ʹ��Properties�࣬����ȡ�����ļ�
		Properties pp = new Properties();
		InputStream fis = null;
		try {
			// ������ʹ��java web��ʱ�򣬶�ȡ�ļ�Ҫ���������(��Ϊ���������ȡ��Դ��Ĭ����·������src)
			fis = DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			// ��ȡdbinfo.properties�ļ�����Ϣ
			username = (String) pp.getProperty("username");
			password = (String) pp.getProperty("password");
			driver = (String) pp.getProperty("driver");
			url = (String) pp.getProperty("url");

			// �������
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

	// дһ���������ӵķ���
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
