package service.impl;

import model.PostPOJO;
import service.GenericService;

public class PostServiceImpl implements GenericService<PostPOJO> {

    @Override
    public Iterable<PostPOJO> findAll() {
        return session.loadAll(PostPOJO.class);
    }

    @Override
    public PostPOJO find(Long id) {
        return session.load(PostPOJO.class, id);
    }

    @Override
    public PostPOJO createOrUpdate(PostPOJO cattle) {
        session.save(cattle);
        return find(cattle.getId());
    }

    @Override
    public boolean delete(Long id) {
        session.delete(session.load(PostPOJO.class, id));
        return find(id) == null;
    }
}
