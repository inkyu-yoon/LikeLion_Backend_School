package Lecture.Date221013.Bubble;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 4, 6, 3, 1, 2, 3, 5, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int separatePoint = getPoint(arr, start, end);
        if (start < separatePoint - 1) {
            quickSort(arr, start, separatePoint - 1);
        }
        if (end>separatePoint){
            quickSort(arr, separatePoint, end);
        }
    }

    static int getPoint(int[] arr, int start, int end) {
        int Pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (Pivot > arr[start]) {
                start++;
            }
            while (Pivot < arr[end]) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
}
