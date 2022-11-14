package October.Lecture.Date221114;

import java.util.Arrays;

public class Algorithm {
    public static void main(String[] args) {
        int num = 50;

        int[] arr = new int[num + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 2; i * i <= num; i++) {
            for (int j = i * i; j <= num; j += i) {
                arr[j] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
