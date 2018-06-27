package dao;

import model.type.Sex;
import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class CattleDAO {

    private static QueryRunner qr;
    private static String sql;
    private static Connection conn;

    public static Boolean append(String number, Sex sex) {
        qr = new QueryRunner();
        sql = "INSERT INTO cattle (number, sex) VALUES (?, ?)";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = qr.update(conn, sql, number, sex.name());
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static Boolean alter(String id, String number, Sex sex) {
        qr = new QueryRunner();
        sql = "UPDATE cattle SET number = ?, sex = ? WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = qr.update(conn, sql, number, sex.name(), id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static Boolean remove(String id) {
        qr = new QueryRunner();
        sql = "DELETE FROM cattle WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = qr.update(conn, sql, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }


}
