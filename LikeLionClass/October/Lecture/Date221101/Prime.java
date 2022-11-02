package October.Lecture.Date221101;

import java.util.Scanner;

public class Prime {
    //에라토스테네스의 체 구현
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        boolean[] primes = new boolean[N+2];
        primes[0]=true;
        primes[1]=true;


        for (int i = 2; i*i <= N ; i++) {
            for (int j = i*i; j <=N ; j+=i) {
                primes[j]=true;
            }
        }

        for (int i = 0; i <= N; i++) {
            if(!primes[i]){
                sb.append(i + " ");
            }
        }

        System.out.println(sb);



    }


}
