package com.xz.service;

import java.util.*;
import com.xz.domain.*;

//这个表示我的购物车
public class MyCart {
	
	private HashMap<String, Books> hashMap=new HashMap<String, Books>();
	
	//添加书
	public void addBook(String book_id) {
		Books book=null;
		if(hashMap.containsKey(book_id)){
			book=hashMap.get(book_id);
		}else{
			book=new BooksService().getBookById(book_id);
			hashMap.put(book_id, book);
		}
		book.setShowppingNums(book.getShowppingNums()+1);
	}
	//删除书
	public void delBook(String book_id) {
		hashMap.remove(book_id);
	}
	//更新书(对于购物车来说就是改变数量)
	public void updBook(String book_id,String book_num) {
		//遍历hashMap
		Books book=hashMap.get(book_id);
		book.setShowppingNums(Integer.parseInt(book_num));
	}
	//清空书,清空购物车
	public void clearBook() {
		hashMap.clear();
	}
	//显示购物车中的所有商品信息
	public ArrayList<Books> showMyCart() {
		ArrayList<Books> books=new ArrayList<Books>();
		//遍历hashMap
		Iterator iterator=hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Books book=hashMap.get(key);
			books.add(book);
		}
		return books;
	}
	//返回该购物车的总价
	public float getTotalPrice() {
		
		float totalPrice=0;
		Iterator iterator=hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Books book=hashMap.get(key);
			totalPrice+=book.getBook_price()*book.getShowppingNums();
		}
		return totalPrice;
	}
	//购物车是否为空
	public boolean NonEmpty(){
		boolean res=false;
		Iterator iterator=hashMap.keySet().iterator();
		if(iterator.hasNext()) res=true;
		return res;
	}
}
