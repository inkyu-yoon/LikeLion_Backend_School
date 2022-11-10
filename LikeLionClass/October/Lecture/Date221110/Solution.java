package October.Lecture.Date221110;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {95,94};
        int[] arr2 = {3,3};
        System.out.println(Arrays.toString(s.solution3(arr,arr2)));

    }
    //기능개발

    public int[] solution3(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ans = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        for (Integer integer : q) {
            System.out.println(integer);
        }

        while (!q.isEmpty()) {
            int count = 0;
            int max = q.peek();

            while (max >= q.peek()) {
                count++;
                q.poll();
                if (q.isEmpty()) {
                    break;
                }
            }

            ans.offer(count);
        }
        answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.poll();
        }
        return answer;
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


//스택 쓰고

    public int[] solution2(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = arr[i];
            if (arr[i] != arr[i + 1]) {
                tmp = arr[i + 1];
                stack.push(tmp);
            }
        }
        answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }

}