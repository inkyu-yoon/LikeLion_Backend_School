package October.Lecture.Date221031;

import java.util.*;

public class Programmers1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = {1, 2,3,4,5};
        int[] solution1 = solution.solution(answers);
        System.out.println(Arrays.toString(solution1));

    }

}
class Solution {
    //수포자 1 : 1 2 3 4 5
    //수포자 2 : 2 1 2 3 2 4 2 5
    //수포자 3 : 3 3 1 1 2 2 4 4 5 5
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] Man1 = {1, 2, 3, 4, 5};
        int[] Man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] Man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};


        int Man1Score = countScore(answers, Man1);
        int Man2Score = countScore(answers, Man2);
        int Man3Score = countScore(answers, Man3);

        int maxScore = Math.max(Man1Score, Math.max(Man2Score, Man3Score));
        if (Man1Score >= maxScore) {
            answer.add(1);
        }
        if (Man2Score >= maxScore) {
            answer.add(2);
        }
        if (Man3Score >= maxScore) {
            answer.add(3);
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    int countScore(int[] answers, int[] Man) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == Man[i % Man.length]) {
                count++;
            }
        }
        return count;
    }
}