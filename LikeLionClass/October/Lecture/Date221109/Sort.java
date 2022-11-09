package October.Lecture.Date221109;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minIndex] = tmp;


            System.out.println("i : " + i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
