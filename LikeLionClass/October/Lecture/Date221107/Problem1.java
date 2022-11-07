package October.Lecture.Date221107;

public class Problem1 {
    public static void main(String[] args) {
        int num1 = 687;
        int num2 = num1;
        int result =0;
        while (num1 > 0) {
            result += num1 % 10;
            num1/=10;
        }
        System.out.println("자릿수합: "+result);
        System.out.println(num2%result==0?"하샤드수 맞음":"하샤드수 아님");
    }
}
