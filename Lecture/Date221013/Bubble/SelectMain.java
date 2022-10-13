package Lecture.Date221013.Bubble;

import java.util.Arrays;

public class SelectMain {
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 9, 28, 11};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr = swap(arr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
    static int[] swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}
