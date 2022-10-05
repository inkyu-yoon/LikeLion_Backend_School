package Lecture.Date221005.CollectionLecture;

import java.util.ArrayList;
import java.util.List;

public class Names {
    List<Student> studentObjs = new ArrayList<>();
    Names(){
        this.studentObjs.add(new Student(3, "윤인규", "naver.com"));
        this.studentObjs.add(new Student(1, "김철수", "daum.com"));
        this.studentObjs.add(new Student(2, "정짱구", "tistory.com"));
        this.studentObjs.add(new Student(4, "박맹구", "velog.com"));
        this.studentObjs.add(new Student(5, "최유리", "nate.com"));

    }

    public List<Student> getStudentObjs(){
        return studentObjs;
    }

}
