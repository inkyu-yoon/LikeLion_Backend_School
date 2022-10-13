package Assignment.CodeUp1061_1070;

import java.util.Scanner;

public class No_1069 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String [] unit = {"A", "B", "C", "D"};
        String [] grade = {"best!!!","good!!","run!","slowly~"};
        for (int i = 0; i < unit.length; i++) {
            if (a.equals(unit[i])) {
                System.out.println(grade[i]);
                return;
            }
        }
        System.out.println("what?");
    }
}




