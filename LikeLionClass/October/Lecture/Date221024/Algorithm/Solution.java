package October.Lecture.Date221024.Algorithm;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] sliced;
        int index =0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            Arrays.sort(sliced=Arrays.copyOfRange(array,i-1,j));
            answer[index++]=sliced[k-1];
        }


        return answer;
    }
}