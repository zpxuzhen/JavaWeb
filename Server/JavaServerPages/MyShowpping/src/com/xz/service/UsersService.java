package com.xz.service;

import java.util.*;

import com.xz.domain.*;
import com.xz.utils.*;

public class UsersService {
	
	//验证用户是否合法的方法
	public boolean checkUser(Users user) {
		
		boolean res=true;
		int user_id = user.getUser_id();
		String user_pwd = user.getUser_pwd();
		SQLHelper sqlHelper = new SQLHelper();
		String sql = "select * from users where user_id=? and user_pwd=?";
		String[] parameters = { "" + user_id, user_pwd };
		try {
			ArrayList arrayList = sqlHelper.executeReader(sql, parameters);
			if (arrayList.size()==1) {
				Object []objects = (Object[]) arrayList.get(0);
				user.setUser_name(objects[1].toString());
				user.setUser_email(objects[3].toString());
				user.setUser_tel(objects[4].toString());
				user.setUser_grade(Integer.parseInt(objects[5].toString()));
			} else {
				res=false;
			}
		} catch (Exception e) {
			res=false;
			System.out.println("验证用户失败!");
		}
		
		return res;
	}
}
