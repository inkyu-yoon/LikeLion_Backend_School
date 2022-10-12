package Lecture.Date221012.Algorithm;

interface Calculate {
    double action(double input1, double input2);
}

public class Calculate4Method {
    private double getValue(double input1, double input2, Calculate calculate) {

        return calculate.action(input1, input2);
    }

    public double add(double input1, double input2) {
        System.out.print(input1 + " + " + input2 + " = ");
        return getValue(input1, input2, new Calculate() {
            @Override
            public double action(double input1, double input2) {
                return input1 + input2;
            }
        });
    }

    public double sub(double input1, double input2) {
        System.out.print(input1 + " - " + input2 + " = ");
        return getValue(input1, input2, new Calculate() {
            @Override
            public double action(double input1, double input2) {
                return input1 - input2;
            }
        });
    }

    public double mul(double input1, double input2) {
        System.out.print(input1 + " * " + input2 + " = ");
        return getValue(input1, input2, new Calculate() {
            @Override
            public double action(double input1, double input2) {
                return input1 * input2;
            }
        });
    }

    public double div(double input1, double input2) {
        System.out.print(input1 + " / " + input2 + " = ");
        return getValue(input1, input2, new Calculate() {
            @Override
            public double action(double input1, double input2) {
                return input1 / input2;
            }
        });
    }


    public static void main(String[] args) {
        Calculate4Method cal = new Calculate4Method();
        double num1 = 20;
        System.out.println("num1 = " + num1);
        double num2 = 10;
        System.out.println("num2 = " + num2);
        System.out.println(cal.add(num1, num2));
        System.out.println(cal.sub(num1, num2));
        System.out.println(cal.mul(num1, num2));
        System.out.println(cal.div(num1, num2));
    }
}