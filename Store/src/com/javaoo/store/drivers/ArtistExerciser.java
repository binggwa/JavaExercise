package com.javaoo.store.drivers;

import java.util.TreeSet;
import static java.lang.System.out;
import com.javaoo.store.Artist;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 3 컬렉션
 *
 * @author 이병관
 * @since 2025.03.24
 *
 * Artist 클래스 실행을 위한 드라이버
 */
public class ArtistExerciser {

    public static void main(String[] args) {
        Artist hotPlate = new Artist[];
        /**
         * instruments1에 TreeSet으로 요소 추가
         */
        TreeSet<String> instruments1 = new TreeSet<>();
        instruments1.add("Piano");
        instruments1.add("Clarient");
        instruments1.add("Murdy Gurdy");
        instruments1.add("Tuba");
        hotPlate.addMember("Tom", instruments1);
        /**
         * instruments2에 TreeSet으로 요소 추가
         */
        TreeSet<String> instruments2 = new TreeSet<>();
        instruments2.add("Guitar");
        instruments2.add("Saxophone");
        instruments2.add("Bass Drum");
        hotPlate.addMember("Steve", instruments2);

        printMemberInstruments(hotPlate, "Tom");
        printMemberInstruments(hotPlate, "Steve");
    }

    private static void printMemberInstruments(Artist artist, String memberName) {
        out.println("HotPlate band member " + memberName + " plays: ");
        for (String instrument : artist.getInstruments(memberName)) {
            out.println("\t" + instrument);
        }
    }
}