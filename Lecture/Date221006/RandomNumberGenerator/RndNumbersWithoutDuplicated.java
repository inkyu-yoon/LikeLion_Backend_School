package Lecture.Date221006.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class RndNumbersWithoutDuplicated {
    public static void main(String[] args) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        NumberGenerator randomAlphabetGenerator = new RandomAlphabetGenerator();
        Set<Integer> randomNumberSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int r = randomNumberGenerator.generate(10);
            randomNumberSet.add(r);
        }
        for (Integer integer : randomNumberSet) {
            System.out.println(integer);
        }

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
