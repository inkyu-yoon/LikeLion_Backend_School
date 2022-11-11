package October.Lecture.Date221111;

public class Binary {
    public static void main(String[] args) {
        System.out.println(getBinaryString(9,6));
    }

    static String getBinaryString(int decNum,int size) {

        StringBuilder sb = new StringBuilder();
        while (decNum > 0) {
            sb.append(decNum % 2);
            decNum /= 2;
        }
        while (sb.length() < size) {
            sb.append(0);
        }
        return sb.reverse().toString();

    }
}
