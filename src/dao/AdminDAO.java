package dao;

import model.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class AdminDAO {

    private static QueryRunner qr;
    private static String sql;
    private static Connection conn;

    public static Boolean login(String name, String password) {
        qr = new QueryRunner();
        sql = "SELECT * FROM admin WHERE name = ? AND password = ?";
        Admin admin = null;

        try {
            conn = C3P0Util.getConnection();
            qr.query(conn, sql, new BeanHandler<>(Admin.class), name, password);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin != null;
    }

}
