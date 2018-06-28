package dao;

import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class CattleDAO {

    private QueryRunner run;
    private String sql;
    private Connection conn;

    public Boolean append(String number, char sex) {
        run = new QueryRunner();
        sql = "INSERT INTO cattle (number, sex) VALUES (?, ?)";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, number, sex);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public Boolean alter(String id, String number, char sex) {
        run = new QueryRunner();
        sql = "UPDATE cattle SET number = ?, sex = ? WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, number, sex, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public Boolean remove(String id) {
        run = new QueryRunner();
        sql = "DELETE FROM cattle WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }


}
