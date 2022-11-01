package likelion.hospital_korea.Parser;

import likelion.hospital_korea.domain.Hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLineContext<T> {

    private Parser<T> parser;
    private boolean isColumn = true;
    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T>readByOneLine(String filename) throws IOException {

        // 삽
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str;
        if (isColumn) {
            reader.readLine();
        }

        if ((str = reader.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("파싱중 문제가 생겨 이 라인은 넘어갑니다. 파일내용:%s\n", str.substring(0, 20));
            }
        }
        reader.close();
        return result;
    }

    public List<T> readByLine(String filename) throws IOException {

        // 삽
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str;
        if (isColumn) {
            reader.readLine();
        }

        while ((str = reader.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("파싱중 문제가 생겨 이 라인은 넘어갑니다. 파일내용:%s\n", str.substring(0, 20));
            }
        }
        reader.close();
        return result;
    }
}

