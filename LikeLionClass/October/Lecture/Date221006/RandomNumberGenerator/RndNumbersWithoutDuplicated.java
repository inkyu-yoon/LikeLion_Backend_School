package October.Lecture.Date221006.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class RndNumbersWithoutDuplicated {
    public static void main(String[] args) {
        //1. 랜덤 숫자 생성 및 중복 제거하기
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Set<Integer> randomNumberSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int r = randomNumberGenerator.generate(30);
            System.out.println("r = " + r);
            randomNumberSet.add(r);
        }
        System.out.println("============결과============");
        for (Integer integer : randomNumberSet) {
            System.out.print(integer + " ");
        }
        System.out.println();
        //2. 랜덤 알파벳 생성 및 중복 제거
        NumberGenerator randomAlphabetGenerator = new RandomAlphabetGenerator();
        Set<Character> randomAlphabetSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int r = randomAlphabetGenerator.generate(26);
            System.out.println("(char)r = " + (char)r);
            randomAlphabetSet.add((char)r);
        }
        System.out.println("============결과============");
        for (Character character : randomAlphabetSet) {
            System.out.print(character+" ");
        }
    }
}
