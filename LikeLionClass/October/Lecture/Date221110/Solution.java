package October.Lecture.Date221110;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(s.solution(arr)));

    }
    //스택 안쓰고
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = arr[i];
            if (arr[i] != arr[i + 1]) {
                tmp = arr[i + 1];
                list.add(tmp);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public int[] solution2(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = arr[i];
            if (arr[i] != arr[i + 1]) {
                tmp = arr[i + 1];
                stack.add(tmp);
            }
        }
        answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }

}