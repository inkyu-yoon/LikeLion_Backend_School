package Lecture.Date221006.ReadFileExample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileMain {
    public void printFiles() {
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

        readFile.getAllInfo();
        /*
        id는 4886  || hid는 KNIHGR006447  || height는 149.8
id는 4888  || hid는 KNIHGR001715  || height는 161.8
id는 4890  || hid는 KNIHGR002556  || height는 150.2
id는 4892  || hid는 KNIHGR002594  || height는 153.5
id는 4894  || hid는 KNIHGR007973  || height는 166.6
id는 4898  || hid는 KNIHGR003860  || height는 155.2
......
....
id는 3704  || hid는 KNIHGR006726  || height는 166.5
id는 3712  || hid는 KNIHGR007598  || height는 163.0
id는 3726  || hid는 KNIHGR007666  || height는 170.5
id는 3484  || hid는 KNIHGR002695  || height는 167.0
         */
    }
}
