package Lecture.Date221006;

import Lecture.Date221005.NumberCreator.RandomNumberCreator;

import java.util.HashSet;
import java.util.Set;

public class RndNumbersWithoutDuplicated {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Set<Integer> randomNumberSet = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int r = randomNumberGenerator.generate(10);
            randomNumberSet.add(r);
        }
        for (Integer integer : randomNumberSet) {
            System.out.println(integer);
        }
    }
}
