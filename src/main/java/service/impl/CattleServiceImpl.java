package service.impl;

import model.CattlePOJO;
import service.CattleService;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;

import static model.CattleComparator.*;

public class CattleServiceImpl implements GenericService<CattlePOJO>, CattleService {

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

    @Override
    public ArrayList<CattlePOJO> sortById() {
        return sortAll(byId);
    }

    @Override
    public ArrayList<CattlePOJO> sortByBirthday() {
        return sortAll(byBirthday);
    }

    @Override
    public ArrayList<CattlePOJO> sortByBirthdayDesc() {
        return sortAll(byBirthdayDesc);
    }

    @Override
    public ArrayList<CattlePOJO> sortByWeight() {
        return sortAll(byWeight);
    }

    private ArrayList<CattlePOJO> sortAll(Comparator<CattlePOJO> comparator) {
        ArrayList<CattlePOJO> all = (ArrayList<CattlePOJO>)findAll();
        all.sort(comparator);
        return all;
    }

}
