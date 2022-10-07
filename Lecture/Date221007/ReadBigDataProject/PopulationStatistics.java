package Lecture.Date221007.ReadBigDataProject;

import java.io.IOException;

public class PopulationStatistics {
    public static void main(String[] args) throws IOException {
        int[] cityCode = {11, 21, 22, 23, 24, 25, 26, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39};
        String[] cityName = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기도", "강원도", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};

        ReadAction readAction = new ReadAction("./BigDataRepository.csv");
        System.out.println();
        System.out.println();
        System.out.println("=======전입 데이터를 표시합니다.========");
        readAction.getDataInAndOut(cityCode,cityName,0);


        System.out.println();
        System.out.println();
        System.out.println("=======전출 데이터를 표시합니다.========");
        readAction.getDataInAndOut(cityCode,cityName,6);
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

Process finished with exit code 0


 */