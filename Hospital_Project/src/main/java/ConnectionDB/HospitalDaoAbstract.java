package ConnectionDB;

import domain.Hospital;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

/*

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'

build.gradle 에 위와 같은 dependency 추가 그리고 build를 함

 */
public abstract class HospitalDaoAbstract {
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    //getenv 환경변수를 받아오라는 메서드
    //edit configuration 에서 DB_HOST : jdbc:mysql://[ec2주소]:3306/[db이름]      (db 이름은 스키마 이름과 같다)
    //[DB_HOST=jdbc:mysql://ec2-35-74-245-184.ap-northeast-1.compute.amazonaws.com:3306/LikeLion]
    //DB_USER = root
    //DB_PASSWORD = 패스워드
    private Map<String, String> env;

    private Connection conn;
    private PreparedStatement ps;

    public abstract Connection makeConnection() throws SQLException;

    public HospitalDaoAbstract() throws SQLException {
        env = System.getenv();
        this.conn = makeConnection();
    }


    //위 구문으로 환경변수를 받아와서 설정함
    public void add(Hospital hospital) throws SQLException, ClassNotFoundException {
        //emergencyroom 만 int
        PreparedStatement ps = conn.prepareStatement("INSERT INTO `LikeLion`.`Hospital`(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES (?,?,?,?,?,?,?);");
        //('A1121066','서울특별시 영등포구 국회대로 612 코레일유통 사옥 20층 (당산동3가)','서울특별시 영등포구','C','2','근로복지공단서울의원','외과 , 소아 , 교정 , 관절 , 봉합 , '),
        ps.setString(1, hospital.getId());
        ps.setString(2, hospital.getAddress());
        ps.setString(3, hospital.getDistrict());
        ps.setString(4, hospital.getCategory());
        ps.setString(5, String.valueOf(hospital.getEmergencyRoom()));
        ps.setString(6, hospital.getName());
        ps.setString(7, hospital.getSubdivision());


        ps.executeUpdate();
        ps.close();

        System.out.println("DB insert 완료 되었습니다.");

    }

    public void select() throws ClassNotFoundException, SQLException {

        // 모든 데이터 조회하기
        ps = conn.prepareStatement("SELECT * FROM Hospital ");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            System.out.printf("id : %s, address : %s, district : %s, category : %s,\n emergency_room : %s, name : %s, subdivision : %s",
                    resultSet.getString("id"),
                    resultSet.getString("address"),
                    resultSet.getString("district"),
                    resultSet.getString("category"),
                    resultSet.getString("emergency_room"),
                    resultSet.getString("name"),
                    resultSet.getString("subdivision"));
        }

    }

    //특정 id 매개변수로 검색
    public void select(String id) throws ClassNotFoundException, SQLException {


        ps = conn.prepareStatement("SELECT * FROM Hospital  WHERE id = ?");
        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();

        //먼저 next() 를 사용해서 읽어들일 데이터가 있나 없나 확인하는 용도
        resultSet.next();
        System.out.printf("id : %s, name : %s, password : %s\n",
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("password"));


    }

    public Hospital selectById(String id) throws ClassNotFoundException, SQLException {


        // 모든 데이터 조회하기
        ps = conn.prepareStatement("SELECT * FROM Hospital  WHERE id = ?");
        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();

        //먼저 next() 를 사용해서 읽어들일 데이터가 있나 없나 확인하는 용도
        resultSet.next();
        Hospital hospital = new Hospital(resultSet.getString("id"),
                resultSet.getString("address"),
                resultSet.getString("district"),
                resultSet.getString("category"),
                Integer.valueOf(resultSet.getString("emergency_room")),
                resultSet.getString("name"),
                resultSet.getString("subdivision"));

        return hospital;

    }

//    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//        HospitalDaoAbstract hospitalDao = new HospitalDaoAbstract();
//        Hospital hospital = new Hospital("B1121066", "서울특별시 영등포구 국회대로 612 코레일유통 사옥 20층 (당산동3가)",
//                "서울특별시 영등포구", "C", 2, "근로복지공단서울의원", "외과 , 소아 , 교정 , 관절 , 봉합 , ");
//
//        hospitalDao.add(hospital);
////        userDao.select();
////        userDao.select("2");
//
//    }

}
