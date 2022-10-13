package October.Assignment.CodeUp1021_1030;

import java.util.Scanner;

public class No_1025 {
    public static void main(String[] args) {
        //무조건 5자리 수 입력 받음
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] unit = {10000, 1000, 100, 10, 1};
        for (int i = 0; i < input.length(); i++) {
            System.out.println("[" + ((input.charAt(i)-'0')*unit[i]) + "]");
        }
    }
}
