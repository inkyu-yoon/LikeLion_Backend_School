package October.Lecture.Date221114;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {6, 4, 6, 1, 5, 3, 9, 10, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int start, int end) {
        int pivotPoint = getPoint(arr, start, end);
        if (start + 1 < pivotPoint) {
            quickSort(arr, start, pivotPoint - 1);
        }
        if (end > pivotPoint) {
            quickSort(arr, pivotPoint, end);
        }

    }

    static int getPoint(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }
}
