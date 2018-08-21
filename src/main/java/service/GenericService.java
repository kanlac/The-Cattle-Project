package service;

import org.neo4j.ogm.session.Session;
import util.Neo4jSessionFactory;

public interface GenericService<T> {

    Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    Iterable<T> findAll();

    T find(Long id);

    T createOrUpdate(T object);

    boolean delete(Long id);
}
