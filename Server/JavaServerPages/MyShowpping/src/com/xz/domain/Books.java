package com.xz.domain;

public class Books {
	private int book_id ;
	private String book_name ;
	private String book_author ;
	private String book_press ;
	private float book_price ;
	private int book_stock ;
	private int showppingNums=0;
	public int getBook_id() {
		return book_id;
	}
	public Books() {
		super();
	}
	public Books(int book_id, String book_name, String book_author, String book_press, float book_price,
			int book_stock) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_press = book_press;
		this.book_price = book_price;
		this.book_stock = book_stock;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_press() {
		return book_press;
	}
	public void setBook_press(String book_press) {
		this.book_press = book_press;
	}
	public float getBook_price() {
		return book_price;
	}
	public void setBook_price(float book_price) {
		this.book_price = book_price;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
	public int getShowppingNums() {
		return showppingNums;
	}
	public void setShowppingNums(int showppingNums) {
		this.showppingNums = showppingNums;
	}
}
