package Lecture.Date221005.CollectionLecture;

import java.util.List;

public class ListPracticeMain {
    public static void main(String[] args) {
        LikeLion2th likeLion2th = new LikeLion2th();

        List<Student> studentObjs = likeLion2th.getStudentsObjsList();


        for (Student studentobjs : studentObjs) {
            System.out.println(studentobjs);
        }
        System.out.println(studentObjs.size());

    }
}
