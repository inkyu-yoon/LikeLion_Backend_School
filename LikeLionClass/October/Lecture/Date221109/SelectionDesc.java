package October.Lecture.Date221109;

import java.util.Arrays;

public class SelectionDesc implements Selection{
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int maxIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = max;
            arr[maxIndex] = tmp;


            System.out.println("i : " + i);
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
