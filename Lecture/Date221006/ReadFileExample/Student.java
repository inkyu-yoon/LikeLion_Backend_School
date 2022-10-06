package Lecture.Date221006.ReadFileExample;

public class Student {
    private int id;
    private String hid;
    private int height;

    public Student(int id, String hid, int height) {
        this.id = id;
        this.hid = hid;
        this.height = height;
    }

    @Override
    public String toString(){
        return "id는 "+id+"  || hid는 "+hid+"  || height는 "+height;
    }

}
