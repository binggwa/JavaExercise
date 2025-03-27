# 1. NIO.2 샘플
***
### zip을 실제로 파일 시스템으로 취급하는 방법
```java
/**
 * URI를 전달하는 새 파일 시스템 생성
 */
URI uri = URI.create("jar:file:/codeSamples/zipfs/zipfstest.zip");
FileSystem fs = FileSystems.newfileSystem(uri, env);

Path zipfile = Paths.get("/codeSamples/zipfs/zipfstest.zip");
FileSystem fs = FileSystems.newFileSystem(zipfile, env, null);
/**
 * 파일을 zip 파일에 붙이는 코드
 */
// Zip a single file
public static void zipSingleFileNio(Path source, String zipFileName)
    throws IOException {
    /**
     * 파일을 넣으려는 zip 파일의 경로와 이름이 주어졌을 때, 
     * 넣으려는 내용이 파일이 아니라면 무시된다.
     */
    if (!Files.isRegularFile(source)) {
        System.err.println("Please provide a file.");
        return;
    }
    /**
     * HashMap과 같은 환경을 만들고 존재하지 않는 경우, zip파일을 만든다.
     */
    Map<String, String> env = new HashMap<>();
    // Create the zip file if it doesn't exist
    env.put("create", "true");
    /**
     * URI를 설정한다.
     */
    URI uri = URI.create("jar:file:/home/mkyoung/" + zipFileName);
    /**
     * zip 파일 시스템으로 설정
     * zip 파일 시스템에 파일 이름 경로를 묻는다.
     */
    try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
        Path pathInZipfile = zipfs.getPath(source.getFileName().toString());
        /**
         * 소스를 zip 파일의 해당 경로에 복사, 있는 경우 대체
         */
        // Copy a file into the zip file path
        Files.copy(source, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
    }
}
```
***
읽기 자료
- [Zip File System Provider](https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html)
- [Custom File System Provider](https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/filesystemprovider.html)
- [Zip 예제 세트](https://mkyong.com/java/how-to-compress-files-in-zip-format/)
- [TAR 파일 시스템 공급자의 구현](https://github.com/StavSaad/archive-fs)
- [in-memory 파일 시스템 공급자](https://github.com/google/jimfs)