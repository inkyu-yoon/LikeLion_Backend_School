package October.Lecture.Date221017.Algorithm;

public class DiamondConstructor implements Constructor{
    @Override
    public void print(int floor, char ch) {
        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= floor-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i*2-1; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }

        for (int i = 1; i <= floor-1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (floor-i)*2-1; j++) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }
}
