package October.Lecture.Date221005.Cal;

public class Calculator {
    NumberCreator numberCreator;
    int baseNum;

    public Calculator(NumberCreator numberCreator) {
        this.numberCreator = numberCreator;
        this.baseNum=10;
    }
    //생성자 오버로딩
    public Calculator(NumberCreator numberCreator, int baseNum) {
        this.numberCreator = numberCreator;
        this.baseNum = baseNum;
    }
    //생성자 오버로딩

    void plus(int num) {
        System.out.println(num + numberCreator.create(baseNum));

    }
}
