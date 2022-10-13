package October.Lecture.Date221013.Bubble;

import java.util.Arrays;

public class BubbleMain {
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,1,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr = swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    static int[] swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}
