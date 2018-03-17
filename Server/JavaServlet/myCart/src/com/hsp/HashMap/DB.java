package com.hsp.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

//用ArrayList模拟一个内存数据库
public class DB {

	private	final static HashMap<String,Book>	books=new HashMap<String,Book>();
	
	//私有构造函数，单态
	private DB() {
	}
	
	static{
		putBook("1","java",25.99f);
		putBook("2","oracle",35.99f);
		putBook("3","Android",49.99f);
		putBook("4","linux",29.99f);
		putBook("5","C语言",59.99f);
	}
	
	private static void putBook(String id,String name,float price) {
		Book book=new Book();
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		books.put(id,book);
	}
	
	public static HashMap<String,Book> getDB() {
		return books;
	}
	public static Book getBookById(String id) {
		return books.get(id);
	}
}
