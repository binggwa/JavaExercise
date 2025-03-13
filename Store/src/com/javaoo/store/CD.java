package com.javaoo.store;
/**
 * Date사용을 위한 java.util.Date 클래스 임포트
 */
import java.util.Date;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * Item을 상속하는 CD 클래스에서 아티스트와 발매일 추가.
 */
public class CD extends Item {
	/**
	 * Artist 타입의 아티스트와 Date 타입의 발매일 속성 추가.
	 */
	private Artist artist;
	private Date releaseDate;
	/**
	 * Item의 속성과 CD에 추가된 속성을 이용한 CD 생성자 추가
	 */
	public CD(String title, double price, int quantity, Artist artist, Date releaseDate) {
		super(title, price, quantity);
		this.setArtist(artist);
		this.setReleaseDate(releaseDate);
	}
	/**
	 * 각 속성에 대한 게터와 세터 설정
	 */
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
