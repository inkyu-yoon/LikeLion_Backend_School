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
            System.out.println(Arrays.toString(arr));
        }
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
i = 1  ||  arr[0] vs arr[1]  ||  5 vs 8
[5, 8, 6, 2, 4]

i = 2  ||  arr[1] vs arr[2]  ||  6 vs 8
[5, 6, 8, 2, 4]
i = 2  ||  arr[0] vs arr[1]  ||  5 vs 6
[5, 6, 8, 2, 4]

i = 3  ||  arr[2] vs arr[3]  ||  2 vs 8
[5, 6, 2, 8, 4]
i = 3  ||  arr[1] vs arr[2]  ||  2 vs 6
[5, 2, 6, 8, 4]
i = 3  ||  arr[0] vs arr[1]  ||  2 vs 5
[2, 5, 6, 8, 4]

i = 4  ||  arr[3] vs arr[4]  ||  4 vs 8
[2, 5, 6, 4, 8]
i = 4  ||  arr[2] vs arr[3]  ||  4 vs 6
[2, 5, 4, 6, 8]
i = 4  ||  arr[1] vs arr[2]  ||  4 vs 5
[2, 4, 5, 6, 8]
i = 4  ||  arr[0] vs arr[1]  ||  2 vs 4
[2, 4, 5, 6, 8]

[2, 4, 5, 6, 8]

Process finished with exit code 0



     */