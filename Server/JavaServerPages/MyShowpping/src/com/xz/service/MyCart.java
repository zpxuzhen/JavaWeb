package com.xz.service;

import java.util.*;
import com.xz.domain.*;

//�����ʾ�ҵĹ��ﳵ
public class MyCart {
	
	private HashMap<String, Books> hashMap=new HashMap<String, Books>();
	
	//�����
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
	//ɾ����
	public void delBook(String book_id) {
		hashMap.remove(book_id);
	}
	//������(���ڹ��ﳵ��˵���Ǹı�����)
	public void updBook(String book_id,String book_num) {
		//����hashMap
		Books book=hashMap.get(book_id);
		book.setShowppingNums(Integer.parseInt(book_num));
	}
	//�����,��չ��ﳵ
	public void clearBook() {
		hashMap.clear();
	}
	//��ʾ���ﳵ�е�������Ʒ��Ϣ
	public ArrayList<Books> showMyCart() {
		ArrayList<Books> books=new ArrayList<Books>();
		//����hashMap
		Iterator iterator=hashMap.keySet().iterator();
		while(iterator.hasNext()){
			String key=(String)	iterator.next();
			Books book=hashMap.get(key);
			books.add(book);
		}
		return books;
	}
	//���ظù��ﳵ���ܼ�
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
	//���ﳵ�Ƿ�Ϊ��
	public boolean NonEmpty(){
		boolean res=false;
		Iterator iterator=hashMap.keySet().iterator();
		if(iterator.hasNext()) res=true;
		return res;
	}
}
