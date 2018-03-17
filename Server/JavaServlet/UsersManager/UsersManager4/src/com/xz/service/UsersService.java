package com.xz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xz.domain.User;
import com.xz.tools.SQLHelper;

public class UsersService {
	
	//构造函数,可以写一些公共的部分
	public UsersService() {
		// TODO Auto-generated constructor stub
	}

	// 写一个验证用户是否合法的函数
	public boolean checkUser(User user) {

		boolean res = false;
		int id = user.getId();
		String password = user.getPassword();
		SQLHelper sqlHelper = new SQLHelper();
		String sql = "select * from users where id=? and passwd=?";
		String[] parameters = { "" + id, password };
		try {
			ArrayList al = sqlHelper.executeReader(sql, parameters);
			if (al.size()==1) {
				res = true;
			} else {
				res = false;
			}
		} catch (Exception e) {
			res = false;
			System.out.println("验证用户失败!");
		}

		return res;
	}

	// 得到总共有多少记录的函数
	public int getUsersCount() {

		//共有多少条记录,返回-1代表出错
		int rowCount = 0;
		SQLHelper sqlHelper=new SQLHelper();
		try {
			rowCount=sqlHelper.executeRowCount("select count(*) from users");
		} catch (Exception e) {
			rowCount=-1;
			System.out.println("查询总记录数失败!");
		}
		return rowCount;
	}

	// 分页查询用户的函数
	public ArrayList<User> getUsersByPage(int pageNow, int pageSize) {

		ArrayList<User> arrayList = new ArrayList<User>();
		SQLHelper sqlHelper = new SQLHelper();

		String sql = "select * from (select t.*,  rownum rn from "
				+ "(select * from users order by id) t where rownum<=?) where rn>=?";
		int firstPage=pageSize * pageNow;
		int lastPage=pageSize * (pageNow - 1) + 1;
		String[] parameters={""+firstPage,""+lastPage};
		try {
			ArrayList arrayList2 = sqlHelper.executeReader(sql, parameters);
			for(int i=0;i<arrayList2.size();i++){
				Object [] objects=(Object[]) arrayList2.get(i);
				User user=new User(Integer.parseInt(objects[0].toString()),
						(String)objects[1],
						(String)objects[2],
						Integer.parseInt(objects[3].toString()),
						(String)objects[4]);
				arrayList.add(user);
			}

		} catch (Exception e) {
			System.out.println("分页查询失败!");
		}

		return arrayList;
	}
	
	//删除用户
	public boolean delUser(int id) {
		boolean res=true;
		String sql="delete from users where id=?";
		String []parameters={""+id};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("删除用户失败!");
		}
		return res;
	}
	
	//通过Id获取用户数据
	public User getUserById(int id) {
		User user=null;
		String sql="select * from users where id=?";
		String []parameters={""+id};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			ArrayList arrayList = sqlHelper.executeReader(sql, parameters);
			for(int i=0;i<arrayList.size();i++){
				Object [] objects=(Object[]) arrayList.get(i);
				user=new User(Integer.parseInt(objects[0].toString()),
						(String)objects[1],
						(String)objects[2],
						Integer.parseInt(objects[3].toString()),
						(String)objects[4]);
			}

		} catch (Exception e) {
			user=null;
			System.out.println("通过Id获取用户失败!");
		}
		return user;
	}
	//修改用户
	public boolean updateUser(User user) {
		boolean res=true;
		String sql="update users set username=?,email=?,grade=?,passwd=? where id=?";
		String []parameters={user.getUsername(),user.getEmail(),""+user.getGrade(),user.getPassword(),""+user.getId()};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("修改用户失败!");
		}
		return res;
	}
	//添加用户
	public boolean addUser(User user) {
		boolean res=true;
		String sql="insert into users values(users_seq.nextval,?,?,?,?)";
		String []parameters={user.getUsername(),user.getEmail(),""+user.getGrade(),user.getPassword()};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("添加用户失败!");
		}
		return res;
	}
}
