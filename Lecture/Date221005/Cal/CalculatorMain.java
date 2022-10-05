package Lecture.Date221005.Cal;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ByPassNumberCreator());
        calculator.plus(10);
        //기본 베이스 넘버 10 을 사용할 경우

        Calculator calculator2 = new Calculator(new ByPassNumberCreator(),100);
        calculator2.plus(10);
        //베이스 넘버를 100으로 지정한 경우 (오버로딩 되어있기 때문에 두가지 경우 사용 가능)

    }
}
