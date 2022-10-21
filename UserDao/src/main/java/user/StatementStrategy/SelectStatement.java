package user.StatementStrategy;

import user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectStatement implements StatementStrategy{
    String id;

    public SelectStatement(String id) {
        this.id = id;
    }
    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users where id = ?");
        ps.setString(1, id);

        return ps;
    }
}
