package October.Lecture.Date221018.Algorithm;

import java.util.Scanner;

public class SquareStar2 {
    public static void main(String[] args) {
        //n 찍으면 n*n
        //x,y 받으면 x*y
        Scanner scanner = new Scanner(System.in);
        System.out.println("높이 : ");
        int n = scanner.nextInt();
        System.out.println("너비 : ");
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
