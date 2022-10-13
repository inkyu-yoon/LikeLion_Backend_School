package October.Lecture.Date221005.CollectionLecture;

import java.util.ArrayList;
import java.util.List;

public class LikeLion2th {
    //멋사자 2기 학생의 이름이 들어있는 LIST를 RETURN 하는 매서드
    //List는 추가할때마다 크기도 늘어난다.
    Names names = new Names();

    public List<Student> getStudentsObjsList() {
        return names.getStudentObjs(); //리스트의 구현체로 ArrayList를 많이 사용
    }
}
