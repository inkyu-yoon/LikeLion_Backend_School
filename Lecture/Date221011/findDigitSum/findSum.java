package Lecture.Date221011.findDigitSum;

import java.util.*;

public class findSum{
    public int solution(int n){

        String input = String.valueOf(n);
        int sum=0;
        for (int i = 0; i < input.length(); i++) {
            sum += input.charAt(i) - '0';
        }
        System.out.println(sum);
        return sum;
    }
}