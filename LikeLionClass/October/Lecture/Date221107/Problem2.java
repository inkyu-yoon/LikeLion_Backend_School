package October.Lecture.Date221107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,36,1,3};

        System.out.println(Arrays.toString(s.solution(arr,1)));
    }
}
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        } else {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        return answer;
        }



    }
}