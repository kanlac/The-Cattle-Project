package dao;

import model.Post;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class PostDAO {

    @SuppressWarnings("unchecked")
    public List<Post> fetch(int limit) {
        String sql = "SELECT * FROM post LIMIT ?";
        BeanListHandler<Object> postsHandler = new BeanListHandler<>(Post.class);

        List<?> result;
        result = new Perform().queryBeans(sql, new Object[] { limit }, postsHandler);
        return (List<Post>)result;
    }

    public List<Post> fetch() {
        return fetch(100);
    }

    public Post get(String id) {
        String sql = "SELECT * FROM post WHERE id = ?";
        BeanHandler<Object> postHandler = new BeanHandler<>(Post.class);

        Object result;
        result = new Perform().queryBean(sql, new Object[] { id }, postHandler);
        return (Post)result;
    }

    public Boolean alter(String id, String title, String author, String content) {
        String sql = "UPDATE post SET title = ?, author = ?, content = ? WHERE id = ?";

        return null;
    }

    public Boolean remove(String id) {
        String sql = "DELETE FROM post WHERE id = ?";

        return new Perform().update(sql, new Object[] {id});
    }

}
