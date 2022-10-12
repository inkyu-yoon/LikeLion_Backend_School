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

/* 결과물 예시
('A1121066','서울특별시 영등포구 국회대로 612 코레일유통 사옥 20층 (당산동3가)','서울특별시 영등포구','C','2','근로복지공단서울의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
('A1121665','서울특별시 광진구 광나루로 517 B1~3층 (구의동)','서울특별시 광진구','C','2','근본정형외과의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
('A1123276','서울특별시 강남구 도산대로81길 51 루미안빌 5층 (청담동)','서울특별시 강남구','C','2','글래시피부과의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
('A1116157','서울특별시 서초구 강남대로 483 청호빌딩 2층 (반포동)','서울특별시 서초구','C','2','글램외과의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
('A1104188','서울특별시 서초구 서초대로74길 3 글로리빌딩 2~6층 (서초동)','서울특별시 서초구','C','2','글로리서울안과의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
 */
