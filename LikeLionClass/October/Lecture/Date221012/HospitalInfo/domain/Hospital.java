package October.Lecture.Date221012.HospitalInfo.domain;

public class Hospital {
    private String id;
    private String address;
    private String district; //address에서 추출
    private char category;
    private int emergencyRoom;
    private String name;
    private String subdivision; //병원 이름 기준으로 채워보기

    @Override
    public String toString() {
        return "(" + "\'"+ id +"\',"+ "\'"+ address +"\',"+ "\'"+ district +"\',"+ "\'"+ category +"\',"+
                "\'"+ emergencyRoom +"\',"+ "\'"+ name +"\'," + "\'"+ subdivision +"\'"+ ")";
    }

    public Hospital(String id, String address, String district, char category, int emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }
}
