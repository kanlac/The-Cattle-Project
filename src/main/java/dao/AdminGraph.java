package dao;

import org.neo4j.driver.v1.*;

import static config.Constants.*;

public class AdminGraph {

    Driver driver;

    public AdminGraph() {
        driver = GraphDatabase.driver(neo4j_uri, AuthTokens.basic(neo4j_user, neo4j_password));
    }

    public Boolean login(String name, String password) {
        try (Session session = driver.session()) {
            StatementResult res = session.run("MATCH (u:Admin) WHERE u.name = {name} AND u.password = {password} RETURN u", Values.parameters("name", name, "password", password));
            if (res.hasNext()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AdminGraph dao = new AdminGraph();
        if (dao.login("吴", "655")) {
            System.out.println("success..");
        } else {
            System.out.println("fail..");
        }
    }

}
