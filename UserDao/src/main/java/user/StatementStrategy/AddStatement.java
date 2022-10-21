package user.StatementStrategy;

import user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatement implements StatementStrategy{
    User user;

    public AddStatement(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(id,name,password) values(?,?,?)");
        ps.setString(1, this.user.getId());
        ps.setString(2, this.user.getName());
        ps.setString(3, this.user.getPassword());

        return ps;
    }
}
