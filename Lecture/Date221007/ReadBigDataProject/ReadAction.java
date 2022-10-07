package Lecture.Date221007.ReadBigDataProject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadAction {
    private String fileAddress;
    private BufferedReader br;
    private Map<String, Integer> countMap;
    public ReadAction(String fileAddress) throws IOException {
        this.fileAddress = fileAddress;
        br = new BufferedReader(new FileReader(fileAddress));
    }

    Map<String,Integer> getCountMap(){
        return countMap;
    }




    StringBuilder dataForHeatmap(String [] code , String [] codeName, int index, int index2) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //↑ 여기서 생기는 모든 데이터들을 StringBuilder 에 쌓아둘 것이다. 그리고 마지막에 반환할 것

//        sb.append("\n\n데이터의 "+index+" 번째, "+index2+" 번째 인덱스 데이터 입니다.\n\n");

        for (int i = 0; i < code.length; i++) {
            for(int j=0;j<code.length;j++){
                countMap.put(code[i]+","+code[j], 0);
            }
        }
        //↑ 맵(key,value) 각 키 값에 해당하는 value 값을 0으로 초기화 시키기
        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //읽어온 데이터가 null 값이 되면, 데이터가 더이상 없다는 것
            String[] input = oneLineFromBigData.split(","); // ',' 를 기준으로 데이터를 나누고 String 배열에 입력
            String info = input[index]+","+input[index2]; //(index,index2)에 해당하는 데이터를 가져옴

            if (countMap.get(info) != null) { //null 값이 아닌 경우에만 해당 데이터 value 값을 1 증가 시킴
                countMap.put(info, countMap.get(info) + 1);
            }
        }

        //↑ Map 이용해서 데이터 갯수 세기


        //아래는 데이터 출력 과정
        for (int k = 0; k < code.length; k++) {
            for(int l=0;l<code.length;l++){
//            sb.append(codeName[k]+","+codeName[l]+"("+code[k]+","+code[l]+") " + " 값은 " + countMap.get(code[k]+","+code[l]) + "명(개) 입니다.\n");
                sb.append("["+(k)+", "+(l)+", " + countMap.get(code[k]+","+code[l]) + "],\n");

            }
        }


        return sb;
        //↑ 모든 내용들이 StringBuilder 에 저장되어 반환된다.
    }

    StringBuilder dataForTrans(String [] code , String [] codeName, int index, int index2) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //↑ 여기서 생기는 모든 데이터들을 StringBuilder 에 쌓아둘 것이다. 그리고 마지막에 반환할 것

        sb.append("\n\n데이터의 "+index+" 번째, "+index2+" 번째 인덱스 데이터 입니다.\n\n");

        for (int i = 0; i < code.length; i++) {
            for(int j=0;j<code.length;j++){
                countMap.put(code[i]+","+code[j], 0);
            }
        }
        //↑ 맵(key,value) 각 키 값에 해당하는 value 값을 0으로 초기화 시키기
        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //읽어온 데이터가 null 값이 되면, 데이터가 더이상 없다는 것
            String[] input = oneLineFromBigData.split(","); // ',' 를 기준으로 데이터를 나누고 String 배열에 입력
            String info = input[index]+","+input[index2]; //(index,index2)에 해당하는 데이터를 가져옴

            if (countMap.get(info) != null) { //null 값이 아닌 경우에만 해당 데이터 value 값을 1 증가 시킴
                countMap.put(info, countMap.get(info) + 1);
            }
        }

        //↑ Map 이용해서 데이터 갯수 세기

        int count = 0;
        //아래는 데이터 출력 과정
        for (int k = 0; k < code.length; k++) {
            for(int l=0;l<code.length;l++){
                sb.append(codeName[k]+" -> "+codeName[l]+"("+code[k]+" -> "+code[l]+") " + " 값은 " + countMap.get(code[k]+","+code[l]) + "명(개) 입니다.\n");
                count += Integer.valueOf(countMap.get(code[k] + "," + code[l]));
            }
        }

        sb.append(" 총 데이터의 갯수는 "+count+"개 입니다.");
        return sb;
        //↑ 모든 내용들이 StringBuilder 에 저장되어 반환된다.
    }

}