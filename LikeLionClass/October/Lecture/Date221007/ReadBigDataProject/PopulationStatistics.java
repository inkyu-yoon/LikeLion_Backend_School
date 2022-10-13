package October.Lecture.Date221007.ReadBigDataProject;

import java.io.*;

public class PopulationStatistics {

    public static void main(String[] args) throws IOException {
        ManageFile manageFile = new ManageFile();
        //데이터 관리하기 위한 객체
        ReadAction readAction = new ReadAction("./BigDataRepository.csv");
        //↑ 데이터 얻어오기 위한 객체

        String[] cityCode = {"11", "26", "27", "28", "29", "30", "31", "36", "41", "42", "43", "44", "45", "46", "47", "48", "50"};
        String[] cityName = {"서울", "부산", "대구", "인천", "광주", "대전", "울산","세종", "경기도", "강원도", "충북", "충남", "전북", "전남", "경북", "경남", "제주"};
        //빅데이터의 알고싶은 코드의 *인덱스*와, 각 *코드*가 *의미하는 내용*에 대한 배열을 입력하면 출력할 수 있음.


        StringBuilder dataForHeatmap = new StringBuilder();
        //↑ 전입 -> 전출 데이터 전용 (히트맵 데이터)
        StringBuilder dataForTranslate = new StringBuilder();
        // 지역코드를 지명으로 변경하여 유의미한 데이터 저장

        dataForHeatmap=readAction.dataForHeatmap(cityCode, cityName, 0,6);
        // ↑ 알고싶은 인덱스는 0번째와 6번째 인덱스, 해당 인덱스의 데이터에 대한 정보를 StringBuilder 에 저장한 후 반환
        dataForTranslate=readAction.dataForTrans(cityCode, cityName, 0,6);
        // ↑ 알고싶은 인덱스는 0번째와 6번째 인덱스, 해당 인덱스의 데이터에 대한 정보를 StringBuilder 에 저장한 후 반환

        //텍스트 파일에 저장하는 과정
        String writeFileName1 = "for_heatmap.txt";
        manageFile.writeTextFile(writeFileName1,dataForHeatmap);


        String writeFileName2 = "for_translate.txt";
        manageFile.writeTextFile(writeFileName2,dataForTranslate);



    }
}
