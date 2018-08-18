package dao.impl;

import dao.CattleDao;
import model.CattlePOJO;
import org.neo4j.ogm.session.Session;
import util.Neo4jSessionFactory;

public class CattleDaoImpl implements CattleDao {

    private Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();

    @Override
    public Iterable<CattlePOJO> findAll() {
        return session.loadAll(CattlePOJO.class);
    }

    @Override
    public CattlePOJO find(Long id) {
        return session.load(CattlePOJO.class, id);
    }

    @Override
    public CattlePOJO createOrUpdate(CattlePOJO cattle) {
        session.save(cattle);
        return find(cattle.getId());
    }

    @Override
    public boolean delete(Long id) {
        session.delete(session.load(CattlePOJO.class, id));
        return find(id) == null;
    }

}
