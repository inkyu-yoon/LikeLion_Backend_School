package likelion.hospital_korea.Parser;

import java.io.BufferedReader;
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

    public List<T> readByLine(String filename) throws IOException {

        // 삽
        List<T> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String str;
        if (isColumn) {
            reader.readLine();
        }
        int index =1;
        while ((str = reader.readLine()) != null) {
            result.add(parser.parse(str));
        }
        reader.close();
        return result;
    }
}

