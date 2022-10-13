package October.Lecture.Date221013.Bubble;

import java.util.Arrays;

public class BubbleFront {
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,1,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i <arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    arr = swap(arr, i, j);
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
