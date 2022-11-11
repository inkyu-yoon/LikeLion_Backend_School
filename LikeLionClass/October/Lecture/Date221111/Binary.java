package October.Lecture.Date221111;

public class Binary {
    public static void main(String[] args) {
        System.out.println(getBinaryString(25));
    }

    static String getBinaryString(int decNum) {

        StringBuilder sb = new StringBuilder();
        while (decNum > 0) {
            sb.append(decNum % 2);
            decNum /= 2;
        }
        return sb.reverse().toString();

    }
}
