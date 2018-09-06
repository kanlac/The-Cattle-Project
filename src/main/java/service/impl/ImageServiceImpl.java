package service.impl;

import model.ImagePOJO;
import service.GenericService;

public class ImageServiceImpl implements GenericService<ImagePOJO> {

    @Override
    public Iterable<ImagePOJO> findAll() {
        return session.loadAll(ImagePOJO.class);
    }

    @Override
    public ImagePOJO find(Long id) {
        return session.load(ImagePOJO.class, id);
    }

    @Override
    public ImagePOJO createOrUpdate(ImagePOJO admin) {
        session.save(admin);
        return find(admin.getId());
    }

    @Override
    public boolean delete(Long id) {
        session.delete(session.load(ImagePOJO.class, id));
        return find(id) == null;
    }

}
