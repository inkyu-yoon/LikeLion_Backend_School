package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {
    public static void main(String[] args) throws IOException {
        //한 바이트 읽기
        String filePath = "C:\\Users\\ikyoo\\Desktop\\멋쟁이사자처럼 백엔드 스쿨\\LikeLion_Backend_School\\Lecture\\Date221006\\ReadFileExample\\test.txt";
        ReadFile readFile = new ReadFile(filePath);
        System.out.println(readFile.readOneWord());
        System.out.println(readFile.readNWord(5));
    }


}