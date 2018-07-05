package dao;

import model.Cattle;
import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

@SuppressWarnings("Duplicates")
public class CattleDAO {

    private QueryRunner run;
    private String sql;
    private Object[] params;
    private int row;
    private Connection conn;

    public Boolean append(Cattle cattle) {
        run = new QueryRunner();
        sql = "INSERT INTO cattle (id, sex, birthday, weight, variety, father_id, mother_id, children_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        params = new Object[] { cattle.getId(), cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id() };
        row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public Cattle get(String id) {
        return new Cattle();
    }

    public Boolean alter(Cattle cattle) {
        run = new QueryRunner();
        sql = "UPDATE cattle SET sex = ?, birthday = ?, weight = ?, variety = ?, father_id = ?, mother_id = ?, children_id = ? WHERE id = ?";
        params = new Object[] { cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id(), cattle.getId() };
        row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public Boolean remove(String id) {
        run = new QueryRunner();
        sql = "DELETE FROM cattle WHERE id = ?";
        params = new Object[] { id };
        row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }


}
