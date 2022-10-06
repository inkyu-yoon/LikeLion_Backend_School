package Lecture.Date221006.ReadFileExample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileMain {
    public void printFiles(){
        File dir = new File("./");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println("file = " + file);
        }
    }
    public static void main(String[] args) throws IOException {
        //한 바이트 읽기
        List<Student> studentList = new ArrayList<>();
        ReadFile readFile = new ReadFile("height.txt"); // 읽어올 텍스트 파일이 프로젝트 최 상단 폴더에 존재해야함
        System.out.println(readFile.readOneLine());
        System.out.println(readFile.readNLine(10));
/*
id	hid	height
4885	KNIHGR006101	161.8
4886	KNIHGR006447	149.8
4887	KNIHGR005811	155
4888	KNIHGR001715	161.8
4889	KNIHGR003156	168.1
4890	KNIHGR002556	150.2
4891	KNIHGR002134	168.3
4892	KNIHGR002594	153.5
4893	KNIHGR007449	168.8
4894	KNIHGR007973	166.6

 */


//
//        studentList = readFile.getAllInfo(readFile.getLineNumber());
//        for (Student student : studentList) {
//            System.out.println("student = " + student);
//        }


    }
}
