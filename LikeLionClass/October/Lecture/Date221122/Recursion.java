package October.Lecture.Date221122;

public class Recursion {

    static int[] arr = {7, 3, 2, 9};

    public static void main(String[] args) {
        print1To100(1);
        System.out.println("arraySum(arr.length-1) = " + arraySum(arr.length-1));
        printStar(3);
        System.out.println();
        System.out.println("getSum(10) = " + getSum(10));
    }

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
        printStar(n-1);

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
