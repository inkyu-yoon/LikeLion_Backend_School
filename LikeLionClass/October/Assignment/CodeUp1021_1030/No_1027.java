package October.Assignment.CodeUp1021_1030;

import java.util.Scanner;

public class No_1027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\.");
        int year = Integer.valueOf(input[0]);
        int month = Integer.valueOf(input[1]);
        int day = Integer.valueOf(input[2]);
        System.out.printf("%02d-%02d-%04d", day, month, year);

        }
    }

