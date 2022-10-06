package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {
    public static void main(String[] args) throws IOException {
        //한 바이트 읽기

        ReadFile readFile = new ReadFile("C:\\Users\\ikyoo\\Desktop\\멋쟁이사자처럼 백엔드 스쿨\\LikeLion_Backend_School\\Lecture\\Date221006\\ReadFileExample\\test.txt");
        System.out.println(readFile.readOneByte());
    }


}
