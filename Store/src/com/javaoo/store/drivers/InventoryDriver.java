package com.javaoo.store.drivers;

import com.javaoo.store.Item;
import com.javaoo.store.Book;
import com.javaoo.store.CD;
import com.javaoo.store.Artist;
import com.javaoo.store.ClassicalCD;
import com.javaoo.store.Inventory;

import java.util.Date;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * store 패키지에 만든 클래스들을 테스트해볼 main 메서드를 포함하는 InventoryDriver 클래스 생성.
 */
public class InventoryDriver {

	public static void main(String[] args) {
		/**
		 * myInventory라는 이름의 Item 배열을 50개 생성
		 */
		Item[] myInventory = new Item[50];
		/**
		 * Book 클래스의 생성자를 이용해 책의 제목, 가격, 수량, 저자, 출판사, 카테고리 속성을 지정해 배열에 넣는다.
		 */
		myInventory[0] = new Book("Godzilla on Holiday", 24.95, 5, "Wesley Wynhae-Price", "Ransom Mouse", "FICTION");
		myInventory[1] = new Book("Loch Ness Memories", 49.95, 1, "Fred MacMurray", "Penguin Press", "FICTION");
		myInventory[2] = new Book("MVS JCL", 89.95, 3, "Steve Balmer", "Microsoft Press", "NON-FICTION");
		myInventory[3] = new Book("Lingo in a Nutshell", 19.95, 8, "Bill Bates", "0'Reilly", "NON-FICTION");
		myInventory[4] = new Book("Grid Computing", 79.95, 2, "Bobby Beowold", "Trouser Press", "NON-FICTION");
		/**
		 * Artist 클래스의 생성자를 이용해 일단 아티스트의 이름을 할당해둔다.
		 * Artist는 Item을 상속하지 않음에 주의
		 * 
		 * CD 클래스의 생성자를 이용해 제목, 가격, 수량, 아티스트, 출시일 설정.
		 */
		Artist artist1 = new Artist("YES");
		myInventory[5] = new CD("Going For the One", 12.95, 4, artist1, new Date("07/07/1977"));
		
		Artist artist2 = new Artist("Bozos");
		myInventory[6] = new CD("Going Down The Country", 12.95, 10, artist2, new Date("07/07/1977"));
		
		Artist artist3 = new Artist("Jimmy and the Yupper");
		myInventory[7] = new CD("Polka Favorites", 2.95, 4, artist3, new Date("07/07/1977"));
		/**
		 * ClassicalCD 생성자를 이용해 제목, 가격, 수량, 아티스트, 연주자, 녹음장소, 출시일 설정
		 */
		String [] performers1 = {"Henry", "Elizabeth", "Franz", "Arthur"};
		myInventory[8] = new ClassicalCD("Romeo and Julliet", 22.95, 1, "Joe Green", performers1, "New York", new Date("01/01/2001"));
		
		String [] performers2 = {"Vivaldi", "Johnson", "Arturo", "Wenselous"};
		myInventory[9] = new ClassicalCD("A Rorp in The Park", 22.95, 3, "Beethoven", performers2, "Hamburg", new Date("01/01/2001"));
		/**
		 * Inventory 클래스에서 설정한 produceReport 메서드를 통해 지금까지 입력된 myInventory를 출력하고,
		 * 마지막 줄에 TOTAL 가격과 수량 표시하도록 설정
		 */
		Inventory.produceReport(myInventory);
		}
	}

