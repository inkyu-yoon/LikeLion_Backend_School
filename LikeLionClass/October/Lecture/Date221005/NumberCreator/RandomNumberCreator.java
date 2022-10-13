package October.Lecture.Date221005.NumberCreator;

public class RandomNumberCreator implements NumberCreator{
    @Override
    public int getNum(){
        return (int)(Math.random()*10);
    }
}
