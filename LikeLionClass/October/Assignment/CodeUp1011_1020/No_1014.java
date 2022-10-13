package October.Assignment.CodeUp1011_1020;

import java.util.Scanner;

public class No_1014 {
    public static void main(String[] args) {
        //문자 2개가 입력되고, 순서를 바꿔서 출력한다.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char ch1 = input.charAt(0);
        char ch2 = input.charAt(2);

        System.out.println(ch2 + " " + ch1);

    }
}
