package dao;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

public class CattleGraph {

    Driver driver;

    public CattleGraph(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));

    }

    private void addCattle(String id, String sex, String birthday, String weight) {
        try (Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("MERGE (a:Cattle {c_id:{c}, sex:{s}, birthday:{b}, weight:{w}})", parameters("c", id, "s", sex, "b", birthday, "w", weight));
                tx.success();
            }
        }
    }

    private void printCattle() {
        try (Session session = driver.session()) {
            StatementResult res = session.run("MATCH (n:Cattle) RETURN n.c_id AS id");
            while (res.hasNext()) {
                Record record = res.next();
                System.out.println(record.get("id").asString());
            }
        }
    }

    public void close() {
        driver.close();
    }


    // Test
    public static void main(String[] args) {
        CattleGraph graph = new CattleGraph("bolt://localhost:7687", "neo4j", "123456");
        graph.printCattle();
        graph.close();
    }

}
