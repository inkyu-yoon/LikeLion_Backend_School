package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {
    public static void main(String[] args) throws IOException {
        //한 바이트 읽기

        ReadFile readFile = new ReadFile("./test.txt"); // 읽어올 텍스트 파일이 프로젝트 최 상단 폴더에 존재해야함
        System.out.println(readFile.readOneWord());
        System.out.println(readFile.readNWord(5));
        System.out.println(readFile.readNWord(10));
    }


}