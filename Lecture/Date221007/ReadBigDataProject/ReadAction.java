package Lecture.Date221007.ReadBigDataProject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadAction {
    private String fileAddress;
    private BufferedReader br;
    private Map<Integer, Integer> countMap;
    public ReadAction(String fileAddress) throws IOException {
        this.fileAddress = fileAddress;
        br = new BufferedReader(new FileReader(fileAddress));
    }

    Map<Integer,Integer> getCountMap(){
        return countMap;
    }

    StringBuilder getBigDataWithIndex(int [] code , String [] codeName, int index1) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //여기서 생기는 모든 데이터들을 StringBuilder 에 쌓아둘 것이다.

        sb.append("\n\n");

        for (int i = 0; i < code.length; i++) {
            countMap.put(code[i], 0);
        }
        //맵(key,value) 각 키 값에 해당하는 value 값을 0으로 초기화 시키기

        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //읽어온 데이터가 null 값이 되면, 데이터가 더이상 없다는 것
            String[] input = oneLineFromBigData.split(","); // ',' 를 기준으로 데이터를 나누고 String 배열에 입력
            int info = Integer.valueOf(input[index1]); //첫번째 데이터가 전입 행정구역 코드


            if (countMap.get(info) != null) { //null 값이 아닌 경우에만 해당 행정구역의 value 값을 1 증가 시킴
                countMap.put(info, countMap.get(info) + 1);
            }
        }

        //아래는 데이터 출력 과정
        int maxIndex =0;
        for (int k = 0; k < code.length; k++) {
//            System.out.println(codeName[k]+"("+code[k]+") " + " 값은 " + countMap.get(code[k]) + "명(개) 입니다.");
            sb.append(codeName[k]+"("+code[k]+") " + " 값은 " + countMap.get(code[k]) + "명(개) 입니다.\n");
            if(countMap.get(code[k])>countMap.get(code[maxIndex])){
                maxIndex = k;
            }
        }

//        System.out.println();
//        System.out.println("최댓값은 "+codeName[maxIndex]+"("+code[maxIndex]+") " + "" + countMap.get(code[maxIndex]) + "명(개) 입니다.");

        sb.append("\n최댓값은 "+codeName[maxIndex]+"("+code[maxIndex]+") " + "" + countMap.get(code[maxIndex]) + "명(개) 입니다.\n\n");

        return sb;
        //모든 내용들이 StringBuilder 에 저장되어 반환된다.
    }





}
