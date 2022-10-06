package Lecture.Date221006.ReadFileExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private String fileName;

    ReadFile(String fileName) {
        this.fileName=fileName;
    }
    char readOneWord() throws IOException {
        //지정한 파일의 맨 앞 한 byte를 읽어오는 메서드를 만들기
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        return (char)br.read();
    }
    String readNWord(int N) throws IOException {
        //지정한 파일의 맨 앞 한 byte를 읽어오는 메서드를 만들기
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String output ="";
        for (int i = 0; i < N; i++) {
            output+=(char)(br.read());
        }
        return output;
    }
}