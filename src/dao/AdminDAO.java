package dao;

import model.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("Duplicates")
public class AdminDAO {

    private QueryRunner run;
    private String sql;
    private Connection conn;

    public Boolean login(String name, String password) {
        run = new QueryRunner();
        sql = "SELECT * FROM admini WHERE username = ? AND password = ?";
        Admin admin = null;

        try {
            conn = C3P0Util.getConnection();
            admin = run.query(conn, sql, new BeanHandler<>(Admin.class), name, password);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin != null;
    }

}
