package October.Lecture.Date221031;

import java.util.*;

public class Programmers1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = {2,3,4,5,1};
        int[] solution1 = solution.solution(answers);
        System.out.println(Arrays.toString(solution1));

    }

}
class Solution {
    //수포자 1 : 1 2 3 4 5
    //수포자 2 : 2 1 2 3 2 4 2 5
    //수포자 3 : 3 3 1 1 2 2 4 4 5 5
        List<Integer> answer = new ArrayList<>();
        int number = 1;
    public int[] solution(int[] answers) {
        int[] Man1 = {1, 2, 3, 4, 5};
        int[] Man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] Man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};

        int Man1Score = countScore(answers, Man1);
        int Man2Score = countScore(answers, Man2);
        int Man3Score = countScore(answers, Man3);

        int [] Scores = {Man1Score,Man2Score,Man3Score};
        int maxScore = Math.max(Man1Score, Math.max(Man2Score, Man3Score));

        for (int score : Scores) {
        addRank(maxScore, score);
        }


        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    void addRank(int MaxScore, int ManScore) {
        if (ManScore >= MaxScore) {
            answer.add(number);
        }
        number++;
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