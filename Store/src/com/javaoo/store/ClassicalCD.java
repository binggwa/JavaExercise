package com.javaoo.store;

import java.util.Date;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * Item을 상속하는 ClassicalCD 클래스에서 작곡가, 연주자, 녹음 장소, 출시 날짜를 추가.
 */
public class ClassicalCD extends Item {
	/**
	 * 작곡가, 녹음장소 속성을 문자열로 추가, 연주자 이름을 performers 문자열 배열로 추가, 녹음장소와 출시일을 추가.
	 */
	private String composer;
	private String[] performers = new String[5];
	private String recordingLocation;
	private Date releaseDate;
	private int performer_count = 0;
	/**
	 * classicalCD에 대한 생성자 추가.
	 */
	public ClassicalCD(String title, double price, int quantity, String composer, String[] performers, String recordingLocation, Date releaseDate) {
		super(title, price, quantity);
		this.setComposer(composer);
		this.setRecordingLocation(recordingLocation);
		this.setReleaseDate(releaseDate);
		/**
		 * for구문을 이용해 performers 배열에 등록된 연주자 수만큼만 연주자를 추가하도록 설정
		 */
		for ( int i = 0; i < performers.length; i++) {
			if ( performers[i] != null ) {
				addPerformer(performers[i]);
			}
		}
		this.performers = performers;
	}
	
	/**
	 * performers 배열을 제외한 각 속성에 대한 게터와 세터 설정
	 */
	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getRecordingLocation() {
		return recordingLocation;
	}

	public void setRecordingLocation(String recordingLocation) {
		this.recordingLocation = recordingLocation;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	 * addPerformer 메서드 추가
	 * 
	 * 배열에 이미 사용중인 공간을 알아야 하므로, int 타입의 performer_count 속성을 설정하고 0으로 초기화해둠.
	 * 
	 * if-else 문을 통해 배열에 공간이 있는지 테스트
	 * 배열의 길이보다 performer_count가 작다면, addPerformer 메서드를 통해 받은 문자열 연주자 이름을 배열에 추가 및 performer_count가 1씩 증가하도록 설정.
	 * 결국 배열의 길이보다 카운트가 커지게 되면, 더 이상 배열에 추가하지 않고, 배열이 꽉 찼다는 안내메시지를 출력.
	 */
	public void addPerformer(String performer) {
		if(performer_count >= performers.length)
			System.out.println("The performers array is full! Cannot add " + performer);
		else {
			performers[performer_count] = performer;
			performer_count++;
		}
	}
	/**
	 * 모든 연주자를 표시하는 메서드 추가.
	 * 
	 * performers 배열에 추가된 연주자를 반복하여 출력해주는 메서드.
	 * 
	 * 만들어둔 performer_count 속성을 사용해 카운트가 0일 경우, 배열을 출력하지 말도록 설정.
	 * for 구문을 이용해 performer_count 수에 이를때까지 performers 배열에 담긴 문자열을 출력하도록 설정.
	 */
	public void showPerformers() {
		if (performer_count == 0)
			System.out.println("No performers have been added for this CD");
		for ( int i = 0; i < performer_count; i++ )
			System.out.println("Performer: " + performers[i]);
	}
}
