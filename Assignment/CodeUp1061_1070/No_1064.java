package Assignment.CodeUp1061_1070;

import java.util.Scanner;

public class No_1064 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(a<b?(a<c?a:c):(b<c?b:c));
    }
}

