package com.hsp.utils;

public class MyTools {
	public static String getNewString(String str) {
		String newString="";
		try {
			newString=new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			// ��iso-8859-1 ת���� utf-8
		} 
		return newString;
	}
}
