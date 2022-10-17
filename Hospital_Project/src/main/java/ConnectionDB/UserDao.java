package ConnectionDB;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

/*

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.30'

build.gradle 에 위와 같은 dependency 추가 그리고 build를 함

 */
public class UserDao {
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    //getenv 환경변수를 받아오라는 메서드
    //edit configuration 에서 DB_HOST : jdbc:mysql://[ec2주소]:3306/[db이름]      (db 이름은 스키마 이름과 같다)
    //[DB_HOST=jdbc:mysql://ec2-35-74-245-184.ap-northeast-1.compute.amazonaws.com:3306/LikeLion]
    //DB_USER = root
    //DB_PASSWORD = 패스워드
    private Map<String, String> env;
    private String dbHost, dbUser, dbPassword;
    private Connection conn;
    private PreparedStatement ps;

    public UserDao() throws SQLException {
        env = System.getenv();
        dbHost = env.get("DB_HOST");
        dbUser = env.get("DB_USER");
        dbPassword = env.get("DB_PASSWORD");
        conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

    }


    //위 구문으로 환경변수를 받아와서 설정함
    public void add() throws SQLException, ClassNotFoundException {

        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id,name,password) VALUES(?,?,?)");
        ps.setString(1, "2");
        ps.setString(2, "Yoon");
        ps.setString(3, "1124");


        ps.executeUpdate();
        ps.close();
        conn.close();
        System.out.println("DB insert 완료 되었습니다.");

    }

    public void select() throws ClassNotFoundException, SQLException {


//        ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");

        // 모든 데이터 조회하기
        ps = conn.prepareStatement("SELECT * FROM users ");
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            System.out.printf("id : %s, name : %s, password : %s\n",
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("password"));
        }

    }

    //특정 id 매개변수로 검색
    public void select(String id) throws ClassNotFoundException, SQLException {


//        ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");

        // 모든 데이터 조회하기
        ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);
        ResultSet resultSet = ps.executeQuery();

        resultSet.next();
        System.out.printf("id : %s, name : %s, password : %s\n",
                resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getString("password"));


    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
//        userDao.add();
        userDao.select();
        userDao.select("2");
    }
}
/* 출력화면

id : 1, name : inkyu, password : 1123
id : 2, name : Yoon, password : 1124
id : 2, name : Yoon, password : 1124

 */