package dao;

import model.CattlePOJO;
import org.neo4j.driver.v1.*;

import java.util.HashMap;
import java.util.HashSet;

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

    private HashSet<CattlePOJO> get(String c_id) {
        HashSet<CattlePOJO> pojoSet = new HashSet<>();
        try (Session session = driver.session()) {
            StatementResult res = session.run("MATCH (target:Cattle) WHERE target.c_id = {c_id} RETURN target.c_id AS c_id, target.sex AS sex, target.birthday AS birthday, target.weight AS weight", Values.parameters("c_id", c_id));
            while (res.hasNext()) {
                Record record = res.next();

                String id = record.get("c_id").asString();
                String sex = record.get("sex").asString();
                String birthday = record.get("birthday").asString();
                String weight = record.get("weight").asString();

                pojoSet.add(new CattlePOJO(id, sex, birthday, weight));
            }
        }
        return pojoSet;
    }

    private HashMap<String, Object> targetGraph(String c_id) {
        return null;
    }

    public void close() {
        driver.close();
    }


    // Test
    public static void main(String[] args) {
        CattleGraph graph = new CattleGraph("bolt://localhost:7687", "neo4j", "123456");
        HashSet<CattlePOJO> res = graph.get("006");
        if (res == null) {
            System.out.println("is null");
        } else {
            for (CattlePOJO c : res) {
                System.out.println(c);
            }
        }
        graph.close();
    }

}
