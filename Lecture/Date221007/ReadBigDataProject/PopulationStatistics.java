package Lecture.Date221007.ReadBigDataProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PopulationStatistics {
    public static void main(String[] args) throws IOException {
        ReadAction readAction = new ReadAction("./BigDataRepository.csv");
//        readAction.readOneLine();
//        readAction.readNLine(10);
        readAction.getAllInfo();
//        readAction.getDataMap();
    }
}
/*
출력화면
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=30}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=28}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=26}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=48}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=42}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=44}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=42}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=28}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=26}
DataInfo{inCity=50, outCity=27}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=44}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=44}
DataInfo{inCity=50, outCity=30}
DataInfo{inCity=50, outCity=47}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=44}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=43}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=26}
DataInfo{inCity=50, outCity=46}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=28}
DataInfo{inCity=50, outCity=48}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=28}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=11}
DataInfo{inCity=50, outCity=27}
DataInfo{inCity=50, outCity=41}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
DataInfo{inCity=50, outCity=50}
.... 100만개
 */