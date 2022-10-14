package October.Lecture.Date221014.insertion;

import java.util.Arrays;

public class InsertionSortMain {
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 9, 28, 11};

        arr = insertionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}
