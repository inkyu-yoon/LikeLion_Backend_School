package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private String fileName;
    private BufferedReader br;

    private List<Student> studentList;
    ReadFile(String fileName) throws IOException {
        this.fileName = fileName;
        br = new BufferedReader(new FileReader(this.fileName));
    }

    char readOneWord() throws IOException {
        //지정한 파일의 맨 앞 한 byte를 읽어오는 메서드를 만들기
        return (char) br.read();
    }

    String readNWord(int N) throws IOException {


        String output = "";

        for (int i = 0; i < N; i++) {
            output += (char) (br.read());
        }

        return output;
    }

    String readOneLine() throws IOException {
        return br.readLine();
    }
    String readNLine(int num) throws IOException {

        String result = "";
        for (int i = 0; i < num; i++) {
            result += br.readLine() + "\n";
        }

        return result;
    }

    int getLineNumber() throws IOException {
        int count = 0;
        while (br.readLine() != null) {
            count++;
        }
        return count;
    }

    List<Student> getAllInfo(int lineNum) throws IOException{
        br.readLine();
        for (int i = 0; i < lineNum; i++) {
            String[] input = br.readLine().split(" ");
            int id = Integer.valueOf(input[0]);
            String hid = input[1];
            int height = Integer.valueOf(input[2]);
            studentList.add(new Student(id, hid, height));
        }
        return studentList;
    }


}