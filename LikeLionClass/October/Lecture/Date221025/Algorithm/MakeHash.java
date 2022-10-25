package October.Lecture.Date221025.Algorithm;

public class MakeHash {
    public static void main(String[] args) {
        MakeHash hs = new MakeHash();
        hs.hash("inkyu");
    }

    //입력받은 key를 한글자씩 ascii코드로 바꾼다.
    public int hash(String key) {
        int asciiSum = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int ascii = c;
            System.out.println("c = " + c + "  ascii = " + ascii);
            asciiSum += ascii;
        }
        System.out.println("asciiSum = " + asciiSum);
        return asciiSum % 90;
    }


}
