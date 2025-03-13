package com.javaoo.store;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 4 인벤토리 시스템 확장
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * 데이터 멤버 없이 인벤토리 시스템에 대한 일반적인 기능 제공
 */
public class Inventory {
	
	public static void produceReport(Item[] items) {
		/**
		 * 인벤토리에 포함된 전체가격 및 수량을 체크할 수 있는 속성 추가 및 초기화
		 */
		int totalCount = 0;
		double totalValue = 0.0;
		/**
		 * 출력 라인이 잘 정렬될 수 있도록 printf를 이용한 출력길이 조절
		 */
		System.out.printf("%-30s%10s %5s\n", "Title", "Price", "Quantity");
		/**
		 * items라는 Item배열을 받아 item에 추가하고, item이 null이 아니라면 제목, 가격, 수량을 출력하도록 함으로써
		 * 인벤토리에 추가된 모든 항목을 보고하도록 설정.
		 * 
		 * totalCount와 totalValue를 이용하여 누적 수량과 전체 가격을 표시할 수 있게 설정.
		 */
		for ( Item item : items ) {
			if (item != null){
				System.out.printf("%-30s%10.2f%5d\n", item.getTitle(), item.getPrice(), item.getQuantity());
				totalCount += item.getQuantity();
				totalValue += (item.getQuantity() * item.getPrice());
			}
		}
		System.out.printf("TOTAL%-25s%10.2f%5d\n", " ", totalValue, totalCount);
		
	}

}
