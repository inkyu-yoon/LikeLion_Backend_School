package domain;

public class Hospital {
    private String id;

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public char getCategory() {
        return category;
    }

    public int getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

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

    public Hospital(String id, String address) {
        this.id = id;
        this.address = address;
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