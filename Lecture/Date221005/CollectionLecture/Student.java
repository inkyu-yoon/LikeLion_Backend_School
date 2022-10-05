package Lecture.Date221005.CollectionLecture;

public class Student {
    private int classNum;
    private String name;
    private String gitRepositoryAddress;

    public Student(int classNum, String name, String gitRepositoryAddress) {
        this.classNum = classNum;
        this.name = name;
        this.gitRepositoryAddress = gitRepositoryAddress;
    }

    @Override
    public String toString() {
        return "반 번호: " + classNum + "  || 이름 : " + name + "  || 깃허브 주소 : " + gitRepositoryAddress;
    }
}
