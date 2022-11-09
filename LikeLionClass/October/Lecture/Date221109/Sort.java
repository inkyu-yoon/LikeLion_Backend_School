package October.Lecture.Date221109;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        //오름차순
        Selection selectionSort = new SelectionAsc();
        int[] arr = {2, 7, 4, 9, 10, 223, 111, 23, 3, 39};
        arr = selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        //내림차순
        selectionSort = new SelectionDesc();
        arr = selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
