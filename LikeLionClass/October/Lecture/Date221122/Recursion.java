package October.Lecture.Date221122;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    static int[] arr = {7, 3, 2, 9};

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        print1To100(1);
        System.out.println("arraySum(arr.length-1) = " + arraySum(arr.length - 1));
        printStar(3);
        System.out.println();
        System.out.println("getSum(10) = " + getSum(10));
        System.out.println("getSum2(1234) = " + getSum2(1234));
        list.add(7);
        list.add(3);
        list.add(2);
        list.add(9);
        System.out.println("getSum3(list.size()-1) = " + getSum3(list.size()-1));
    }

    static int getSum3(int n) {
        if (n < 0) {
            return 0;

        }
        return list.get(n) + getSum3(n - 1);
    }

    // 재귀로 각 자리 수의 합 구하기
    static long getSum2(long n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + getSum2(n / 10);
    }

    //1 부터 n 까지 재귀로 합 구하기
    static int getSum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + getSum(n - 1);
    }

    //별 출력
    static void printStar(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("*");
        printStar(n - 1);

    }

    // 배열 합 재귀
    static int arraySum(int n) {
        if (n < 0) {
            return 0;
        }
        return arr[n] + arraySum(n - 1);
    }

    //출력 재귀
    static void print1To100(int n) {
        if (n > 100) {
            return;
        }
        System.out.println(n);
        print1To100(n + 1);
    }

}
