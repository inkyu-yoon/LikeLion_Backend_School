package Lecture.Date221006.RandomNumberGenerator;

public class RandomAlphabetGenerator implements NumberGenerator {
    @Override
    public int generate(int num) {
        return (int)(Math.random() * num)+65;
    }
}
