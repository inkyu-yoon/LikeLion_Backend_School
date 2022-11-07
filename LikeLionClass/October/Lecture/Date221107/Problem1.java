package October.Lecture.Date221107;

public class Problem1 {
    public static void main(String[] args) {
        int num1 = 12345;

        int result =0;
        while (num1 > 0) {
            result += num1 % 10;
            num1/=10;
        }
        System.out.println(result);
    }
}
