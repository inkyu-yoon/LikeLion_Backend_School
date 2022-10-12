package Lecture.Date221012.Algorithm;

import java.util.Scanner;

public class No_2081 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = scanner.nextInt();
        }
        int max = array[0];
        int index =0;

        //초기 인덱스랑 최댓값은 인덱스 0 값으로
        for (int i = 1; i < array.length; i++) { //원소 1부터 검사하면된다.
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);


    }
}
