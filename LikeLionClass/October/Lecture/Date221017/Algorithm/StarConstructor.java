package October.Lecture.Date221017.Algorithm;

public class StarConstructor implements Constructor{
    @Override
    public void print(int floor,char ch) {
        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
