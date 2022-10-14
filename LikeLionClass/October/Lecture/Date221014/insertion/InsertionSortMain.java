package October.Lecture.Date221014.insertion;

import java.util.Arrays;

public class InsertionSortMain {
    public static void main(String[] args) {
        int[] arr = {8, 5, 6, 2, 4};

        arr = insertionSort(arr, 1);

        System.out.println(Arrays.toString(arr));

    }

    private static int[] insertionSort(int[] arr, int i) {
        if (i == arr.length) {
            return arr;
        }
        System.out.println("Loop = " + i);
        System.out.println("정렬 전 ");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================");
        for (int j = i; j >= 1; j--) {
            if (arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                System.out.println("arr[" + (j - 1) + "] 과 arr[" + (j) + "]" + "교환  ||  " + arr[j - 1] + " vs " + arr[(j)]);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();

        insertionSort(arr, i + 1);
        return arr;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }
}


    /* 출력화면
Loop = 1
정렬 전
[8, 5, 6, 2, 4]
===================
arr[0] 과 arr[1]교환  ||  5 vs 8
[5, 8, 6, 2, 4]

Loop = 2
정렬 전
[5, 8, 6, 2, 4]
===================
arr[1] 과 arr[2]교환  ||  6 vs 8
[5, 6, 8, 2, 4]

Loop = 3
정렬 전
[5, 6, 8, 2, 4]
===================
arr[2] 과 arr[3]교환  ||  2 vs 8
arr[1] 과 arr[2]교환  ||  2 vs 6
arr[0] 과 arr[1]교환  ||  2 vs 5
[2, 5, 6, 8, 4]

Loop = 4
정렬 전
[2, 5, 6, 8, 4]
===================
arr[3] 과 arr[4]교환  ||  4 vs 8
arr[2] 과 arr[3]교환  ||  4 vs 6
arr[1] 과 arr[2]교환  ||  4 vs 5
[2, 4, 5, 6, 8]

[2, 4, 5, 6, 8]



     */