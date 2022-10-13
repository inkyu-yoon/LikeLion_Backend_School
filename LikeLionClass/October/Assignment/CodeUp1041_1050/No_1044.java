package October.Assignment.CodeUp1041_1050;

import java.util.Scanner;

public class No_1044 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println((long)(a+b));
        System.out.println((long)(a-b));
        System.out.println((long)(a*b));
        System.out.println((long)(a/b));
        System.out.println((long)(a%b));
        System.out.printf("%.2f",((double) a) / b);
    }
}
