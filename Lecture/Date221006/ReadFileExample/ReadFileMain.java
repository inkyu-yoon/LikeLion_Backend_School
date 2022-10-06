package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {
    public static void main(String[] args) throws IOException {
        //한 바이트 읽기
        String path = System.getProperty("user.dir")+"\\";
        // 프로젝트 최 상단 경로를 불러옴
        // txt파일은 최 상단에 존재함

        String fileName = "test.txt";
        //파일 이름


        ReadFile readFile = new ReadFile(path+fileName);
        System.out.println(readFile.readOneWord());
        System.out.println(readFile.readNWord(5));
        System.out.println(readFile.readNWord(10));
    }


}