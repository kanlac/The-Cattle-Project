package dao;

import model.CattlePOJO;

public interface CattleDao {

    Iterable<CattlePOJO> findAll();

    CattlePOJO find(Long id);

    CattlePOJO createOrUpdate(CattlePOJO cattle);

    boolean delete(Long id);

}
