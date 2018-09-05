package service.impl;

import model.AdminPOJO;
import org.neo4j.driver.v1.Session;
import org.neo4j.ogm.model.Result;
import service.AdminService;
import service.GenericService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminServiceImpl implements GenericService<AdminPOJO>, AdminService {

    @Override
    public Iterable<AdminPOJO> findAll() {
        return session.loadAll(AdminPOJO.class);
    }

    @Override
    public AdminPOJO find(Long id) {
        return session.load(AdminPOJO.class, id);
    }

    @Override
    public AdminPOJO createOrUpdate(AdminPOJO admin) {
        session.save(admin);
        return find(admin.getId());
    }

    @Override
    public boolean delete(Long id) {
        session.delete(session.load(AdminPOJO.class, id));
        return find(id) == null;
    }

    @Override
    public boolean login(String name, String password) {
        String query = "MATCH (u:Admin) WHERE u.name = {n} AND u.password = {p} RETURN u";
        Map<String, Object> params = new HashMap<>();
        params.put("n", name);
        params.put("p", password);
        for (Map<String, Object> i : session.query(query, params))
            return true;
        return false;
    }

}
