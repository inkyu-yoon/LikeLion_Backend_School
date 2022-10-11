package Lecture.Date221011.findDigitSum;

import java.util.Scanner;

public class CalculateDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;
        while (N != 0) {
            result++;
            N /= 10;
        }

        System.out.println(result);

    }
}
