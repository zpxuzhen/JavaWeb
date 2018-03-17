package com.xz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xz.domain.User;
import com.xz.tools.SQLHelper;

public class UsersService {
	
	//���캯��,����дһЩ�����Ĳ���
	public UsersService() {
		// TODO Auto-generated constructor stub
	}

	// дһ����֤�û��Ƿ�Ϸ��ĺ���
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
			System.out.println("��֤�û�ʧ��!");
		}

		return res;
	}

	// �õ��ܹ��ж��ټ�¼�ĺ���
	public int getUsersCount() {

		//���ж�������¼,����-1�������
		int rowCount = 0;
		SQLHelper sqlHelper=new SQLHelper();
		try {
			rowCount=sqlHelper.executeRowCount("select count(*) from users");
		} catch (Exception e) {
			rowCount=-1;
			System.out.println("��ѯ�ܼ�¼��ʧ��!");
		}
		return rowCount;
	}

	// ��ҳ��ѯ�û��ĺ���
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
			System.out.println("��ҳ��ѯʧ��!");
		}

		return arrayList;
	}
	
	//ɾ���û�
	public boolean delUser(int id) {
		boolean res=true;
		String sql="delete from users where id=?";
		String []parameters={""+id};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("ɾ���û�ʧ��!");
		}
		return res;
	}
	
	//ͨ��Id��ȡ�û�����
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
			System.out.println("ͨ��Id��ȡ�û�ʧ��!");
		}
		return user;
	}
	//�޸��û�
	public boolean updateUser(User user) {
		boolean res=true;
		String sql="update users set username=?,email=?,grade=?,passwd=? where id=?";
		String []parameters={user.getUsername(),user.getEmail(),""+user.getGrade(),user.getPassword(),""+user.getId()};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("�޸��û�ʧ��!");
		}
		return res;
	}
	//����û�
	public boolean addUser(User user) {
		boolean res=true;
		String sql="insert into users values(users_seq.nextval,?,?,?,?)";
		String []parameters={user.getUsername(),user.getEmail(),""+user.getGrade(),user.getPassword()};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			sqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res=false;
			System.out.println("����û�ʧ��!");
		}
		return res;
	}
}
