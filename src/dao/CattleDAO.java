package dao;

import model.Cattle;
import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class CattleDAO {

    private QueryRunner run;
    private String sql;
    private Connection conn;

    public Boolean append(Cattle cattle) {
        run = new QueryRunner();
        sql = "INSERT INTO cattle (id, sex, birthday, weight, variety, father_id, mother_id, children_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = { cattle.getId(), cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id() };
        int row = 0;

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
        Object[] params = { cattle.getSex(), cattle.getBirthday(), cattle.getWeight(), cattle.getVariety(), cattle.getFather_id(), cattle.getMother_id(), cattle.getChildren_id(), cattle.getId() };
        int row = 0;

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
