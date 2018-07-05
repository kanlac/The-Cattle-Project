package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

class Perform {

    private Connection conn;
    private QueryRunner run;

    Boolean update(String sql, Object[] params) {
        int row = 0;
        run = new QueryRunner();

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    List<?> queryBeans(String sql, Object[] params, BeanListHandler<Object> handler) {
        run = new QueryRunner();
        List<Object> result = null;

        try {
            conn = C3P0Util.getConnection();
            result = run.query(conn, sql, handler, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    Object queryBean(String sql, Object[] params, BeanHandler<Object> handler) {
        run = new QueryRunner();
        Object result = null;

        try {
            conn = C3P0Util.getConnection();
            result = run.query(conn, sql, handler, params);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
