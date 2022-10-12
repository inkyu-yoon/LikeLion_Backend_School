package Lecture.Date221012.Algorithm;

import java.util.Scanner;

public class No_4596 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            array[i][j] = scanner.nextInt();
            }
        }
        int max = array[0][0];
        int index_row = 0;
        int index_col = 0;

        //초기 인덱스랑 최댓값은 인덱스 0 값으로
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    index_row = i;
                    index_col = j;
                }
            }
        }
        System.out.println(max);
        System.out.println((index_row+1)+" "+(index_col+1));


    }
}
