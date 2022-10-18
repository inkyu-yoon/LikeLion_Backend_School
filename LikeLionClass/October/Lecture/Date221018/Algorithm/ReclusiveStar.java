package October.Lecture.Date221018.Algorithm;

import java.util.Scanner;

public class ReclusiveStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Star(n);
    }

    static void Star(int n){

        if (n == 0) {
            return ;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        Star(n-1);
    }
}
