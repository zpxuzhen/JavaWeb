package com.hsp.filter;

public class User {
	private int id;
	private String username=null;
	private String email=null;
	private int grade;
	private String password=null;
	
	public User() {
	}
	public User(int id,String username,String email,int grade,String password) {
		setId(id);
		setUsername(username);
		setEmail(email);
		setGrade(grade);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
