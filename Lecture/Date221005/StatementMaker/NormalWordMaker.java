package Lecture.Date221005.StatementMaker;

public class NormalWordMaker implements WordMaker{
    private int num1, num2;
    NormalWordMaker(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    @Override
    public void printStatement(){
        System.out.println(returnWord(num1)+" + "+returnWord(num2)+" = "+returnWord(num1+num2));
    }
    @Override
    public String returnWord(int num) {
        return ""+num;
    }

}
