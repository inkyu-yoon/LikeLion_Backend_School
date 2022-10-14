package October.Assignment.CodeUp1071_1080;

import java.util.Scanner;

public class No_1080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;
        int i = 0;
        for (; ; i++) {
            sum += i;
            if (sum >= N) {
                break;
            }
        }
        System.out.println(i);

    }
}
