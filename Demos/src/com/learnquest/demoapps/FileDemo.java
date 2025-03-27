package com.learnquest.demoapps;
/**
 * CoreJava 강의 Java 클래스 라이브러리
 * Module 5 File IO
 *
 * @author 이병관
 * @since 2025.03.27
 */
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class fileDemo {
    /**
     * file과 text를 인수로 받는 contains 메서드
     */
    public static boolean contains(Path file, String text) {
        try {
            /**
             * 보고 있는 파일이 regularfile이라면, 디렉토리 전체를 살펴보기 때문에, 디렉토리는 건너뛴다
             * 우리가 찾는 파일에 특정 line에 전달한 문자열이 포함되어 있다면, true를 반환한다
             */
            return Files.isRegularFile(file) && Files.lines(file).anyMatch(line -> line.contains(text));
        }
        catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 디폴트 파일 시스템을 구한다.
         * PathMatcher를 구해서 우리가 갖고 있는 모든 java 파일이 어디에 있던 사용할 수 있다
         */
        PathMatcher javaFiles = FileSystems.getDefault().getPathMatcher("glob:**/*.java");
        /**
         * 경로인 현재 작업 디렉토리를 구한다.
         * user.dir의 프로퍼티를 가져와 해당 문자열의 경로를 구한다.
         */
        Path cwd = Paths.get(System.getProperty("user.dir"));
        /**
         * NIO의 Files에 현재 작업 디렉토리에서 시작하여 디렉토리 트리를 경로로 탐색한 다음 필터링하도록 지시
         * Java 파일 경로 매쳐와 일치하는 경로만 원한다 -> 디렉토리 트리 어딘가의 .java로 끝나는 곳만 탐색
         */
        Stream<Path> javaPaths = Files.walk(cwd).filter(path -> javaFiles.matches(path));
        /**
         * System 이라는 단어가 들어 있는 파일을 탐색하여 출력한다.
         */
        javaPaths.filter(path -> FileDemo.contains(path, "System")).forEach(System.out::println);
    }
}