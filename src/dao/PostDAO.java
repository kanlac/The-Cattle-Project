package dao;

import model.Post;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostDAO {

    private static QueryRunner qr;
    private static String sql;
    private static Connection conn;

    public static List<Post> fetch(int limit) {
        qr = new QueryRunner();
        sql = "SELECT * FROM post LIMIT ?";
        List<Post> posts = null;

        try {
            conn = C3P0Util.getConnection();
            qr.query(conn, sql, new BeanListHandler<>(Post.class), limit);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public static List<Post> fetch() {
        return fetch(100);
    }

    public static Boolean alter(String id, String title, String author, String content) {
        qr = new QueryRunner();
        sql = "UPDATE post SET title = ?, author = ?, content = ? WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            qr.update(conn, sql, title, author, content, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static Boolean remove(String id) {
        qr = new QueryRunner();
        sql = "DELETE FROM post WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            qr.update(conn, sql, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

}
