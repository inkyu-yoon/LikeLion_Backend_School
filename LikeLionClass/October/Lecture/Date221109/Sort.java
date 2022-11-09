package October.Lecture.Date221109;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        //오름차순

        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};

        selectionSort(arr, (min, num) -> min > num);
        selectionSort(arr, (max, num) -> max < num);


    }
    static int[] selectionSort(int[] arr, StatementStrategy stmt) {
        for (int i = 0; i < arr.length; i++) {
            int maxOrMin = arr[i];
            int maxOrMinIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (stmt.apply(maxOrMin , arr[j])) {
                    maxOrMin = arr[j];
                    maxOrMinIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = maxOrMin;
            arr[maxOrMinIndex] = tmp;


            System.out.println("i : " + i);
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
interface StatementStrategy{
    boolean apply(int maxOrMin, int num);
}
