package com.xz.tools;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Callable;

public class SQLHelper {
	//�������(���������ܴ��ʱ����Щ����������Ϊ��̬��)
	private Connection ct=null;
	private PreparedStatement ps=null;
	private CallableStatement cs=null;
	private ResultSet rs=null;
	
	//�������ݿ���û��������룬url������
	//˵������ʵ�ʿ����У�������������Щ����д��һ���ⲿ�ļ���
	//����������ʱ�����Ƕ�����Щ������Ϣ��java.util.Properites
	private static String username;
	private static String password;
	private static String driver;
	private static String url;
	
	public SQLHelper(String path) {
		init(path);
	}

	//ʹ�þ�̬���������(����ֻ��Ҫ����һ��)
	private void init(String path){
		//ʹ��Properties�࣬����ȡ�����ļ�
		Properties pp=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(path);
			//��pp��dbinfo.properties�ļ���������
			pp.load(fis);
			//��ȡdbinfo.properties�ļ�����Ϣ
			username=(String) pp.getProperty("username");
			password=(String) pp.getProperty("password");
			driver=(String) pp.getProperty("driver");
			url=(String) pp.getProperty("url");
			
			//�������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(fis!=null){
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			fis=null;
		}
	}
	
	
	//дһ���������ӵķ���
	public Connection getConnection(){
		try {
			ct=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
		
	//��дһ��update / delete / insert ����
	public void executeUpdate(String sql,String[] parameters){
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null&&!parameters[0].equals("")){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			//ִ��
			ps.executeUpdate();
				
		} catch (Exception e) {
			//�����׶��쳣
			e.printStackTrace();
			//�׳�����ʱ�쳣,�ô������Ը�������һ��ѡ�񣨿��Դ���[������ʾ��]�����Բ�����
			throw new RuntimeException(e.getMessage());
		}finally{
			close();
		}
	}

	//����ж��update / delete / insert ��������Ϊһ������������
	public void executeUpdate2(String[] sql,String[][] parameters){
		try {
			ct=getConnection();
			ct.setAutoCommit(false);//���óɲ��Զ��ύ
			//ѭ����sql������д�����
			if(parameters!=null&&!parameters[0][0].equals("")){
				for(int i=0;i<sql.length;i++){
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;j++){
						ps.setString(j+1, parameters[i][j]);
					}
					ps.executeUpdate();
				}
			}else{
				for(int i=0;i<sql.length;i++){
					ps=ct.prepareStatement(sql[i]);
					ps.executeUpdate();
				}
			}
			ct.commit();
		} catch (Exception e) {
			//�����׶��쳣
			e.printStackTrace();
			try {
				ct.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				//�׳�����ʱ�쳣
				throw new RuntimeException(e1.getMessage());
			}
			//�׳�����ʱ�쳣
			throw new RuntimeException(e.getMessage());
		}finally{
			close();
		}
	}


		//дһ����������ɲ�ѯ����
		//ͳһ��select
		public ResultSet executeQuery(String sql,String[] parameters) throws  SQLException{
			//�õ�����
			ct=getConnection();
			//����ps���󣬵õ�sql������
			ps=ct.prepareStatement(sql);
			//���parameters��Ϊnull���Ÿ�ֵ
			if(parameters!=null&&!parameters[0].equals("")){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
			}
			rs=ps.executeQuery();
			return rs;
		}
		
		//��ҳ����
		public ResultSet executeQuery2(){
			return null;
		}

		//�޷���ֵ�Ĵ洢����
		public void executeProcedure(String sql,String [] parameters){
			try {
				ct=getConnection();
				cs=ct.prepareCall(sql);
				if(parameters!=null&&!parameters[0].equals("")){
					for(int i=0;i<parameters.length;i++){
						cs.setObject(i+1, parameters[i]);
					}
				}
				cs.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				close();
			}
		}
		//�з���ֵ�Ĵ洢����
		public CallableStatement executeProcedure2(String sql,String [] inParameters,Integer [] outParameters){
			try {
				ct=getConnection();
				cs=ct.prepareCall(sql);
				if(inParameters!=null&&!inParameters[0].equals("")){
					for(int i=0;i<inParameters.length;i++){
						cs.setObject(i+1, inParameters[i]);
					}
				}
				if(outParameters!=null){
					for(int i=0;i<outParameters.length;i++){
						cs.registerOutParameter(inParameters.length+1+i, outParameters[i]);
					}
				}
				cs.execute();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				//��ʱ���ر�,��Ҫ�ֶ��ر�
//				close();
			}
			return cs;
		}

		//�ѹر���Դд�ɺ���
		public void close(){
			//�ر���Դ
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//�׳������쳣
					throw new RuntimeException(e.getMessage());
				}
				rs=null;
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//�׳������쳣
					throw new RuntimeException(e.getMessage());
				}
				ps=null;
			}
			if(cs!=null){
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//�׳������쳣
					throw new RuntimeException(e.getMessage());
				}
				cs=null;
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					e.printStackTrace();
					//�׳������쳣
					throw new RuntimeException(e.getMessage());
				}
				ct=null;
			}
		}
		
	/***********************/
	public Connection getCt() {
		return ct;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public CallableStatement getCs() {
		return cs;
	}

	public ResultSet getRs() {
		return rs;
	}

}

