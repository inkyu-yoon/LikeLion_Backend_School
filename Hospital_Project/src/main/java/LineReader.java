
import parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//LineReader의 기능 정리
//1. 파일로부터 데이터를 1줄씩 읽으며, 속성 명이 있는 경우와 없는 경우를 설정할 수 있다.(기본값 첫 1행 제거)
//2. 한 라인을 읽어 parser에 따라 parser가 지정한 객체의 변수값에 필요한 값들을 기록하고, 객체를 List에 집어넣는다.
//3. 예시로 이번 경우에는 파일을 한 라인씩 읽어 Hospital 객체의 id,병원명, 주소 등등의 데이터를 기록한다.
public class LineReader<T> {
    Parser<T> parser;
    boolean isColumn = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser,boolean isColumn) {
        this.parser = parser;
        this.isColumn = isColumn;
    }

    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if (isColumn) {
            br.readLine();
        }
        while ((str = br.readLine()) != null) {
            result.add(parser.parse(str));
        }
        return result;
    }


}