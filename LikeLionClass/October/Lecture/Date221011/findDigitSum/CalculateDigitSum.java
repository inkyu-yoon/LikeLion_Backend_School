package October.Lecture.Date221011.findDigitSum;

import java.util.Scanner;

public class CalculateDigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while(String.valueOf(findSum(N)).length()!=1) {
            N=findSum(N);
        }
        System.out.println(findSum(N));
        
    }

    static int findSum(int N) {
        int result = 0;
        while (N != 0) {
            result += N % 10;
            N /= 10;
        }
        return result;
    }
}
