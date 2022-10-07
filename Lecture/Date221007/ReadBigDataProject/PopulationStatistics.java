package Lecture.Date221007.ReadBigDataProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PopulationStatistics {
    public static void main(String[] args) throws IOException {
        ReadAction readAction = new ReadAction("./BigDataRepository.csv");
//        readAction.readOneLine();
//        readAction.readNLine(10);
//        readAction.getAllInfo();
        readAction.getDataMap();
    }
}
/*
출력화면

=========Show Data===========
{32=0, 33=0, 34=0, 35=0, 36=49219, 37=0, 38=0, 39=0, 11=1227491, 21=0, 22=0, 23=0, 24=0, 25=0, 26=403502, 29=183625, 31=127846}
{32=0, 33=0, 34=0, 35=0, 36=57000, 37=0, 38=0, 39=0, 11=1189998, 21=0, 22=0, 23=0, 24=0, 25=0, 26=388869, 29=179158, 31=118237}

 */