package Lecture.Date221007.ReadBigDataProject;

import java.io.*;
import java.util.Map;

public class PopulationStatistics {
    static void createAFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
    }

    public static void main(String[] args) throws IOException {
        ReadAction readAction1 = new ReadAction("./BigDataRepository.csv");
        ReadAction readAction2 = new ReadAction("./BigDataRepository.csv");

        int[] cityCode = {11, 21, 22, 23, 24, 25, 26, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39};
        String[] cityName = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기도", "강원도", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};

        //빅데이터의 알고싶은 코드의 *인덱스*와, 각 *코드*가 *의미하는 내용*에 대한 배열을 입력하면 출력할 수 있음.
        //자유롭게 정보 출력 가능 -> 조금 더더 객체지향적으로도 만들 수는 있을 듯....?
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();


        sb1=readAction1.getBigDataWithIndex(cityCode, cityName, 0);
        // ↑ 알고싶은 인덱스는 0번째 인덱스, 해당 인덱스의 데이터에 대한 정보 배열 입력

        sb2=readAction2.getBigDataWithIndex(cityCode, cityName, 6);

        String writeFileName = "from_to.txt";
        createAFile(writeFileName); //"텍스트 파일 생성"
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writeFileName)));
        //파일 경로 지정, 이제 bw.write 로 써주기만 하면 됨

        bw.write(sb1.append(sb2).toString());
        bw.close();
        //텍스트 파일에 정보 저장 완료.



        MapData map1 = new MapData(readAction1.getCountMap());
        MapData map2 = new MapData(readAction2.getCountMap());
//        map1.printInfo();
//        map2.printInfo();

        //만약 키 값이 11인 전입자 데이터를 구하고 싶다면 map1이 전입자 데이터이므로 키 값을 이용해서 찾는다.
        System.out.println(map1.countMap.get(11));

    }
}
/*
출력화면



=======전입 데이터를 표시합니다.========
서울(11)  값은 1189998명(개) 입니다.
부산(21)  값은 0명(개) 입니다.
대구(22)  값은 0명(개) 입니다.
인천(23)  값은 0명(개) 입니다.
광주(24)  값은 0명(개) 입니다.
대전(25)  값은 0명(개) 입니다.
울산(26)  값은 388869명(개) 입니다.
세종(29)  값은 179158명(개) 입니다.
경기도(31)  값은 118237명(개) 입니다.
강원도(32)  값은 0명(개) 입니다.
충북(33)  값은 0명(개) 입니다.
충남(34)  값은 0명(개) 입니다.
전북(35)  값은 0명(개) 입니다.
전남(36)  값은 57000명(개) 입니다.
경북(37)  값은 0명(개) 입니다.
경남(38)  값은 0명(개) 입니다.
제주(39)  값은 0명(개) 입니다.

최댓값은 서울(11) 1189998명(개) 입니다.


=======전출 데이터를 표시합니다.========
서울(11)  값은 1227491명(개) 입니다.
부산(21)  값은 0명(개) 입니다.
대구(22)  값은 0명(개) 입니다.
인천(23)  값은 0명(개) 입니다.
광주(24)  값은 0명(개) 입니다.
대전(25)  값은 0명(개) 입니다.
울산(26)  값은 403502명(개) 입니다.
세종(29)  값은 183625명(개) 입니다.
경기도(31)  값은 127846명(개) 입니다.
강원도(32)  값은 0명(개) 입니다.
충북(33)  값은 0명(개) 입니다.
충남(34)  값은 0명(개) 입니다.
전북(35)  값은 0명(개) 입니다.
전남(36)  값은 49219명(개) 입니다.
경북(37)  값은 0명(개) 입니다.
경남(38)  값은 0명(개) 입니다.
제주(39)  값은 0명(개) 입니다.

최댓값은 서울(11) 1227491명(개) 입니다.

Process finished with exit code 0


 */