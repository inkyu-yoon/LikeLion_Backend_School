package Assignment.CodeUp1061_1070;

import java.util.Scanner;

public class No_1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int[] unit = {90, 70, 40, 0};
        char[] grade = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < unit.length; i++) {
            if (a >= unit[i]) {
                System.out.println(grade[i]);
                break;
            }
        }
    }
}

