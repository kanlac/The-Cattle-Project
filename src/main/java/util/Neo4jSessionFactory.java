package util;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import static config.Constants.*;

public class Neo4jSessionFactory {

    private final static Configuration configuration = new Configuration.Builder()
            .uri(neo4j_uri)
            .credentials(neo4j_user, neo4j_password)
            .build();
    private final static SessionFactory sessionFactory = new SessionFactory(configuration, "model");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
