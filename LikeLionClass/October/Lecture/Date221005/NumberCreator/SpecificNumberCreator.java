package October.Lecture.Date221005.NumberCreator;

public class SpecificNumberCreator implements NumberCreator {
    private final int num;
    SpecificNumberCreator(int num){
        this.num=num;

    }
    @Override
    public int getNum(){
        return num;
    }
}
