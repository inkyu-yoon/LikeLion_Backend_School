package Assignment.CodeUp1011_1020;

import java.util.Scanner;

public class No_1020 {
    public static void main(String[] args) {
        //주민번호 형태 바꿔서 출력하기
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("-");
        System.out.println(input[0] + input[1]);
    }
}
