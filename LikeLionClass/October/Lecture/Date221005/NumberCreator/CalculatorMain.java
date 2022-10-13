package October.Lecture.Date221005.NumberCreator;

public class CalculatorMain {
    public static void main(String[] args) {
        Calculator randomCalculator = new Calculator(new SpecificNumberCreator(3), new RandomNumberCreator());
        System.out.println("랜덤 숫자 생성 계산");
        randomCalculator.allResult();


        Calculator Calculator = new Calculator(new SpecificNumberCreator(5), new SpecificNumberCreator(6));
        System.out.println("직접 주입해서 계산");
        Calculator.allResult();
    }
}


//plus minus multiple divide
class Calculator {
    protected final int num1, num2;

    Calculator(NumberCreator nc1, NumberCreator nc2) {
        this.num1 = nc1.getNum();
        this.num2 = nc2.getNum();
    }

    public void allResult() {
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 + num2 = " + (num1 + num2));
        System.out.println("num1 - num2 = " + (num1 - num2));
        System.out.println("num1 * num2 = " + (num1 * num2));
        try {
            double result = ((double) num1 / num2);

            if (Double.isInfinite(result) || Double.isNaN(result)) {
                throw new ArithmeticException();
            }
            System.out.println("num1 / num2 = " + ((double) num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("===================================");
    }
}

