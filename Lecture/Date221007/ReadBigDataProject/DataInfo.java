package Lecture.Date221007.ReadBigDataProject;

public class DataInfo {

    private int inCity; //1번째 2개의 데이터
    private int outCity; //7번째 2개의 데이터


    DataInfo() {
        }


    public int getInCity() {
        return inCity;
    }

    public void setInCity(int inCity) {
        this.inCity = inCity;
    }

    public int getOutCity() {
        return outCity;
    }

    public void setOutCity(int outCity) {
        this.outCity = outCity;
    }

    public DataInfo(int inCity, int outCity) {
        this.inCity = inCity;
        this.outCity = outCity;
    }

    @Override
    public String toString() {
        return "DataInfo{" +
                "inCity=" + inCity +
                ", outCity=" + outCity +
                '}';
    }
}
