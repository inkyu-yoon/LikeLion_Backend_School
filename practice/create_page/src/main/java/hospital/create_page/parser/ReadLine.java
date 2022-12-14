package hospital.create_page.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLine <T> {

    private Parser<T> parser;
    private boolean isColumn = true;

    public ReadLine(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readByLine(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        if (isColumn) {
            br.readLine();
        }
        String str;
        while ((str = br.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.println(str);
                System.out.printf("파싱중 문제가 생겨 이 라인은 넘어갑니다. 파일내용:%s\n", str.substring(0, 20));
            }
        }
        br.close();
        return result;
    }

}
