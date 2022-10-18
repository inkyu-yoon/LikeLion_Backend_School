package October.Lecture.Date221018.Algorithm;

import java.util.Scanner;

public class SquareStar {
    public static void main(String[] args) {
        //n 찍으면 n*n
        //x,y 받으면 x*y
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
