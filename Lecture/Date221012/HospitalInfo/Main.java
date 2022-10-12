package Lecture.Date221012.HospitalInfo;

import Lecture.Date221012.HospitalInfo.domain.Hospital;
import Lecture.Date221012.HospitalInfo.parser.HospitalParser;

import java.io.IOException;
import java.util.List;

//1. 데이터가 저장되어 있는 파일의 위치(이름) 을 알려준다.
//2. 저장하고 싶은 파일명을 작성하고 저장한다.

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "./서울시 병의원 위치 정보.txt";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);


        ManageFile manageFile = new ManageFile();

        String writeFileName1 = "hospital_data.sql";
        manageFile.writeTextFile(writeFileName1,manageFile.makeSQLForm(hospitals));


    }
}
