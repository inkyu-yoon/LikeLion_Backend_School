package user.StatementStrategy;

import user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountStatement implements StatementStrategy {

    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement( "SELECT COUNT(*) as count,count(*) as count2 FROM users");
        return ps;
    }
}
