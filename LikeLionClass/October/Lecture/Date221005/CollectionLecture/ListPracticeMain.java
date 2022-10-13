package October.Lecture.Date221005.CollectionLecture;

import java.util.List;

public class ListPracticeMain {
    public static void main(String[] args) {
        LikeLion2th likeLion2th = new LikeLion2th();

        List<Student> studentObjs = likeLion2th.getStudentsObjsList();


        for (Student studentObj : studentObjs) {
            System.out.println(studentObj);
        }
        System.out.println("데이터의 갯수는 : " + studentObjs.size());

    }
}
