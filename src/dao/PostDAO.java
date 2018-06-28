package dao;

import model.Post;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostDAO {

    private QueryRunner run;
    private String sql;
    private Connection conn;

    public List<Post> fetch(int limit) {
        run = new QueryRunner();
        sql = "SELECT * FROM post LIMIT ?";
        List<Post> posts = null;

        try {
            conn = C3P0Util.getConnection();
            posts = run.query(conn, sql, new BeanListHandler<>(Post.class), limit);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return posts;
    }

    public List<Post> fetch() {
        return fetch(100);
    }

    public Post get(String id) {
        run = new QueryRunner();
        sql = "SELECT * FROM post WHERE id = ?";
        Post post = null;

        try {
            conn = C3P0Util.getConnection();
            post = run.query(conn, sql, new BeanHandler<>(Post.class), id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }

    public Boolean alter(String id, String title, String author, String content) {
        run = new QueryRunner();
        sql = "UPDATE post SET title = ?, author = ?, content = ? WHERE id = ?";
        int row = 0;

        try {
            conn = C3P0Util.getConnection();
            row = run.update(conn, sql, title, author, content, id);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public Boolean remove(String id) {
        run = new QueryRunner();
        sql = "DELETE FROM post WHERE id = ?";
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
