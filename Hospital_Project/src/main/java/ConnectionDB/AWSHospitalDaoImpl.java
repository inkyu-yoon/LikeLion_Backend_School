package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class AWSHospitalDaoImpl extends HospitalDaoAbstract {

    private Connection conn;

    public AWSHospitalDaoImpl() throws SQLException {
        this.conn = makeConnection();
    }

    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env=System.getenv();
        return DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));

    }

}

