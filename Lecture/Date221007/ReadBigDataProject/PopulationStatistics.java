package Lecture.Date221007.ReadBigDataProject;

import java.io.*;
import java.util.Map;

public class PopulationStatistics {
    static void createAFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
    }

    public static void main(String[] args) throws IOException {
        ReadAction readActionAboutFrom = new ReadAction("./BigDataRepository.csv");
        //↑ 전입 데이터 전용 객체
        ReadAction readActionAboutTo = new ReadAction("./BigDataRepository.csv");
        //↑ 전출 데이터 전용 객체

        int[] cityCode = {11, 26, 27, 28, 29, 30, 31, 41, 42, 43, 44, 45, 46, 47, 48, 50};
        String[] cityName = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "경기도", "강원도", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};

        //빅데이터의 알고싶은 코드의 *인덱스*와, 각 *코드*가 *의미하는 내용*에 대한 배열을 입력하면 출력할 수 있음.
        //자유롭게 정보 출력 가능 -> 조금 더더 객체지향적으로도 만들 수는 있을 듯....?

        StringBuilder sbAboutFrom = new StringBuilder();
        //↑ 전입 데이터 전용
        StringBuilder sbAboutTo = new StringBuilder();
        //↑ 전출 데이터 전용


        sbAboutFrom=readActionAboutFrom.getBigDataWithIndex(cityCode, cityName, 0);
        // ↑ 알고싶은 인덱스는 0번째 인덱스, 해당 인덱스의 데이터에 대한 정보를 StringBuilder 에 저장한 후 반환
        sbAboutTo=readActionAboutTo.getBigDataWithIndex(cityCode, cityName, 6);
        // ↑ 알고싶은 인덱스는 6번째 인덱스, 해당 인덱스의 데이터에 대한 정보를 StringBuilder 에 저장한 후 반환


        //텍스트 파일에 저장하는 과정
        String writeFileName = "from_to.txt";
        createAFile(writeFileName); //"텍스트 파일 생성"
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writeFileName)));
        //↑ 파일 경로 지정, 이제 bw.write 로 써주기만 하면 됨

        bw.write(sbAboutFrom.append(sbAboutTo).toString());
        bw.close();
        //↑ 텍스트 파일에 정보 저장 완료.



        MapData mapAboutFrom = new MapData(readActionAboutFrom.getCountMap());
        MapData mapAboutTo = new MapData(readActionAboutTo.getCountMap());
//        map1.printInfo();
//        map2.printInfo();

        System.out.println(mapAboutFrom.countMap.get(11));
        //↑만약 키 값이 11인 전입자 데이터를 구하고 싶다면
        System.out.println(mapAboutTo.countMap.get(26));
        //↑만약 키 값이 26인 전출자 데이터를 구하고 싶다면
    }
}
/*
출력화면
1189998
403502

텍스트 파일 내용 ↓

데이터의 0번째 인덱스 데이터 입니다.

서울(11)  값은 1189998명(개) 입니다.
부산(26)  값은 388869명(개) 입니다.
대구(27)  값은 248884명(개) 입니다.
인천(28)  값은 356523명(개) 입니다.
광주(29)  값은 179158명(개) 입니다.
대전(30)  값은 186858명(개) 입니다.
울산(31)  값은 118237명(개) 입니다.
경기도(41)  값은 1659916명(개) 입니다.
강원도(42)  값은 196360명(개) 입니다.
충북(43)  값은 199171명(개) 입니다.
충남(44)  값은 263359명(개) 입니다.
전북(45)  값은 205596명(개) 입니다.
전남(46)  값은 217063명(개) 입니다.
경북(47)  값은 302280명(개) 입니다.
경남(48)  값은 353519명(개) 입니다.
제주(50)  값은 86532명(개) 입니다.

최댓값은 경기도(41) 1659916명(개) 입니다.



데이터의 6번째 인덱스 데이터 입니다.

서울(11)  값은 1227491명(개) 입니다.
부산(26)  값은 403502명(개) 입니다.
대구(27)  값은 268328명(개) 입니다.
인천(28)  값은 351571명(개) 입니다.
광주(29)  값은 183625명(개) 입니다.
대전(30)  값은 190806명(개) 입니다.
울산(31)  값은 127846명(개) 입니다.
경기도(41)  값은 1565438명(개) 입니다.
강원도(42)  값은 193336명(개) 입니다.
충북(43)  값은 197727명(개) 입니다.
충남(44)  값은 257551명(개) 입니다.
전북(45)  값은 212012명(개) 입니다.
전남(46)  값은 223532명(개) 입니다.
경북(47)  값은 303087명(개) 입니다.
경남(48)  값은 369309명(개) 입니다.
제주(50)  값은 84943명(개) 입니다.

최댓값은 경기도(41) 1565438명(개) 입니다.

 */