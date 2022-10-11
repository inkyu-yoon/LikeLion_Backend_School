package Lecture.Date221011.findDigitSum;

public class findSum2{

    public static void main(String[] args) {
        findSum2 findSum2 = new findSum2();
        System.out.println(findSum2.solution(987));

    }
    public int solution(int n){
        int sum =0;
        while (n != 0) {
            sum += n % 10;
            n/=10;
        }
        return sum;
    }
}
