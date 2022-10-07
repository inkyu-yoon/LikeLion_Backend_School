package Lecture.Date221007.ReadBigDataProject;

import Lecture.Date221006.ReadFileExample.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    void getAllInfo() throws IOException {

        String str;
        while ((str = br.readLine()) != null) {
            String[] input = str.split(",");
            int inCity = Integer.valueOf(input[0]);
            int outCity = Integer.valueOf(input[6]);
            DataInfo dataInfo = new DataInfo(inCity, outCity);
            System.out.println(dataInfo);
        }


    }

    void getDataMap() throws IOException {
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
        //초기화 시키기

        String str = "";
//        for(int i=0;i<=4;i++){
//            String[] input = br.readLine().split(",");
        while ((str = br.readLine()) != null) {
            String[] input = str.split(",");
            int inCity = Integer.valueOf(input[0]);
            int outCity = Integer.valueOf(input[6]);
            if (countInCityCode.get(inCity) != null) {
                countInCityCode.put(inCity, countInCityCode.get(inCity) + 1);
            }
            if (countOutCityCode.get(outCity) != null) {
                countOutCityCode.put(outCity, countOutCityCode.get(outCity) + 1);
            }
//            DataInfo dataInfo = new DataInfo(inCity, outCity);
//            System.out.println(dataInfo);

        }
        System.out.println();
        System.out.println("=========Show Data===========");
        System.out.println(countOutCityCode);
        System.out.println(countInCityCode);

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
