package com.javaoo.store;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 5 IO
 *
 * @author 이병관
 * @since 2025.03.27
 */
import static java.lang.System.out;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class BookExeciser {

    public static void main(String[] args) {
        /**
         * Book 제네릭으로 정의된 책 목록
         * location은 books.txt 파일 위치
         */
        String location = "C:\\Users\\qudrh\\JavaExercise\\Store\\src\\com\\javaoo\\store\\books.txt";
        List<Book> books = readBooksFromFile(location);

        for (Book book : books) {
            out.println(book.getTitle());
        }
    }
    /**
     * readBooksFromFile 메서드 정의
     */
    public static ArrayList readBooksFromFile(String name) {
        /**
         * 책으로 구성된 배열리스트
         * 파일, 리더, 라인 리더기에 null값을 저장해둔다.
         */
        ArrayList books = new ArrayList();
        FileInputStream inFile = null;
        InputStreamReader inReader = null;
        LineNumberReader lineReader = null;
        try {
            inFile = new FileInputStream(name);
            inReader = new InputStreamReader(inFile);
            lineReader = new LineNumberReader(inReader);
            /**
             * 문서의 첫 줄을 읽을 수 있도록 제목 설정
             * 저자와 String 가격, double 가격을 설정
             */
            String title = lineReader.readLine();
            while (title != null) {
                String author = lineReader.readLine();
                String sPrice = lineReader.readLine();
                double price = Double.parseDouble(sPrice);
                /**
                 * 책의 정보를 입력하여 책 세트에 추가
                 */
                Book book = new Book(title, price, 5, author, null, "NON-FICTION");
                books.add(book);

                title = lineReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * null이 아닌 값이 있다면, 닫도록 설정
             */
            try {
                if (lineReader != null) {
                    lineReader.close();
                }
                if (inFile != null) {
                    inFile.close();
                }
                if (inReader != null) {
                    inReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return books;
    }
}