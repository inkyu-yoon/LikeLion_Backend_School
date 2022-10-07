package Lecture.Date221007.ReadBigDataProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadAction {
    private String fileAddress;
    private BufferedReader br;
    public ReadAction(String fileAddress) throws IOException {

        this.fileAddress = fileAddress;
        br = new BufferedReader(new FileReader(fileAddress));
    }

    void readOneLine() throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        System.out.println(br.readLine());
    }
    void readNLine(int N) throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        for (int i = 1; i <= N; i++) {
        System.out.println(br.readLine());
        }
    }
    void readAllLine() throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }



}
