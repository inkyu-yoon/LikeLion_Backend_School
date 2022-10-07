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

    void getAllInfo() throws IOException{

        String str;
        while((str=br.readLine()) !=null){
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
        String str;
        while ((str = br.readLine()) != null) {
            String[] input = str.split(",");
            int inCity = Integer.valueOf(input[0]);
            int outCity = Integer.valueOf(input[6]);
            DataInfo dataInfo = new DataInfo(inCity, outCity);

            if(countInCityCode.containsValue(inCity)) {
                countInCityCode.put(inCity, countInCityCode.get(inCity) + 1);
            }else{
                countInCityCode.put(inCity, 1);
            }
            if(countOutCityCode.containsValue(outCity)) {
                countOutCityCode.put(inCity, countOutCityCode.get(outCity) + 1);
            }else{
                countOutCityCode.put(outCity, 1);
            }
//            System.out.println(dataInfo);
        }
        System.out.println(countOutCityCode);
        System.out.println(countInCityCode);

    }


}
