package Assignment.CodeUp1011_1020;

import java.util.Scanner;

import static java.lang.Integer.*;

public class No_1019 {
    //년 월 일을 입력받아 yyyy,mm,dd 형식으로 출력
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\.");
        // dot으로 split 하려면 .는 예약어이므로 위와 같이 표현해야함!!
        System.out.printf("%04d.%02d.%02d", valueOf(input[0]), valueOf(input[1]), valueOf(input[2]));
    }
}
