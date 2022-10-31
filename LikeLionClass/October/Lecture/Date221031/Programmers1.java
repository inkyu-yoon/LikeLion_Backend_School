package October.Lecture.Date221031;

public class Programmers1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = {1, 3, 2, 4, 2};
        solution.solution(answers);
    }

}

class Solution {
    //수포자 1 : 1 2 3 4 5
    //수포자 2 : 2 1 2 3 2 4 2 5
    //수포자 3 : 3 3 1 1 2 2 4 4 5 5
    public int[] solution(int[] answers) {

        int[] Man1 = {1, 2, 3, 4, 5};
        int[] Man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] Man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};

        int Man1Score = countScore(answers, Man1);
        int Man2Score = countScore(answers, Man2);
        int Man3Score = countScore(answers, Man3);


        int[] answer = {1, 2, 3};


        return answer;
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