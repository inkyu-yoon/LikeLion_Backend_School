package October.Assignment.CodeUp1071_1080;

import java.util.Scanner;

public class No_1078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <= N; i+=2) {
            sum += i;
        }
        System.out.println(sum);

    }
}
