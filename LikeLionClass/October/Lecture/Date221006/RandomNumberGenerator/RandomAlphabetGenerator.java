package October.Lecture.Date221006.RandomNumberGenerator;

public class RandomAlphabetGenerator implements NumberGenerator {
    @Override
    public int generate(int num) {
        return (int)(Math.random() * num)+65; //알파벳 대문자 아스키 코드는 65~90 이기 때문에
    }
}
