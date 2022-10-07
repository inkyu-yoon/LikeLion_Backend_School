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
서울 값은 1189998 입니다.
부산 값은 0 입니다.
대구 값은 0 입니다.
인천 값은 0 입니다.
광주 값은 0 입니다.
대전 값은 0 입니다.
울산 값은 388869 입니다.
세종 값은 179158 입니다.
경기도 값은 118237 입니다.
강원도 값은 0 입니다.
충북 값은 0 입니다.
충남 값은 0 입니다.
전북 값은 0 입니다.
전남 값은 57000 입니다.
경북 값은 0 입니다.
경남 값은 0 입니다.
제주 값은 0 입니다.


=======전출 데이터를 표시합니다.========
서울 값은 1227491 입니다.
부산 값은 0 입니다.
대구 값은 0 입니다.
인천 값은 0 입니다.
광주 값은 0 입니다.
대전 값은 0 입니다.
울산 값은 403502 입니다.
세종 값은 183625 입니다.
경기도 값은 127846 입니다.
강원도 값은 0 입니다.
충북 값은 0 입니다.
충남 값은 0 입니다.
전북 값은 0 입니다.
전남 값은 49219 입니다.
경북 값은 0 입니다.
경남 값은 0 입니다.
제주 값은 0 입니다.

Process finished with exit code 0



 */