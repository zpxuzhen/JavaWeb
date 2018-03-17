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

	//��֤�û��Ƿ�Ϸ��ķ���
		public boolean checkUser(User user) {
			
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
				+ "(select * from users order by user_id) t where rownum<=?) where rn>=?";
		int firstPage=pageSize * pageNow;
		int lastPage=pageSize * (pageNow - 1) + 1;
		String[] parameters={""+firstPage,""+lastPage};
		try {
			ArrayList arrayList2 = sqlHelper.executeReader(sql, parameters);
			for(int i=0;i<arrayList2.size();i++){
				Object [] objects=(Object[]) arrayList2.get(i);
				User user=new User();
				user.setUser_id(Integer.parseInt(objects[0].toString()));
				user.setUser_name(objects[1].toString());
				user.setUser_pwd(objects[2].toString());
				user.setUser_email(objects[3].toString());
				user.setUser_tel(objects[4].toString());
				user.setUser_grade(Integer.parseInt(objects[5].toString()));
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

		String sql="delete from users where user_id=?";
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

		String sql="select * from users where user_id=?";
		String []parameters={""+id};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			ArrayList arrayList = sqlHelper.executeReader(sql, parameters);
			for(int i=0;i<arrayList.size();i++){
				Object [] objects=(Object[]) arrayList.get(i);
				user=new User();
				user.setUser_id(Integer.parseInt(objects[0].toString()));
				user.setUser_name(objects[1].toString());
				user.setUser_pwd(objects[2].toString());
				user.setUser_email(objects[3].toString());
				user.setUser_tel(objects[4].toString());
				user.setUser_grade(Integer.parseInt(objects[5].toString()));
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
		
		String sql="update users set user_name=?,user_pwd=?,user_email=?,user_grade=? where user_id=?";
		String []parameters={user.getUser_name(),user.getUser_pwd(),user.getUser_email(),user.getUser_grade()+"",user.getUser_id()+""};
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

		String sql="insert into users values(users_seq.nextval,?,?,?,?,?)";
		String []parameters={user.getUser_name(),user.getUser_pwd(),user.getUser_email(),user.getUser_tel(),user.getUser_grade()+""};
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
