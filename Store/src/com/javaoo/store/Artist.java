package com.javaoo.store;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 3 컬렉션
 *
 * @author 이병관
 * @since 2025.03.24
 */
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * CoreJava 강의 Java의 객체 지향 계층 구조 
 * Module 3 상속 과제
 * 
 * @author 이병관
 * @since 2025.03.11
 * 
 * CD의 경우 아티스트가 밴드 이름과 여러 멤버가 있는 밴드라고 가정.
 * 스토어는 밴드 이름, 각 멤버의 이름, 각 멤버가 연주하는 악기를 추적하려 하므로 이를 Artist 클래스로 따로 관리.
 */
public class Artist {
	/**
	 * 아티스트 이름을 받아올 문자열 이름, 20개의 문자열 배열인 멤버이름과 악기이름을 추가.
	 */
	/**
	 * 250324 컬렉션 학습을 통해 배열을 컬렉션으로 대체
	 */
	private String name;
	// private String[] memberNames = new String[20];
	// private String[] memberInstruments = new String[20];
	private SortedSet<String> memberNames;
	private Map<String,SortedSet<String>> memberInstruments;

	/*
	public Artist(String name) {
		super();
		this.setName(name);
	}
	 */
	/**
	 * Default 생성자
	 * TreeSet에는 문자열 참조만 포함되어있고, TreeMap에도 문자열과 정렬된 문자열 세트가 포함되어 있다.
	 */
	public Artist() {
		memberNames = new TreeSet();
		memberInstruments = new TreeMap();
	}
	/**
	 * @param name
	 * @param memberNames
	 * @param memberInstruments
	 */
	public Artist(String name, SortedSet<String> memberNames, Map<String, SortedSet<String>> memberInstruments) {
		super();
		setName(name);
		this.memberNames = memberNames;
		this.memberInstruments = memberInstruments;
	}

	public void addMember(String name, SortedSet<String> instruments) {
		memberNames.add(name);
		memberInstruments.put(name, instruments);
	}
	/**
	 * 이름에 대한 게터와 세터 설정
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SortedSet<String> getMembers() {
		return memberNames;
	}

	public SortedSet<String> getInstruments(String memberName) {
		return memberInstruments.get(memberName);
	}
}
