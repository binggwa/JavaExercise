package com.javaoo.store;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * Item을 상속하는 Book 클래스에서 저자, 출판사, 카테고리를 추가.
 */
public class Book extends Item {
	/**
	 * 저자, 출반사, 카테고리의 private 속성 추가
	 */
	private String author;
	private String publisher;
	private String category;
	/**
	 * Item에서 상속한 title, price, quantity와 새로 추가한 author, publisher, category를 이용한 Book 생성자 추가
	 */
	public Book(String title, double price, int quantity, String author, String publisher, String category) {
		super(title, price, quantity);
		this.setAuthor(author);
		this.setPublisher(publisher);
		this.setCategory(category);
	}
	/**
	 * 각 속성에 대한 게터와 세터 설정
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
