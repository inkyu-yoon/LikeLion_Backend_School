package October.Lecture.Date221103;

public class Primes {
    //100 까지 출력해보기
    public static void main(String[] args) {
        int num = 100;
        for (int i = 2; i <= 10; i++) {
            System.out.println(i+"를 제외한 "+i+"의 배수들");
            for (int j = 2*i; j <=100 ; j+=i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
