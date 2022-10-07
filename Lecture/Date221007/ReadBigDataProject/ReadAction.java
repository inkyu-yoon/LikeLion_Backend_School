package Lecture.Date221007.ReadBigDataProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadAction {
    private String fileAddress;
    private BufferedReader br;

    public ReadAction(String fileAddress) throws IOException {

        this.fileAddress = fileAddress;
        br = new BufferedReader(new FileReader(fileAddress));
    }

    void readOneLine() throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        System.out.println(br.readLine());
    }

    void readNLine(int N) throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        for (int i = 1; i <= N; i++) {
            System.out.println(br.readLine());
        }
    }

    void readAllLine() throws IOException {
        System.out.println();
        System.out.println("=========Show Data===========");
        String str = "";
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }


    void getDataInAndOut() throws IOException {
        Map<Integer, Integer> countInCityCode = new HashMap<>();
        Map<Integer, Integer> countOutCityCode = new HashMap<>();

        //행정구역 코드 서울 : 11 부산 : 21 대구 : 22 인천 :23 광주 : 24 대전 : 25 울산 :26
        // 세종 : 29 경기도 : 31 강원도 :32 충북 : 33 충남 :34 전북 : 35 전남 : 36 경북 : 37 경남 : 38 제주 : 39
        int[] cityCode = {11, 21, 22, 23, 24, 25, 26, 29, 31, 32, 33, 34, 35, 36, 37, 38, 39};
        String[] cityName = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종", "경기도", "강원도", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};

        for (int i = 0; i < cityCode.length; i++) {
            countOutCityCode.put(cityCode[i], 0);
            countInCityCode.put(cityCode[i], 0);
        }
        //맵(key,value) 행정구역 코드는 key 값이 될 것, 각 키 값에 해당하는 value 값을 0으로 초기화 시키기

        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //읽어온 데이터가 null 값이 되면, 데이터가 더이상 없다는 것
            String[] input = oneLineFromBigData.split(","); // ',' 를 기준으로 데이터를 나누고 String 배열에 입력
            int inCity = Integer.valueOf(input[0]); //첫번째 데이터가 전입 행정구역 코드
            int outCity = Integer.valueOf(input[6]); // 7번째 데이터가 전출 행정구역 코드

            if (countInCityCode.get(inCity) != null) { //null 값이 아닌 경우에만 해당 행정구역의 value 값을 1 증가 시킴
                countInCityCode.put(inCity, countInCityCode.get(inCity) + 1);
            }
            if (countOutCityCode.get(outCity) != null) { //null 값이 아닌 경우에만 해당 행정구역의 value 값을 1 증가 시킴
                countOutCityCode.put(outCity, countOutCityCode.get(outCity) + 1);
            }
        }

        //아래는 데이터 출력 과정

        System.out.println();
        System.out.println();
        System.out.println("=======전입 데이터를 표시합니다.========");
        for (int k = 0; k < cityCode.length; k++) {
            System.out.println(cityName[k] + " (으)로 " + countInCityCode.get(cityCode[k]) + " 명이 전입했습니다.");
        }

        System.out.println();
        System.out.println();
        System.out.println("========전출 데이터를 표시합니다.=======");
        for (int k = 0; k < cityCode.length; k++) {
            System.out.println(cityName[k] + " (으)로 " + countOutCityCode.get(cityCode[k]) + " 명이 전출했습니다.");
        }
    }
}
