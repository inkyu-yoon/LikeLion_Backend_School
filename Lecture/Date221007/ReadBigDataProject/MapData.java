package Lecture.Date221007.ReadBigDataProject;

import java.util.Map;

public class MapData {
    Map<String, Integer> countMap;
    MapData( Map<String, Integer> countMap){
        this.countMap = countMap;
    }

    public void printInfo(){
        countMap.forEach((k, v) -> System.out.println(String.format("키 값은 %s  벨류 값은 %s", k, v)));
    }
}
