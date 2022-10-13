package October.Assignment.CodeUp1061_1070;

import java.util.Scanner;

public class No_1066 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[3];
        arr[0] = scanner.nextInt();
        arr[1] = scanner.nextInt();
        arr[2] = scanner.nextInt();
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println("even");
            }
            else System.out.println("odd");
        }
    }
}

