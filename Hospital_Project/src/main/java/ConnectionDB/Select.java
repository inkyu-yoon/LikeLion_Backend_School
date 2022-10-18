package ConnectionDB;

import java.sql.*;
import java.util.Map;

public class Select implements DoSQL{
    private final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    //getenv 환경변수를 받아오라는 메서드
    //edit configuration 에서 DB_HOST : jdbc:mysql://[ec2주소]:3306/[db이름]      (db 이름은 스키마 이름과 같다)
    //[DB_HOST=jdbc:mysql://ec2-35-74-245-184.ap-northeast-1.compute.amazonaws.com:3306/LikeLion]
    //DB_USER = root
    //DB_PASSWORD = 패스워드
    private String dbHost, dbUser, dbPassword;
    private Connection conn;
    private PreparedStatement ps;

    public Select(Map<String, String> env) throws SQLException {
        env = System.getenv();
        dbHost = env.get("DB_HOST");
        dbUser = env.get("DB_USER");
        dbPassword = env.get("DB_PASSWORD");
        conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);

    }
    @Override
    public void action() throws SQLException {
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
}
