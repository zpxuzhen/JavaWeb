package com.xz.service;

import java.util.*;
import com.xz.domain.*;
import com.xz.utils.*;

public class BooksService {
	
	//得到所有书籍的信息(将来分页)
	public ArrayList<Books> getAllBooks() {

		ArrayList<Books> arrayList = new ArrayList<Books>();
		SQLHelper sqlHelper = new SQLHelper();

		String sql = "select * from books";
		try {
			ArrayList arrayList2 = sqlHelper.executeReader(sql, null);
			for(int i=0;i<arrayList2.size();i++){
				Object [] objects=(Object[]) arrayList2.get(i);
				Books books=new Books(Integer.parseInt(objects[0].toString()),
						(String)objects[1],
						(String)objects[2],
						(String)objects[3],
						Float.parseFloat(objects[4].toString()),
						Integer.parseInt(objects[5].toString()));
				arrayList.add(books);
			}
		} catch (Exception e) {
			arrayList=null;
			System.out.println("查询失败!");
		}
		return arrayList;
	}
	
	//通过书的id得到书
	public Books getBookById(String book_id) {
		Books book=null;
		String sql="select * from books where book_id=?";
		String []parameters={book_id};
		SQLHelper sqlHelper=new SQLHelper();
		try {
			ArrayList arrayList = sqlHelper.executeReader(sql, parameters);
			if(arrayList.size()==1){
				Object [] objects=(Object[]) arrayList.get(0);
				book=new Books(Integer.parseInt(objects[0].toString()),
						(String)objects[1],
						(String)objects[2],
						(String)objects[3],
						Float.parseFloat(objects[4].toString()),
						Integer.parseInt(objects[5].toString()));
			}else{
				book=null;
			}
		} catch (Exception e) {
			book=null;
			System.out.println("通过Id获取书失败!");
		}
		return book;
	}
}
