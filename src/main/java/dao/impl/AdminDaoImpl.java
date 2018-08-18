package dao.impl;

import dao.AdminDao;
import org.neo4j.driver.v1.*;

import static config.Constants.*;

public class AdminDaoImpl implements AdminDao {

    Driver driver;

    public AdminDaoImpl() {
        driver = GraphDatabase.driver(neo4j_uri, AuthTokens.basic(neo4j_user, neo4j_password));
    }

    @Override
    public boolean login(String name, String password) {
        try (Session session = driver.session()) {
            StatementResult res = session.run("MATCH (u:Admin) WHERE u.name = {n} AND u.password = {p} RETURN u", Values.parameters("n", name, "p", password));
            if (res.hasNext()) return true;
        }
        return false;
    }

    public void close() {
        driver.close();
    }
}
