package com.javaoo.store;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * 책, CD를 판매하고 재고를 추적하는 시스템을 생성하기 위한 스토어 모델링
 * 
 * Item 클래스를 통해 재고에 있는 모든 품목의 제목, 가격, 수량을 추적해야 한다.
 */
public class Item {
	/**
	 * private 속성으로 제목, 가격, 수량을 추가
	 */
	private String title;
	private double price;
	private int quantity;
	/**
	 * 인수를 받지 않는 생성자 생성. 다른 코드가 컴파일될 수 있도록 하기 위해 필요함.
	 */
	public Item() {
		
	}
	/**
	 * Item 관련 제목, 가격, 수량을 받는 생성자 설정
	 */
	public Item(String title, double price, int quantity) {
		super();
		this.setTitle(title);
		this.setPrice(price);
		this.setQuantity(quantity);
	}
	/**
	 * 각 속성에 대한 게터와 세터 설정
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
