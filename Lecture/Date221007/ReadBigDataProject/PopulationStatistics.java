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
서울 (으)로 1189998 명이 전입했습니다.
부산 (으)로 0 명이 전입했습니다.
대구 (으)로 0 명이 전입했습니다.
인천 (으)로 0 명이 전입했습니다.
광주 (으)로 0 명이 전입했습니다.
대전 (으)로 0 명이 전입했습니다.
울산 (으)로 388869 명이 전입했습니다.
세종 (으)로 179158 명이 전입했습니다.
경기도 (으)로 118237 명이 전입했습니다.
강원도 (으)로 0 명이 전입했습니다.
충북 (으)로 0 명이 전입했습니다.
충남 (으)로 0 명이 전입했습니다.
전북 (으)로 0 명이 전입했습니다.
전남 (으)로 57000 명이 전입했습니다.
경북 (으)로 0 명이 전입했습니다.
경남 (으)로 0 명이 전입했습니다.
제주 (으)로 0 명이 전입했습니다.


========전출 데이터를 표시합니다.=======
서울 (으)로 1227491 명이 전출했습니다.
부산 (으)로 0 명이 전출했습니다.
대구 (으)로 0 명이 전출했습니다.
인천 (으)로 0 명이 전출했습니다.
광주 (으)로 0 명이 전출했습니다.
대전 (으)로 0 명이 전출했습니다.
울산 (으)로 403502 명이 전출했습니다.
세종 (으)로 183625 명이 전출했습니다.
경기도 (으)로 127846 명이 전출했습니다.
강원도 (으)로 0 명이 전출했습니다.
충북 (으)로 0 명이 전출했습니다.
충남 (으)로 0 명이 전출했습니다.
전북 (으)로 0 명이 전출했습니다.
전남 (으)로 49219 명이 전출했습니다.
경북 (으)로 0 명이 전출했습니다.
경남 (으)로 0 명이 전출했습니다.
제주 (으)로 0 명이 전출했습니다.

Process finished with exit code 0


 */