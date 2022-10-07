package Lecture.Date221007.ReadBigDataProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PopulationStatistics {
    public static void main(String[] args) throws IOException {
        ReadAction readAction = new ReadAction("./BigDataRepository.csv");
        readAction.readOneLine();
        readAction.readNLine(10);

    }
}
