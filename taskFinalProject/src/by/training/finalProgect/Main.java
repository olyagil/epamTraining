package by.training.finalProgect;

import domain.Role;
import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/library_db" +
            "?useUnicode=true&characterEncoding=UTF-8";
    public static final String DB_USER = "library_user";
    public static final String DB_PASSWORD = "library_password";

    public static final String SELECT = "select `identity`, `login`, " +
            "`password`, " +
            "`role`";


    public static void main(String[] args) {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SELECT);
            List<User> users = new ArrayList<>();
            User user;
            while (rs.next()) {
                user = new User();
                user.setIdentity(rs.getInt("identity"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.getByIdentity(rs.getInt("role")));
                users.add(user);
                System.out.println(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
