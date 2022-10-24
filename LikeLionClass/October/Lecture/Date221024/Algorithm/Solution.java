package October.Lecture.Date221024.Algorithm;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] sliced;
        int index = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            Arrays.sort(sliced = Arrays.copyOfRange(array, i - 1, j));
            answer[index++] = sliced[k - 1];
        }


        return answer;
    }

    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        int index = 0;
        for (int number : numbers) {
            arr[index++] = String.valueOf(number);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.charAt(0) == b.charAt(0)) {
                return (a+b).compareTo(b+a);
            }
            return a.compareTo(b);
        });
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,0,0};
        solution.solution(arr);
        System.out.println("solution.solution(arr) = " + solution.solution(arr));
    }
}