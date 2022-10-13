package October.Lecture.Date221005.StatementMaker;

import java.util.Scanner;


public class StatementMakerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 숫자를 입력하세요");
        int num1 = scanner.nextInt();
        System.out.println("두번째 숫자를 입력하세요");
        int num2 = scanner.nextInt();

        WordMaker wnm = new NormalWordMaker(num1,num2);
        WordMaker wkm = new KoreanWordMaker(num1,num2);
        WordMaker wem = new EnglishWordMaker(num1,num2);

        StatementMaker st = new StatementMaker(wnm, wkm, wem);
        st.print();
    }
}

class StatementMaker{
    WordMaker wm1;
    WordMaker wm2;
    WordMaker wm3;

    StatementMaker(WordMaker wm1,WordMaker wm2,WordMaker wm3){
        this.wm1=wm1;
        this.wm2=wm2;
        this.wm3=wm3;

    }
    void print(){
        wm1.printStatement();
        wm2.printStatement();
        wm3.printStatement();
    }
}